package com.payu.payuClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String name;
    private String isbnNumber;
    private LocalDate date;
    private double price;
    private String bookType;
}
