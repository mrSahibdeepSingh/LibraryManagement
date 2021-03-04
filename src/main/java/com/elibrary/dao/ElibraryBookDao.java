package com.elibrary.dao;

import java.util.List;

import com.elibrary.beans.BookBean;
import com.elibrary.beans.IssueBookBean;

public interface ElibraryBookDao {

	public boolean save(BookBean book);
	
	public List<BookBean> viewBooks();
	
	public boolean checkIssue(String callNo);
	
	public boolean issueBook(IssueBookBean issueBook);
	
	public List<IssueBookBean> viewIssuedBooks();
	
	public int delete(String callNo);
}
