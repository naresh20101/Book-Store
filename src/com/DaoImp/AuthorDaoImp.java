package com.DaoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Dao.AuthorDao;
import com.Model.Author;
import com.Model.User;
import com.dbManager.HibernateConnection;

public class AuthorDaoImp implements AuthorDao{

	@Override
	public Integer addAuthor(Author author) {
		int row=0;
		try {
		SessionFactory factory=HibernateConnection.getConnection();
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		
		session.save(author);
		t.commit();
		//factory.close();
		session.close();}
		
		 catch(Exception e)
        {
            e.printStackTrace();
        }
			
      
		return row;
	}

	@Override
	public List<Author> getAuthors() {
		List<Author> list=new ArrayList<>(); 
		try
        {
            
			SessionFactory factory=HibernateConnection.getConnection();
			Session session = factory.openSession();  
			Transaction t = session.beginTransaction();
			list = session.createQuery("From author").list();
			t.commit();
			//factory.close();
			session.close();
			
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public void deleteAuthor(Integer id) {
		// TODO Auto-generated method stub

		try
		{
		SessionFactory factory=HibernateConnection.getConnection();
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		Author author=new Author();
		author=session.get(Author.class, id);
		session.remove(author);
		t.commit();
		//factory.close();
		session.close();
		}
		 catch(Exception e)
        {
            e.printStackTrace();
        }
		
	}

	@Override
	public Integer getIdByAuthor(String author_name) {
		Integer Id = 0;
	    Author u= null;
		try {
		SessionFactory factory=HibernateConnection.getConnection();
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		
		
		Query query = session.createQuery("from author a where a.author_name=:n");
		query.setParameter("n",author_name);
		
		List list = query.list();
		
		u = (Author) list.get(0);
		
		
		
		//Id=s.getId();
		
		t.commit();
		//factory.close();
		session.close();
		}
		 catch(Exception e)
        {
            e.printStackTrace();
        }
		
       
	return u.getAuthorId();
	}

	@Override
	public Author getAuthorById(int id) {
		Author author=new Author();
		try{
			SessionFactory factory=HibernateConnection.getConnection();
		    Session session = factory.openSession();  
		    Transaction t = session.beginTransaction(); 
	     	author=session.get(Author.class, id);
		    t.commit();
			//factory.close();
			session.close();
			}
		 catch(Exception e)
	        {
	            e.printStackTrace();
	        }
			return author;
	}

	@Override
	public Integer updateAuthor(Author author) {
		int status=0;
		try {
		SessionFactory factory=HibernateConnection.getConnection();
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		
	    
	    session.update(author);
	    t.commit();
		//factory.close();
		session.close();}
		 catch(Exception e)
        {
            e.printStackTrace();
        }
		
			
			return status;
	}

}
