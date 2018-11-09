package com.lhf.exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private int id;
    private String name;
    private int foodsetId;
    private String foodset;
    private double price;
    private double vipprice;
}
