package com.sunbeam.entities;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String password;
    private String mobile;
    private String address;
    private String email;
    private String birth;
}
