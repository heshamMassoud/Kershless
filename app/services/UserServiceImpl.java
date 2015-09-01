package services;

import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import models.User;

public class UserServiceImpl implements UserService {
	
	private MongoOperations mongoOperations;
	private static final Class<User> CURRENT_CLASS = User.class;
	
	public UserServiceImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<User> getAll() {
		return mongoOperations.findAll(CURRENT_CLASS);
	}

	@Override
	public void save(User user) {
		mongoOperations.save(user);
	}

	@Override
	public void delete(User user) {
		mongoOperations.remove(user);
	}

	@Override
	public User findById(String id) {
		return mongoOperations.findById(id, CURRENT_CLASS);
	}

}
