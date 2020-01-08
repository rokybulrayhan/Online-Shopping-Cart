package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.example.demo"})
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Employee> listStudents = employeeService.listAll();
		model.addAttribute("listStudents", listStudents);
		return "index";
	}

	/*
	 * @GetMapping("/users") public List<Employee> AllList(){ return
	 * employeeService.listAll(); }
	 * 
	 * @PutMapping("/save") public void save(Employee employee) {
	 * employeeService.save(employee); }
	 */
	/*
	 * @RequestMapping("/") public String viewHomepage(Model model) { List<Employee>
	 * listStudents = employeeService.listAll(); model.addAttribute("listStudents",
	 * listStudents); return "index"; }
	 */

	@GetMapping("/users")
	public List<Employee> AllList() {
		return employeeService.listAll();
	}

	@PostMapping("/save")
	@ResponseBody
	public void save(@RequestBody Employee employee) {
		employeeService.save(employee);
	}

	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * saveStudentInfo(@ModelAttribute("student") Employee student) {
	 * employeeService.save(student); return "redirect:/"; }
	 */

	/*
	 * @Autowired private StudentService service;
	 * 
	 * @RequestMapping("/") public String viewHomepage(Model model) { List<Student>
	 * listStudents = service.listAll();
	 * model.addAttribute("listStudents",listStudents); return "index"; }
	 * 
	 * @RequestMapping("/new") public String showNewStudentInfo(Model model) {
	 * Student student = new Student(); model.addAttribute("student", student);
	 * return "new_student"; }
	 * 
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * saveStudentInfo(@ModelAttribute("student") Student student) {
	 * service.save(student); return "redirect:/"; }
	 * 
	 * @RequestMapping("/edit/{id}") public ModelAndView
	 * editStudentInfo(@PathVariable(name = "id") int id) { ModelAndView mav = new
	 * ModelAndView("edit_student"); Student student = service.get(id);
	 * mav.addObject("student",student);
	 * 
	 * return mav; }
	 * 
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public String
	 * updateStudentInfo(@ModelAttribute("student") Student student) {
	 * service.save(student); return "redirect:/"; }
	 * 
	 * @RequestMapping("/delete/{id}") public String
	 * deleteStudentInfo(@PathVariable(name = "id") int id) { service.delete(id);
	 * return "redirect:/"; }
	 */

}
