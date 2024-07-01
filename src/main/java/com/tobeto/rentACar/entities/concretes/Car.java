package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "plate")
    private String plate;
    @Column(name = "state") // 1 Available 2- Rented 3- Under Maintenance
    private int state;
    @Column(name = "dailyPrice")
    private double dailyPrice;

    @ManyToOne()
    @JoinColumn(name = "model_id")
    private Model model;

}
