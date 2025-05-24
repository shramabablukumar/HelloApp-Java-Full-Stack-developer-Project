package com.example.demo.GreetingService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.GreetingRepo.GreetingRepositary;
import com.example.demo.model.Greeting;

@Service
public class GreetingService {
	@Autowired
	private GreetingRepositary greetingrepositary;
	//getAllData
	public List<Greeting>getAllGreeting(){
		return greetingrepositary.findAll();
	}
	//getSingleData
	public Greeting getGreetingById(Long id) {
		return greetingrepositary.findById(id).orElse(null);
	}
	//save the data
	public Greeting SaveGreeting(Greeting greeting) {
		return greetingrepositary.save(greeting);
	}
	// update the Greeting
	public Greeting updateGreeting(Long id,Greeting greeting) {
		Optional<Greeting> existing = greetingrepositary.findById(id);
		if(existing.isPresent()) {
			Greeting greetings = existing.get();
			greetings.setMessage(greeting.getMessage());
			return greetingrepositary.save(greetings);
			
			
		}
		return null;
	}
	public void deleteGreeting(long id) {
		greetingrepositary.deleteById(id);
		
	}

}
