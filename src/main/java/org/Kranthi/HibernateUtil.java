package org.Kranthi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {


        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Course.class);

        return cfg.buildSessionFactory();


    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
