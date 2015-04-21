package com.angular.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import com.angular.entity.*;




public class FavorDAO implements IFavorDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public void saveFavor(Favor favor) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(favor);
		s.getTransaction().commit();
		s.close();
	}
	
	@Override
	@Transactional
	public void deleteFavor(Favor favor) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(favor);
		s.getTransaction().commit();
		s.close();
		
	}
//	return1��ʾ���book��favor���д���
	@Override
	public boolean checkFavor(Favor favor) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		Favor book1=(Favor)s.get(Favor.class, favor);
		
		s.getTransaction().commit();
		return(book1!=null);
	}
	
//	4.20 20��28
//	ע��˴�HQL�ʹ��ݲ����ĸ�ʽ��ֻ����hibernate��query����EclipseLink�в�ͬ
//	@RequestMapping(value="/findFavoriteBookByUser/{username}")
//	favor.userID��favor.bookIDҪע������ݿ��е���������һ�£�ע���Сд
	@Override
	public List<String> findFavoriteBookByUser(String userid) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "select favor.bookID "
				+ "from Favor favor "
				+ "where favor.userID=" + "'"+userid+"'";
		Query query = s.createQuery(hql);
		return (List<String>)query.list();
		
//		List<String> bookIdList = new ArrayList();
//		for (Book book : books) {
//			bookIdList.add(book.getId());
//		}
//		
//		return bookIdList;
	}
	
	@Override
	public List<String> findUserByFavoriteBook(String bookid) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "select favor.userID "
				+ "from Favor favor "
				+ "where favor.bookID=" + "'"+bookid+"'";
		Query query = s.createQuery(hql);
		return (List<String>)query.list();
	}

}
