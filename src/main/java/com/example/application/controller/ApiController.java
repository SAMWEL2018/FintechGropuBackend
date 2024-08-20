package com.example.application.controller;

import com.example.application.model.ClassStream;
import com.example.application.model.CustomResponse;
import com.example.application.model.Student;
import com.example.application.service.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:48
 * Project Application
 */
@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ServiceImpl service;

    //1. capture class streams (as in FORM 1A, FORM 1B, FORM 1C)

    @PostMapping(value = "/api/captureStream", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> captureClassStream(@RequestBody ClassStream classStream) {

        return ResponseEntity.status(200).body(service.captureClassStream(classStream));

    }
    // 2. view all the class streams

    @GetMapping(value = "/api/viewAllClassStreams", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> viewAllClassStreams() {

        return ResponseEntity.status(200).body(service.viewAllClassStreams());

    }

    // 3. view a single class stream
    @GetMapping(value = "/api/viewSingleClassStream/{streamName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> viewSingleClassStream(@PathVariable("streamName") String streamName) {

        return ResponseEntity.status(200).body(service.viewSingleClassStream(streamName));

    }

    //4. capture student's data and assign a student to a particular class stream mentioned in (1)

    @PostMapping(value = "/api/captureStudentDataAndAssignStudentToStream", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> captureStudentDataAndAssignStudentToStream(@RequestBody Student student) {

        return ResponseEntity.status(200).body(service.captureStudentDataAndAssignStudentToStream(student));

    }

    // 5. Edit Student's data
    @PostMapping(value = "/api/editStudentData/{studentIdNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editStudentData(@RequestBody Student student, @PathVariable("editStudentData") String studentIdNumber) {
        CustomResponse res = service.editStudentData(student, studentIdNumber);
        return ResponseEntity.status(res.getResponseCode()).body(res);

    }

    // 6. delete studentData
    @PutMapping(value = "/api/deleteStudentData/{studentIdNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudentData(@PathVariable("studentIdNumber") String studentIdNumber) {
        CustomResponse res = service.deleteStudentData(studentIdNumber);
        return ResponseEntity.status(res.getResponseCode()).body(service.deleteStudentData(studentIdNumber));

    }
    // 7. view a single student's data

    @GetMapping(value = "/api/viewSingleStudentData/{studentIdNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> viewSingleStudentData(@PathVariable("studentIdNumber") String studentIdNumber) {

        return ResponseEntity.status(200).body(service.viewSingleStudentData(studentIdNumber));

    }

    // 8. view all the students
    @GetMapping(value = "/api/viewAllStudents", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> viewAllStudents() {

        return ResponseEntity.status(200).body(service.viewAllStudents());

    }
    // view all student belonging to a particular stream name

    @GetMapping(value = "/api/viewStudentForParticularStream/{streamName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> viewStudentForParticularStream(@PathVariable("streamName") String streamName) {

        return ResponseEntity.status(200).body(service.viewStudentForParticularStream(streamName));

    }


}
