package com.example.item_reservation_api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "備品")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "備品ID")
    private int id;

    @Column(name = "備品名")
    private String name;

    @Column(name = "在庫数")
    private int stock;

    @Column(name = "カテゴリID")
    private int categoryId;
}
