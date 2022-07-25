package ru.safonovroman.kata.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.safonovroman.kata.springcrud.model.User;
import ru.safonovroman.kata.springcrud.service.UserService;

@Controller
public class UsersController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/users")
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.listUsers());
		return "users";
	}

	@GetMapping(value = "/users/new")
	public String showCreateUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user";
	}

	@PostMapping(value = "/users/new")
	public String createUser(ModelMap model,
							 @RequestParam("email") String email,
							 @RequestParam("firstName") String firstName,
							 @RequestParam("lastName") String lastName) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userService.add(user);
		return showAllUsers(model);
	}

	@GetMapping(value = "/user/{id}")
	public String showUser(ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("user", userService.getUser(id));
		return "user";
	}

	@PostMapping(value = "/user/{id}")
	@Transactional
	public String updateUser(ModelMap model,
							 @PathVariable("id") Long id,
							 @RequestParam("email") String email,
							 @RequestParam("firstName") String firstName,
							 @RequestParam("lastName") String lastName) {
		User user =  userService.getUser(id);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userService.update(user);
		model.addAttribute("user", user);
		return "user";
	}

	@GetMapping(value = "/user/{id}/delete")
	public String deleteUser(ModelMap model, @PathVariable("id") Long id) {
		userService.delete(id);
		return showAllUsers(model);
	}
}