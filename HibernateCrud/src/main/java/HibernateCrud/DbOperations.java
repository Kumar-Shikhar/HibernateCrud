/*This class has methods that interact with the database for performing 
the CRUD operation on the records.
Add the following code to it:*/

package HibernateCrud;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.source.annotations.entity.ConfiguredClass;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DbOperations {
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	static Logger logger;

	// This Method Is Used To Create The Hibernate's SessionFactory Object

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class); // configuration is a class
													// in
													// built
		// to remoove depreciation
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();

		// build session factory is depricated
		SessionFactory sessionFactoryObj = cfg.buildSessionFactory(reg); // Sessionfactory
																			// is
		// an interface
		return sessionFactoryObj;

	}

	public static void createRecord() {
		int count = 0;
		Student studentObj;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();
			// Creating Transaction Entities
			for (int j = 10; j <= 15; j++) {
				count = count + 1;
				studentObj = new Student();
				studentObj.setRollNumber(j);
				studentObj.setStudentName("Editor " + j);
				studentObj.setCourse("Bachelor Of Technology");
				sessionObj.save(studentObj);
			}

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			// logger.info("\nSuccessfully Created '" + count +
			// "' Records In The Database!\n");
		} catch (Exception sqlException) {
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
			if (null != sessionObj.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}

	}

	public static void display_recrods() {
		sessionObj = buildSessionFactory().openSession();
		sessionObj.beginTransaction();

		// query to fetch records from db
		Query query = sessionObj.createQuery("from Student");
		List Records = new ArrayList<String>();
		Records = query.list();
		System.out.println("Records from db" + " " + Records);

	}
	 public static void updateRecord(int student_id) {
		 try{
		// Getting Session Object From SessionFactory
         sessionObj = buildSessionFactory().openSession();
         // Getting Transaction Object From Session Object
         sessionObj.beginTransaction();
         

         // Creating Transaction Entity
         Student studobj = (Student) sessionObj.load(Student.class, student_id);
         studobj.setStudentName("updated_user_name");
         studobj.setCourse("updated_course_name");
         sessionObj.update(studobj);
         sessionObj.getTransaction().commit();
         System.out.println("Record_updated_of_ID" + " " + student_id);
		 }
		 catch(Exception sqlException){
			 if(null != sessionObj.getTransaction()) {
	                //logger.info("\n.......Transaction Is Being Rolled Back.......\n");
	                sessionObj.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
		 } finally {
	            if(sessionObj != null) {
	                sessionObj.close();
			 
		 }

	 }	
		 }
	 
	 // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
	    public static void deleteRecord(Integer student_id) {
	        try {
	        	// Getting Session Object From SessionFactory
	            sessionObj = buildSessionFactory().openSession();
	            // Getting Transaction Object From Session Object
	            sessionObj.beginTransaction();
//	            Student studobj = new Student();
//	            studobj.setId(student_id);
//	            sessionObj.delete(studobj);
	            Student ent = (Student) sessionObj.load(Student.class, student_id);
	            sessionObj.delete(ent);
	            sessionObj.getTransaction().commit();
	            
	            
	        }
	        catch(Exception sqlException){
				 if(null != sessionObj.getTransaction()) {
		                //logger.info("\n.......Transaction Is Being Rolled Back.......\n");
		                sessionObj.getTransaction().rollback();
		            }
	    }
	             
}
	    
	    
        public static void GetDetailsById(int student_id){
        	// Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
            
            Student studonj = (Student) sessionObj.load(Student.class,student_id);
            System.out.println(studonj.getStudentName() + studonj.getCourse());
            System.out.println(sessionObj.getEntityName(studonj));
            sessionObj.getTransaction().commit();
        }
         
	    
}
