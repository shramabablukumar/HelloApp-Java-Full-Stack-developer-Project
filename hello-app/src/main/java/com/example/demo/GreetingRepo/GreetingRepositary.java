package com.example.demo.GreetingRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Greeting;

public interface GreetingRepositary extends JpaRepository<Greeting,Long> {

}
