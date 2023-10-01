package com.etiya.rentacar.entities.concretes;

import lombok.*;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand{
    @Id //-> primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // idyi (primary keyi) otomatik artıran kod satırı
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "brand")
    List<Model> models;

}
//brand--> id,name,quantity
//getallbrandresponsew-->id,name listedeki id ve nameler buraya atılır buna MAPPING denir
//NationalId
