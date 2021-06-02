package com.Dao;

import java.util.List;

import com.Model.Author;

public interface AuthorDao {
	public Integer addAuthor(Author author);
	public List<Author> getAuthors();
	public void deleteAuthor(Integer id);
	public Integer getIdByAuthor(String author_name);
    public Author getAuthorById(int id);
    public Integer updateAuthor(Author author);

}
