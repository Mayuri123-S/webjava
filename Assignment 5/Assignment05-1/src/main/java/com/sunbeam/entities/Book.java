package com.sunbeam.entities;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class Book {
    private int id;
    private String name;
    private String author;
    private String subject;
    private double price;
}
