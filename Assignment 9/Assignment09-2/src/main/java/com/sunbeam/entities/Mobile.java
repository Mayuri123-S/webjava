package com.sunbeam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mname;
	private int ram;
	private int storage;
	private String company;
	private double price;
	private String image;
}
