package myWB.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.bcel.internal.generic.NEW;

import myWB.dao.DeptDao;
import myWB.dao.EmployeeDao;
import myWB.dao.UserDao;
import myWB.domain.Dept;
import myWB.domain.Employee;
import myWB.domain.User;


@Controller
public class HomeController {
	
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/dept")
	public String dept() {
		Dept dept = deptDao.selectById(1);
		User user = userDao.selectById(1);
		System.out.println(dept.getName()+":"+dept.getRemark()); 
		System.out.println(user.getLoginname()+":"+user.getUsername()); 
		return "home";
	}
	
	@RequestMapping(value="/login")
	public String loginpage() {
		return "login";
	}
	
	@RequestMapping(value="/canLogin")
	public String login(@RequestParam("loginname") String loginname,
			 @RequestParam("password") String password) {
		User user = userDao.selectByLoginnameAndPassword(loginname, password);
		if (user != null) {
			return "home";
		}
		return "login";
	}
	
	@RequestMapping(value="/showEmployees")
	public String show(Model model){
		HashMap<String, Object> params = new HashMap<>();
		List<Employee> employee = employeeDao.selectByPage(params);
		model.addAttribute("emp", employee);
		return "show";
	}
	
	@RequestMapping(value="/register" ,method=RequestMethod.GET)
	public String showRegisterPage(Model model) {
		//User user = userDao.selectById(1);
		model.addAttribute(new User());
		return "registerForm";
	}
	
	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public String doRegister(@Valid User user,
			Errors errors,
			@RequestPart("picture") MultipartFile picture) throws IllegalStateException, IOException {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		if( user != null) {
			userDao.save(user);
		}
		picture.transferTo(new File("/data/upload" + picture.getOriginalFilename()));
		return "redirect: /myWB/" + user.getUsername();
	}
	
	@RequestMapping(value="/{username}")
	public String showUserInfo(@PathVariable String username,Model model) {
		User user = userDao.selectById(1);
		if (model != null) {
			model.addAttribute(user);
		}
		model.addAttribute("sfa");
		return "home";
	}
}
