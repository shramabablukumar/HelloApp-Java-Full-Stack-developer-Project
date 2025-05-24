package com.example.demo.GreetingControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GreetingService.GreetingService;
import com.example.demo.model.Greeting;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/greetings")
public class GreetingController {
	@Autowired
	private GreetingService greetingservice;
	
	// getall Data
	
	@GetMapping
	public List<Greeting>getAll(){
		List<Greeting> allGreeting = greetingservice.getAllGreeting();
		System.out.println(allGreeting);
		return allGreeting;
		
		
	}
	//get By Id
	@GetMapping("/{id}")
	public Greeting GetById(@PathVariable("id")Long id) {
		Greeting greetingById = greetingservice.getGreetingById(id);
		System.out.println(greetingById);
		return greetingById;
		
		
	}
	// crate the Data
	@PostMapping
	public Greeting CreateGreeting(@RequestBody Greeting greeting) {
		Greeting saveGreeting = greetingservice.SaveGreeting(greeting);
		System.out.println(saveGreeting);
		return saveGreeting;
		
	}
	@PutMapping("/{id}")
	public Greeting updateGreeting(@PathVariable("id")Long id,@RequestBody Greeting greeting) {
		Greeting updateGreeting = greetingservice.updateGreeting(id, greeting);
		System.out.println(updateGreeting);
		return updateGreeting;
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		greetingservice.deleteGreeting(id);
		
	}
	
	

}
