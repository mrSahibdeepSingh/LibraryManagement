package com.elibrary.dao;

  
public class LibrarianFactory {

	public static ELibrarianDao getLibrarianDao()
	{
		return new LibrarianService();
	}
}
