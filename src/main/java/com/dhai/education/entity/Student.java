package com.dhai.education.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User{
    private String className;
}
