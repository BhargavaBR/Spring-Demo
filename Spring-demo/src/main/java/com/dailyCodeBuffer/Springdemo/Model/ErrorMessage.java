package com.dailyCodeBuffer.Springdemo.Model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {

    private HttpStatus status;
    private String message;
}
