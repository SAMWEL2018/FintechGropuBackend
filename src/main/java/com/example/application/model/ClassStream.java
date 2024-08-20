package com.example.application.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:15
 * Project Application
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_streams")
public class ClassStream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String classStreamName;
}
