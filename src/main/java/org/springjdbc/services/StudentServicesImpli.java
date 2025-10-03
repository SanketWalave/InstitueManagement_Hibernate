package org.springjdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springjdbc.model.Student;
import org.springjdbc.repo.HibernateDb;

@Service
public class StudentServicesImpli implements StudentServices{

    @Autowired
    private HibernateDb hibernateDb;

    @Override
    public boolean save(Student student) {
        return hibernateDb.save(student);
    }
}
