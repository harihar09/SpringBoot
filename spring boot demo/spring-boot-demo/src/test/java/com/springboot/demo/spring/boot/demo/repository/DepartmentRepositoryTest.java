package com.springboot.demo.spring.boot.demo.repository;

import com.springboot.demo.spring.boot.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    // inject required dependencies
    @Autowired
    private DepartmentRepository departmentRepository;

    // for storing and flushing the test data from db
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        // create the department object and test it using testEntityManager
        Department department =
                Department.builder()
                        .name("mechanical")
                        .address("pune")
                        .code("me-cd")
                        .build();
        testEntityManager.persist(department);
    }

    // create test method
    // before this method execution setUp method will be invoked and
    // insert the test data with id 1 in the db
    // So we need to test it with id 1 only
    @Test
    public void findByIdTest() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getName(), "mechanical");

    }


}