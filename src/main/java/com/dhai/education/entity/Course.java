package com.dhai.education.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Collection<Exam> exams;
    @ManyToMany(mappedBy = "courses")
    private Collection<User> users;
}
