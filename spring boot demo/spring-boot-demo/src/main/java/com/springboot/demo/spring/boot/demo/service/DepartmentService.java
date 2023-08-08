package com.springboot.demo.spring.boot.demo.service;

import com.springboot.demo.spring.boot.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchAll();

    Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long departmentId, Department department1);
}
