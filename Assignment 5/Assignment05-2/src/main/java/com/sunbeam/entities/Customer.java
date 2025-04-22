package com.sunbeam.entities;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Customer {
    private int id;
    private String name;
    private String password;
    private String mobile;
    private String address;
    private String email;
    private LocalDate birth;
}
