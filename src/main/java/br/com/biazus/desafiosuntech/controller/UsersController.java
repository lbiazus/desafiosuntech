package br.com.biazus.desafiosuntech.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.biazus.desafiosuntech.domain.model.users.entity.UsersDTO;
import br.com.biazus.desafiosuntech.domain.model.users.service.UsersService;
import br.com.biazus.desafiosuntech.exception.users.UserNotFoundException;

@Controller
@RequestMapping(path="/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("users/users-list");
		modelAndView.addObject("users", usersService.findAllUsers());
		modelAndView.addObject("user", new UsersDTO());
		
		return modelAndView;
	}
	
	@GetMapping("/search")
	public ModelAndView search(@RequestParam String userName, @RequestParam String name, @RequestParam String email) {
		UsersDTO filtro = new UsersDTO();
		filtro.setUserName(userName);
		filtro.setEmail(email);
		filtro.setName(name);
		
		ModelAndView modelAndView = new ModelAndView("users/users-list");
		modelAndView.addObject("users", usersService.findUsers(filtro));
		modelAndView.addObject("user", filtro);
		
		return modelAndView;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("users/users-form");
		
		try {
			modelAndView.addObject("user", usersService.findBy(id));
		} catch (UserNotFoundException e) {
			modelAndView.addObject("message", e.getMessage());
			modelAndView.addObject("messageType", "warning");
			modelAndView.addObject("user", new UsersDTO());
			
			modelAndView.setViewName("users/users-list");
		} catch (Exception e) {
			modelAndView.addObject("message", "Unable to edit the user!");
			modelAndView.addObject("messageType", "danger");
			modelAndView.addObject("user", new UsersDTO());
		}
	
		return modelAndView;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("users/users-form");
		UsersDTO user = new UsersDTO();
		user.setRegisterDate(new Date());
		user.setIsEnabled(true);
		modelAndView.addObject("user", user);
	
		return modelAndView;
	}
	
	@PostMapping("/save")
	public RedirectView save(UsersDTO user, RedirectAttributes redirectAttributes) {
		UsersDTO userPersisted = new UsersDTO(user);
		String path = "";
		try {
			userPersisted = usersService.save(user);
			
			redirectAttributes.addFlashAttribute("message", "User Saved Successfully");
			redirectAttributes.addFlashAttribute("messageType", "success");
		
			path = "/users/edit/" + userPersisted.getId();
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Unable to save the user!");
			redirectAttributes.addFlashAttribute("messageType", "danger");
			
			path = StringUtils.isEmpty(userPersisted.getId()) ? "/users/new" : "/users/edit/" + userPersisted.getId();
		}
		
		return new RedirectView(path, true);
	}
	
	@PostMapping("/delete")
	public RedirectView delete(UsersDTO user, RedirectAttributes redirectAttributes) {
		String path = "";
		try {
			usersService.delete(user);
			
			redirectAttributes.addFlashAttribute("message", "User Deleted Successfully");
			redirectAttributes.addFlashAttribute("messageType", "success");
			
			path = "/users";
		
		} catch (UserNotFoundException e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			redirectAttributes.addFlashAttribute("messageType", "warning");
			
			path = "/users";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Unable to delete the user!");
			redirectAttributes.addFlashAttribute("messageType", "danger");
			
			path = StringUtils.isEmpty(user.getId()) ? "/users" : "/users/edit/" + user.getId();
		}
		
		return new RedirectView(path, true);
	}
}
	