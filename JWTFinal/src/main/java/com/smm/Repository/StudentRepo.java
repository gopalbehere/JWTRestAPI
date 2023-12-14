package com.smm.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.smm.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
