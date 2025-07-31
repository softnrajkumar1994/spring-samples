package com.example.orm.jpaimplementation;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceConfiguration;

public class JPAImplementationExample {
    public static void main(String args[]) {
        SessionFactory sf = new HibernatePersistenceConfiguration("Bookshelf")
                .managedClass(Book.class)
                .jdbcUrl("jdbc:mysql://localhost:3306/rk_learning?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC")
                .jdbcCredentials("root", "root")
                .jdbcPoolSize(16)
                .showSql(true, true, true)
                .createEntityManagerFactory();

        sf.getSchemaManager().exportMappedObjects(true);
    }
}
