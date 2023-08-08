package com.springboot.demo.spring.boot.demo.controller;

import com.springboot.demo.spring.boot.demo.entity.Department;
import com.springboot.demo.spring.boot.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DepartmentControllerTest {
    //  for Controller, we need to use MockMvc bean
    @Autowired
    private MockMvc mockMvc;

    // We need to mock service layer as we are calling it from controller
    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .code("20983091")
                .address("amravati")
                .name("CS")
                .id(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .code("20983091")
                .address("amravati")
                .name("CS")
                .id(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        // call the endpoint
        mockMvc.perform(post("/api/department/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"CS\",\n" +
                        "    \"address\": \"amravati\",\n" +
                        "    \"code\": \"20983091\"\n" +
                        "}")).andExpect(status().isOk());

    }
}