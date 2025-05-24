package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String message;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Greeting [id=" + id + ", message=" + message + "]";
	}
	public Greeting(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
