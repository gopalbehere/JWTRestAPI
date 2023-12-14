package com.smm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smm.Entity.Student;
import com.smm.Service.StudentService;
import com.smm.Model.StudentDTO;
import com.smm.Util.Converter;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import java.util.stream.Collectors;

//import jakarta.validation.Valid;

@RestController
public class StudentController {
    @Autowired
    StudentService ser;
    
    @Autowired
	Converter cr;
/*
    @PostMapping("/api/createStudent") 
	// @RequestBody annotation converts the json to object and store into database
	StudentDTO createStudent(@Validated @RequestBody StudentDTO sd,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Validation errors occurred, handle them here
            System.out.println(ResponseEntity.badRequest().body("Validation failed: " + bindingResult.getAllErrors()));
            return null;
        } else {
            // Proceed with creating the user since validation passed
            // Your logic here to create the user
        	
        	System.out.println(ResponseEntity.ok("User created successfully"));
        	Student s = cr.convertToStudentEntity(sd);
    		return ser.createStudent(s);
        }
		
	}
    
*/
    
    @PostMapping("/api/createStudent") 
    ResponseEntity<?> createStudent(@Validated @RequestBody StudentDTO sd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Validation errors occurred, handle them here
        	List<String> errors = bindingResult.getAllErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
        	 return ResponseEntity.badRequest().body("Validation failed: " + errors);
        	 } else {
            // Proceed with creating the user since validation passed
            // Your logic here to create the user
            Student s = cr.convertToStudentEntity(sd);
            StudentDTO createdStudent = ser.createStudent(s);
            if (createdStudent != null) {
                return ResponseEntity.ok(createdStudent); // Return the created student DTO
            } else {
                // Handle the case where the student creation failed
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create student");
            }
        }
    }

    
    
    @GetMapping("/getStudent")
    List<StudentDTO> getStudents() {
        return ser.getStudents();
        
    }
    
    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudentById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return ser.getStudentById(id);
	}
    
    @PutMapping("/updateStudent/{id}")
    public StudentDTO updateStudent(@Validated @PathVariable int id, @RequestBody Student updatedStudent) {
        
    	return  ser.updateStudent(id, updatedStudent);
    	/*
    	Student updated = ser.updateStudent(id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
        */
    }
}


