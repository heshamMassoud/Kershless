package services;

import java.util.List;

import models.User;

public interface UserService {
	List<User> getAll();
	void save(User user);
	void delete(User user);
	User findById(String id);
}
