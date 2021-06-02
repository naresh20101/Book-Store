package com.Dao;

import java.util.List;

import com.Model.User;

public interface UserDao {
	public Integer addUser(User user);
	public List<User> getUsers();
	public void deleteUser(Integer id);
	public Integer getIdByUser(String user_name);
    public User getUserById(int id);
    public Integer updateUser(User user);

}
