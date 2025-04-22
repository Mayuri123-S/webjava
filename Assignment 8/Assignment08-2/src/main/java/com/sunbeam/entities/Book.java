package com.sunbeam.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private int id;
    private String name;
    private String author;
    private String subject;
    private double price;
}
