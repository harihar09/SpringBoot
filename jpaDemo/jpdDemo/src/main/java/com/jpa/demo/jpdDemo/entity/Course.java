package com.jpa.demo.jpdDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    //  bidirectional mapping
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    // many courses can be taught by one teacher
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacherId")
    private Teacher teacher;

    // many-to-many mapping - many students can opt for many courses
    // and many courses can be chosen by many students
    // this will need another table to keep the track of courseId and studentId

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        } else {
            students.add(student);
        }
    }
}
