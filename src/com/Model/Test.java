package com.Model;

import com.DaoImp.AuthorDaoImp;
import com.DaoImp.UserDaoImp;

public class Test {
	public static void main(String args[]) {
		Author author=new Author();
		AuthorDaoImp authorDaoImp=new AuthorDaoImp();
		((Author) author).setAuthorName("RobinSharma");
		authorDaoImp.addAuthor(author);
		
	}

}
