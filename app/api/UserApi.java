package api;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.User;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import utils.Response;
import application.Global;

public class UserApi extends Controller {
	private static UserService userService = (UserService) Global.getContext()
			.getBean("userService");

	public static Result users() {
		List<User> allUsers = userService.getAll();
		return ok(Json.toJson(allUsers));
	}

	public static Result user(String id) {
		User user = userService.findById(id + "");
		return ok(Json.toJson(user));
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result createUser() {
		JsonNode json = request().body().asJson();
		String name = json.findPath("name").textValue();
		int age = json.findPath("age").intValue();
		if (name == null) {
			Response response = new Response("Missing parameter [name]", false);
			return badRequest(response.getJSON());
		} else {
			User user = new User(name, age);
			userService.save(user);
			Response response = new Response("Sucesss", true);
			return ok(response.getJSON());
		}
	}

	/*public static Result updateUser(String id) {
		  TODO
		  Implement Update User
	}*/

	public static Result deleteUser(String id) {
		User user = userService.findById(id + "");
		if (user == null) {
			Response response = new Response("User with id='" + id + "' doesn't exist!", false);
			return badRequest(response.getJSON());
		} else {
			userService.delete(user);
			Response response = new Response("Sucesss", true);
			return ok(response.getJSON());
		}
		
	}
}
