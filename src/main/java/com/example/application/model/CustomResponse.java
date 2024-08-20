package com.example.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author samwel.wafula
 * Created on 20/08/2024
 * Time 09:35
 * Project Application
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {

    private int responseCode;
    private String responseDesc;
    private Object data;
}
