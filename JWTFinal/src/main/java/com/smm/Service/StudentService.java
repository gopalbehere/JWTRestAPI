package com.smm.Service;

import java.util.List;

import com.smm.Entity.Student;
import com.smm.Model.StudentDTO;

public interface StudentService {
	
	StudentDTO createStudent(Student st);
	//after creating student on database it will return student object
	
	 List<StudentDTO> getStudents();
	 
	 StudentDTO getStudentById(int id);
	 
	 StudentDTO updateStudent(int id, Student updatedStudent);

	 
	 
}		

