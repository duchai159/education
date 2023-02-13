package com.dhai.education.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends User{
    private Double salary;
}
