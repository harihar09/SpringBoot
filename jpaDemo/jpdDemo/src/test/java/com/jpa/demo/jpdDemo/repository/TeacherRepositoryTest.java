package com.jpa.demo.jpdDemo.repository;

import com.jpa.demo.jpdDemo.entity.Course;
import com.jpa.demo.jpdDemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    // save teacher test
    @Test
    public void saveTeacher() {

        Course course1 = Course.builder()
                .title("DB")
                .credit(5)
                .build();
        Course courses2 = Course.builder()
                .title("C++")
                .credit(5)
                .build();
        Course courses3 = Course.builder()
                .title("JAVA")
                .credit(10)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("mark")
                        .lastName("hugues")
                      //  .courses(List.of(course1,courses2,courses3))
                        .build();

        teacherRepository.save(teacher);
    }

}