package com.elibrary.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.elibrary.beans.BookBean;
import com.elibrary.beans.IssueBookBean;
import com.elibrary.connectionUtils.SessionUtils;

public class BookService implements ElibraryBookDao {

	private Session session = SessionUtils.getSession();
	@Override
	public boolean save(BookBean book) 
	{		
		boolean status = false;
		session.beginTransaction();
		
		session.save(book);
		
		String callNo = book.getCallno();

		if(callNo != null)
			status = true;
		
		session.getTransaction().commit();

		return status;
		
	}
	@Override
	public List<BookBean> viewBooks()
	{
		session.beginTransaction();
		Query books = session.createQuery("from BookBean");
		
		List<BookBean> Allbooks =  books.list();
		
		session.getTransaction().commit();
		return Allbooks;
	}
	
	@Override
	public boolean checkIssue(String callNo)
	{
		boolean checkFlag = false;

		try {
			session.beginTransaction();
			
			Query q = session.createQuery("select name from BookBean where callno= :flag and quantity > issued");
			q.setParameter("flag", callNo);
			
			String name = (String)q.uniqueResult();
			
			if(name != null)
				checkFlag = true;
			
			session.getTransaction().commit();
			return checkFlag;

			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return checkFlag;
	}

	@Override
	public boolean issueBook(IssueBookBean issueBook)
	{
		String callno = issueBook.getCallno();
		boolean checkstatus=checkIssue(callno);
 
		boolean issueFlag = false;
		Transaction tx = session.beginTransaction();

		if(checkstatus) 
		{
			session.save(issueBook);
			String stdId = issueBook.getStudentid();
			
			if(stdId != null)
			{
				issueFlag = true;
				updateBookLog(callno);
			}	
				
			
			tx.commit();
			session.close();

			return issueFlag;
			
		}else {
			return false;
		}
		

	}
	
	public void updateBookLog(String callNo) {
		
		BookBean book = new BookBean();
		int a = book.getIssued();
		int x = a + 1;
		String queryString = "update BookBean b set b.issued= :x where b.callno= :Id";
		Query q = session.createQuery(queryString);
		
 		q.setParameter("Id", callNo);
		q.setParameter("x", x);
		
		q.executeUpdate();
	}
	
	@Override
	public List<IssueBookBean> viewIssuedBooks() 
	{
 		session.beginTransaction();
		Query issuedBooks = session.createQuery("from IssueBookBean");
		
		List<IssueBookBean> IssuedBooks =  issuedBooks.list();

		session.getTransaction().commit();
		
		return IssuedBooks;
 	}
	
	
	@Override
	public int delete(String callNo){
		int status=0;
		
		session.beginTransaction();
		
		Query q = session.createQuery("delete from BookBean where callno= :id");
		q.setParameter("id", callNo);
		
		status = q.executeUpdate();
		
		session.getTransaction().commit();
		
		return status;
	}

}
