package org.springjdbc.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "marks")
public class Marks {
    @Id
    private int id;


    @OneToOne
    @JoinColumn(name = "stud_id")
    private Student student;
    private int marks;
    private String subject;

    public Student getStudent() {
        return student;
    }
    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                // print only student id to avoid recursion
                ", studentId=" + (student != null ? student.getId() : "null") +
                '}';
    }


}
