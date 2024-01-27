package net.springboot.javaguides.controller;

import java.awt.image.ColorModel;

import javax.enterprise.inject.Model;
import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import example.springdata.multistore.shop.OrderRepository;
import net.springboot.javaguides.entity.Student;

@ControllerAdvice
@RequestMapping("/students/")
public class StudentController {

	@Autowired
	private OrderRepository studentRepository;	
	
	@GetMapping("showForm")
	public String showStudentForm(Student student) {
		return "add-student";
	}
	
	@GetMapping("list")
	public String students(ColorModel model) {
		model.addAttribute("students", this.studentRepository.findAll());
		return "index";
	}
	
	@PostMapping("add")
	public String addStudent(@Valid Student student, Binding result, Model model) {
		if(result.hasErrors()) {
			return "add-student";
		}
		
		this.studentRepository.save(student);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Student student = ((Object) this.studentRepository.findById(id))
				.orElseThrow(() -> new IllegalArgumentException("Invalid student id : " + id));
		
		((Object) model).addAttribute("student", student);
		return "update-student";
	}
	
	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}
		
		// update student
		studentRepository.save(student);
		
		// get all students ( with update)
		model.addAttribute("students", this.studentRepository.findAll());
		return "index";
	}
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable ("id") long id, Model model) {
		
		Student student = this.studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student id : " + id));
		
		this.studentRepository.delete(student);
		model.addAttribute("students", this.studentRepository.findAll());
		return "index";
		
	}
}
