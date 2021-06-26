package com.teamone.postgres.contracts;

import java.util.List;

import com.teamone.postgres.entity.User;

public interface IUserDAO {

	public boolean insert(User user);

	public User getById(int userId);

	public User getByEmail(String email);

	public List<User> getAll();

	public User update(User user);

	public void delete(int userId);
}
