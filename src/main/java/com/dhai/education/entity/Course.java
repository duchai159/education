package com.dhai.education.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

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
    private String courseName;
    private String description;
    private Date start;
    private Date end;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Collection<Exam> exams;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    )
    private Collection<User> users;
}
