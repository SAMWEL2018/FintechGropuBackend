package com.example.application.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:16
 * Project Application
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentIdNumber;
    private String classStream;
}
