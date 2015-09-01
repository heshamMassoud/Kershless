package controllers;

import application.Global;
import models.User;
import play.*;
import play.mvc.*;
import services.UserService;


public class Application extends Controller {
	
	private static UserService userService = (UserService) Global.getContext().getBean("userService");
	
	public static Result index() {
		//return ok(views.html.index.render("Your new application is ready!"));
		User user = new User("Hesham Massoud", 24);
		userService.save(user);
		return ok(views.html.index.render(userService.getAll().get(0).toString()));
	}
}
