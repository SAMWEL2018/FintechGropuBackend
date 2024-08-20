package com.example.application.repository;

import com.example.application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:17
 * Project Application
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByStudentIdNumber(String studentIdNumber);
    List<Student> findAllByClassStream(String streamName);
}
