package com.jpa.demo.jpdDemo.repository;

import com.jpa.demo.jpdDemo.entity.Course;
import com.jpa.demo.jpdDemo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    // save and test course material method
    @Test
    public void saveCourseMaterialTest() {
        // build course and course material objects and save it
        Course course = Course.builder()
                .title("math")
                .credit(10)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.javacodebyhs.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    // test fetch type
    @Test
    public void printAllCourseMaterials(){
        System.out.println("course materials and Course "+courseMaterialRepository.findAll());
    }

}