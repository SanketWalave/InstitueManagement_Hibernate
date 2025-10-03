package org.springjdbc.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springjdbc.model.Marks;
import org.springjdbc.model.Student;

@Repository
public class HibernateDb implements StudentRepoInter {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();


    @Override
    public boolean save(Student student, Marks mark) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        boolean isSave=false;
        try {
            session.persist(student);
            session.persist(mark);
            transaction.commit();
            isSave=true;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }finally {
            session.close();
        }
        return isSave;
    }
}
