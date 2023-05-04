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
//        em = ... �������� � ������������ EntityManagerFactory � �� ���� ������ ��� �������� ����� EntityManager
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
/*        finally {
            em.close();
        } - ��� ��� ������:
        �� ����� ��������� em ����� ������, � ����� ������� ������ ��� ��������� �����, �� ���� �� ��� ������?
        ��� ��� ��������:
           EntityManagerFactory - ������������ ������, ����������� 1 �� ����� ������ ���������,
           EntityManager - ����������� ������, ����� � ��������� ��������� � ���������,
           ���� ������ EntityManager �������� ��� ��� 1-�� ������, ��� ����� �������, � ������� �� ����������, ����� ������� ���������� �������,
           ����� ����������� EntityManager - ��� ������������� ��������� � �������� � ���� ������������ � ���� ������, �� ��� ����� ^^^ ����������� commit() ����� ���������� � ������ � ������ ����������� �������������(����� ��).
        ����� ������� ���� � �� ��������� EntityManager ��� ���� ����������� ������� ������� ��� �� �����? ��� �������?
        */

    }

    public void save(Student student){
        transactional(em -> em.persist(student));
    }

    public void remove(Student student){
        Student s = findById(student.getId()); // ����������� �� ������ ��������� ������� ������� � ���� ����� ��������� ��� ��� � �������� ������ ������ (���� ��� ��� - ������� ������������ � ���)?
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
