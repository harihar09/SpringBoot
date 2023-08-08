package com.springboot.demo.spring.boot.demo.service;

import com.springboot.demo.spring.boot.demo.entity.Department;
import com.springboot.demo.spring.boot.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    // mock the repository layer here using @MockBean annotation
    @MockBean // this will mock the bean automatically
    private DepartmentRepository departmentRepository;

    @BeforeEach
        // this will be called before each test case method
    void setUp() {
        // all the dummy objects creation and mocking goes here
        Department department = Department.builder()
                .id(1L)
                .name("testDepartment")
                .address("test address")
                .build();
        Mockito.when(departmentRepository.findById(1L))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("get valid department Id") // will be displayed in reports
    @Disabled // this will be skied when running all test suitcases
    public void whenValidDepartmentId_thenDepartmentShouldFound() {
        Long departmentId = 1L;
        Department actualDepartment = departmentService.fetchDepartmentById(departmentId);
        assertEquals(departmentId, actualDepartment.getId());


    }
}