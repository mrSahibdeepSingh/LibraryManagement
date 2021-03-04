package com.elibrary.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.elibrary.beans.LibrarianBean;
import com.elibrary.connectionUtils.DB;
import com.elibrary.connectionUtils.SessionUtils;

public class LibrarianService implements ELibrarianDao {

	private Session session = SessionUtils.getSession();
	@Override
	public int save(LibrarianBean employee) 
	{
		int status=0;
		
 		Transaction tx = session.beginTransaction();
		
		session.save(employee);
		
		tx.commit();
		session.close();
 		 
		return status;
		
 	}

	@Override
	public List<LibrarianBean> view() {
  		
 		session.beginTransaction();
		Query q = session.createQuery("from LibrarianBean");
		List<LibrarianBean> librarians =  q.list();
		
		session.getTransaction().commit();
		return librarians;
	}

	@Override
	public LibrarianBean viewById(int id) {
		
 		session.beginTransaction();
		
 		Query query = session.createQuery("from LibrarianBean where id= :Id");
		query.setParameter("Id", id);
		
		LibrarianBean bean = (LibrarianBean) query.uniqueResult();

		session.getTransaction().commit();
		return bean;
	}
	
	public int update(LibrarianBean librarian) 
	{

		session.beginTransaction();
		
 		int lId = librarian.getId();

		Query q = session.createQuery("update LibrarianBean l set l.name= :newName, l.email= :newMail, l.password= :newPass, l.mobile= :newPhn where l.id= :Id");
		q.setParameter("Id", lId);
		q.setParameter("newName", librarian.getName());
		q.setParameter("newMail", librarian.getEmail());
		q.setParameter("newPass", librarian.getPassword());
		q.setParameter("newPhn", librarian.getMobile());

		
		int res = q.executeUpdate();

		session.getTransaction().commit();
		return res;
		
	}

	@Override
	public int authenticate(String uname, String password) 
	{
		int status = -1;
		
		try {
			String queryString = "select id from LibrarianBean l where l.name= :user and l.password= :pass";
			session.beginTransaction();
			Query q = session.createQuery(queryString);
			q.setParameter("user", uname);
			q.setParameter("pass", password);
			
			status = (int) q.uniqueResult();
			
		}catch (Exception e) {
			status = -1;
		}
			
		session.getTransaction().commit();
		return status;
	}

	@Override
	public int deleteLibrarian(int id) {
		int status=0;
			
			session.beginTransaction();
			
			Query q = session.createQuery("delete from LibrarianBean where id= :Id");
			q.setParameter("Id", id);
			
			status = q.executeUpdate();
			
			session.getTransaction().commit();
			
			return status;

	}
	
	
//	public static int delete(int id){
//		int status=0;
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("delete from e_librarian where id=?");
//			ps.setInt(1,id);
//			status=ps.executeUpdate();
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return status;
//	}

}
