package ssh1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import com.angular.entity.*;
import com.angular.dao.*;

public class FavorDAOTest {
	private SessionFactory sessionFactory;
	@Test
	public void test() {
		
		
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		
		Favor favor = new Favor();
		favor.setBookID("1");
		favor.setUserID("1");
		FavorDAO favorDAO = new FavorDAO();
		favorDAO.saveFavor(favor);
		
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	
	
}
/*
	//1. ����һ�� SessionFactory ����
	private static SessionFactory sessionFactory = null;
	
	@BeforeClass
	public static void beforeClass() {

		Configuration configuration = new Configuration();
	    configuration.configure();

	    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	    .applySettings(configuration.getProperties()).build();
	
		//3).
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	}
	@Test
	public void test() {
		//2. ����һ�� Session ���󣬿������Ϊ���ݿ��connection
		Session session = sessionFactory.openSession();
		
		//3. ��������
		Transaction transaction = session.beginTransaction();
		
		Favor favor = new Favor();
		favor.setBookID("1");
		favor.setUserID("1");
		FavorDAO favorDAO = new FavorDAO();
		favorDAO.saveFavor(favor);

		//5. �ύ���� 
		transaction.commit();
		
		//6. �ر� Session
		session.close();
		
		fail("Not yet implemented");
	}
	
	@AfterClass
	public static void afterClass() {
		
	//7. �ر� SessionFactory ����
//	sessionFactory.close();
	}

*/
