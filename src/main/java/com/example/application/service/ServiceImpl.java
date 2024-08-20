package com.example.application.service;

import com.example.application.model.ClassStream;
import com.example.application.model.CustomResponse;
import com.example.application.model.Student;
import com.example.application.repository.ClassStreamRepository;
import com.example.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:19
 * Project Application
 */
@Service
public class ServiceImpl {

    private final ClassStreamRepository classStreamRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public ServiceImpl(ClassStreamRepository classStreamRepository, StudentRepository studentRepository) {
        this.classStreamRepository = classStreamRepository;
        this.studentRepository = studentRepository;
    }

    //1. capture class streams (as in FORM 1A, FORM 1B, FORM 1C)

    public ClassStream captureClassStream(ClassStream classStream) {
        return classStreamRepository.save(classStream);

    }
    // 2. view all the class streams

    public List<ClassStream> viewAllClassStreams() {
        return classStreamRepository.findAll();
    }

    // 3. view a single class stream
    public ClassStream viewSingleClassStream(String classStreamName) {

        return classStreamRepository.findByClassStreamName(classStreamName);
    }

    //4. capture student's data and assign a student to a particular class stream mentioned in (1)

    public Student captureStudentDataAndAssignStudentToStream(Student student) {
        //todo ------ the student Object has a propertyName of classStream
        Student std = Student.builder()
                .classStream(student.getClassStream()) //here the class Stream data is taken from the received object
                .studentName(student.getStudentName())
                .studentIdNumber(student.getStudentIdNumber())
                .build();

        return studentRepository.save(std);

    }

    // 5. Edit Student's data

    public CustomResponse editStudentData(Student student, String studentIdNumber) {
        //update based on studentIdNumber
        Student std = studentRepository.findByStudentIdNumber(studentIdNumber);
        if (std != null) {
            Student res = studentRepository.save(student);
            return CustomResponse.builder().responseCode(200).responseDesc("Student Data Updated").data(res).build();
        } else {
            return CustomResponse.builder()
                    .responseCode(500)
                    .responseDesc("Student does not exist")
                    .build();
        }
    }

    // 6. delete studentData

    public CustomResponse deleteStudentData(String studentIdNumber) {
        Student std = studentRepository.findByStudentIdNumber(studentIdNumber);
        studentRepository.delete(std);
        return CustomResponse.builder().responseCode(200).responseDesc("Student Deleted").build();
    }

    // 7. view a single student's data
    public Student viewSingleStudentData(String idNumber) {
        return studentRepository.findByStudentIdNumber(idNumber);
    }
    // 8. view all the students

    public List<Student> viewAllStudents() {
        return studentRepository.findAll();
    }

    // view all student belonging to a particular stream name
    public List<Student> viewStudentForParticularStream(String streamName) {
        return studentRepository.findAllByClassStream(streamName);
    }

}
