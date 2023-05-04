package com.gb.interview.homework5_Hibernate;

import com.gb.interview.homework5_Hibernate.model.Student;

import java.util.List;

public interface Dao {

    void save(Student student);

    void remove(Student student);

    void remove(Long id);

    void remove(String name);

    Student findById(Long id);

    Student findByName(String name);

    List<Student> findAll();

    void saveOrUpdate(Student student);

}
