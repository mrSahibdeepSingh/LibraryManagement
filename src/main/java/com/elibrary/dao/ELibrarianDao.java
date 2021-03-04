package com.elibrary.dao;

import java.util.List;

import com.elibrary.beans.LibrarianBean;

/**
 * @author Acer
 *
 */
public interface ELibrarianDao {
	
	public int save(LibrarianBean employee);
	
	public List<LibrarianBean> view(); 
	
	public LibrarianBean viewById(int id);
	
	public int update(LibrarianBean librarian);
	
	public int authenticate(String uname,String password);
	
	public int deleteLibrarian(int id);
}
