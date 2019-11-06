package com.lti.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee emp1 = new Employee();
        
        emp1.setId(101);
        emp1.setName("Shantanu");
        emp1.setSalary(101);
        
        emp1.setId(102);
        emp1.setName("Tejaswini");
        emp1.setSalary(900);
        
        emp1.setId(103);
        emp1.setName("Soham");
        emp1.setSalary(800);
        
        emp1.setId(104);
        emp1.setName(" Vishal");
        emp1.setSalary(5);
        
       
        Configuration config= new Configuration();
        config.configure("hibernate.cfg.xml");
        
        ServiceRegistry serviceRegistryObj = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(serviceRegistryObj);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //for saving emp1 object
        session.save(emp1);
        
        tx.commit();
        
    }
}
