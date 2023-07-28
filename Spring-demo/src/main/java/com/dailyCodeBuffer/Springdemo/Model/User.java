package com.dailyCodeBuffer.Springdemo.Model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class User {

    private String Id;
    private String firstName;

    private  String lastName;

    private  String address;


}
