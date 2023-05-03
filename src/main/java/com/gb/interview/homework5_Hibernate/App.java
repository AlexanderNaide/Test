package com.gb.interview.homework5_Hibernate;

import com.gb.interview.homework5_Hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

    private static StudentDao dao;

    public static void main(String[] args) {
        try{

            dao = new StudentDao(ManagerFactory.getEntityManagerFactory().createEntityManager());

            // создание 1000 студентов
            for (int i = 0; i < 1000; i++) {
                Student student = new Student("Student №" + (i + 1));
                dao.save(student);
            }

            // изменение - накидаем 100 произвольным студентам до 50 баллов
            for (int i = 0; i < 100; i++) {
                Student student = dao.findById((long) (Math.random() * 1000) + 1);
                student.setMark((int) (Math.random() * 50) + 1);
                dao.saveOrUpdate(student);
            }

            // поиск по id - достанем студента №10
            System.out.println("Студент id = 10");
            Student st10 = dao.findById(10L);
            System.out.println(st10.getId() + " " + st10.getName() + " баллы: " + st10.getMark());


            // поиск по имени - достанем студента Студент №55
            System.out.println("Студент №55");
            Student st55 = dao.findByName("Student №55");
            System.out.println(st55.getId() + " " + st55.getName() + " баллы: " + st55.getMark());

            // удаление студента - удалим студента с id = 77
            System.out.println("Студент №77");
            Student st77 = dao.findById(77L);
            System.out.println(st77.getId() + " " + st77.getName() + " баллы: " + st77.getMark());
            dao.remove(st77);
            st77 = dao.findById(77L);
            if (st77 == null){
                System.out.println("Отсутствует");
            } else {
                System.out.println(st77.getId() + " " + st77.getName() + " баллы: " + st77.getMark());
            }

            // удаление студента по id - удалим студента с id = 477
            System.out.println("Студент №477");
            Student st477 = dao.findById(477L);
            System.out.println(st477.getId() + " " + st477.getName() + " баллы: " + st477.getMark());
            dao.remove(477L);
            st477 = dao.findById(477L);
            if (st477 == null){
                System.out.println("Отсутствует");
            } else {
                System.out.println(st477.getId() + " " + st477.getName() + " баллы: " + st477.getMark());
            }

            // удаление студента по имени - удалим студента с именем = Студент №677
            System.out.println("Студент №677");
            Student st677 = dao.findByName("Student №677");
            System.out.println(st677.getId() + " " + st677.getName() + " баллы: " + st677.getMark());
            dao.remove("Student №677");
            st677 = dao.findByName("Student №677");
            if (st677 == null){
                System.out.println("Отсутствует");
            } else {
                System.out.println(st677.getId() + " " + st677.getName() + " баллы: " + st677.getMark());
            }


            // Выборка всего списка
            List<Student> studentList = dao.findAll();

            System.out.println("Десятка лучших: ");
            studentList.sort(Comparator.comparing(Student::getMark));
            for (int i = studentList.size() - 1; i > studentList.size() - 11; i--) {
                System.out.println(studentList.get(i).getId() + " " + studentList.get(i).getName() + " баллы: " + studentList.get(i).getMark());
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ManagerFactory.shutdown();
        }
    }
}
