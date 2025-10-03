package org.springjdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springjdbc.config.Config;
import org.springjdbc.exception.HandleException;
import org.springjdbc.model.Marks;
import org.springjdbc.model.Student;
import org.springjdbc.services.StudentServicesImpli;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Scanner  sc=new Scanner(System.in);
        StudentServicesImpli studentServicesImpli=context.getBean(StudentServicesImpli.class);
        HandleException handleException=context.getBean(HandleException.class);


        while (true){
            System.out.println("case 1: add student");
            int choice=handleException.getIntegerInput(sc,"enter your choice");

            switch (choice){
                case 1:
                    Student student = context.getBean(Student.class);
                    student.setId(handleException.getIntegerInput(sc,"enter id"));
                    System.out.println("enter name of student");
                    student.setName(sc.nextLine());
                    student.setAge(handleException.getIntegerInput(sc,"enter age"));
                    if(studentServicesImpli.save(student)){
                        System.out.println("student saved success");
                    }else {
                        System.out.println("some problem is there ");
                    }
                    break;
            }
        }



        // Persist entity

    }
}
/*
     // Load Hibernate config (make sure the file is in resources folder)
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.xml"); // ✅ standard name
//
//        // Build SessionFactory
//        SessionFactory sessionFactory = cfg.buildSessionFactory();
//
//        // Open session & start transaction
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();

        // Get Student bean from Spring context


  session.persist(student);
        session.persist(marks);

        // Commit BEFORE closing
        transaction.commit();

        System.out.println("Student saved successfully!");

        ArrayList<Student> students=(ArrayList<Student>)session.createQuery("from Student",Student.class).getResultList();
        students.forEach(System.out::println);


        System.out.println("\n\n\n\n");
        ArrayList<Marks> marks1=(ArrayList<Marks>)session.createQuery("from Marks",Marks.class).getResultList();
        marks1.forEach(System.out::println);

        // Close resources
        session.close();
        sessionFactory.close();
        context.close();*/