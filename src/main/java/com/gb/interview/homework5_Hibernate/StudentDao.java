package com.gb.interview.homework5_Hibernate;

import com.gb.interview.homework5_Hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.function.Consumer;

public class StudentDao implements Dao{
    private final EntityManager em;

    public StudentDao(EntityManager em) {
        this.em = em;
    }

    private void transactional(Consumer<EntityManager> consumer){
//        em = ... получить в конструкторе EntityManagerFactory и из него каждый раз получать новый EntityManager
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
/*        finally {
            em.close();
        } - вот тут вопрос:
        мы можем закрывать em после метода, а перед методом каждый раз открывать новый, но надо ли это делать?
        Что мне известно:
           EntityManagerFactory - тяжеловесный объект, открывается 1 на время работы программы,
           EntityManager - легковесный объект, можно с легкостью открывать и закрывать,
           пока открыт EntityManager работает его кэш 1-го уровня, где лежат объекты, к которым мы обращались, таким образом экономятся ресурсы,
           когда закрывается EntityManager - все несохраненные изменения у объектов в кэше отправляются в базу данных, НО при такой ^^^ конструкции commit() прямо вызывается в методе и данные сохраняются принудительно(вроде бы).
        Таким образом могу я не закрывать EntityManager или есть объективные причины закрыть его всё равно? Как принято?
        */

    }

    public void save(Student student){
        transactional(em -> em.persist(student));
    }

    public void remove(Student student){
        Student s = findById(student.getId()); // Обязательно ли вообще проверять наличие объекта в базе перед удалением или это в принципе лишняя логика (если его нет - эксепшн обработается и все)?
        if(s != null){
            transactional(em -> em.remove(student));
        }
    }

    public void remove(Long id){
        Student student = findById(id);
        if(student != null){
            transactional(em -> em.remove(student));
        }
    }

    public void remove(String name){
        Student student = findByName(name);
        if(student != null){
            transactional(em -> em.remove(student));
        }
    }

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public Student findByName(String name){
        TypedQuery<Student> query = em.createQuery("select s from Student s where s.name = :name", Student.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    public List<Student> findAll(){
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    public void saveOrUpdate(Student student){
        transactional(em -> em.merge(student));
    }

}
