package com.elibrary.dao;

public class BookFactory {

	public static ElibraryBookDao getLibrarianBookDao()
	{
		return new BookService();
	}
}
