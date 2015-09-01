package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import services.UserService;
import services.UserServiceImpl;

import com.mongodb.MongoClient;


@Configuration
public class SpringConfiguration {
	
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "kershlessDB");
	}
	
	public @Bean(name="mongoTemplate")
	MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
	
	public @Bean(name="userService")
	UserService userService() throws Exception {
		return new UserServiceImpl(mongoTemplate());
	}

}