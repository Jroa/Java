package pe.com.jroa.greeting.service;

import javax.inject.Inject;

import pe.com.jroa.greeting.Greeting;

public class GreetingService {
	@Inject
	Greeting greeting;
	
	public String greet(String name){
		return greeting.greet(name);
	}
}
