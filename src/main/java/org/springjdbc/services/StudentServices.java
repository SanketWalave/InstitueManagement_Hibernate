package org.springjdbc.services;

import org.springjdbc.model.Marks;
import org.springjdbc.model.Student;

public interface StudentServices {
    boolean save(Student student, Marks mark);
}
