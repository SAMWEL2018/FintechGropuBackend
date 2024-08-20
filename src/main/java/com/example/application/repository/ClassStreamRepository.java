package com.example.application.repository;

import com.example.application.model.ClassStream;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:17
 * Project Application
 */
public interface ClassStreamRepository extends JpaRepository<ClassStream,Integer> {
    ClassStream findByClassStreamName(String classStreamName);
}
