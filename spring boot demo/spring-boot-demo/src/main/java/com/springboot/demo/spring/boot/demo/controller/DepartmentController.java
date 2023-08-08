package com.springboot.demo.spring.boot.demo.controller;

import com.springboot.demo.spring.boot.demo.entity.Department;
import com.springboot.demo.spring.boot.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    // inject the required dependency
    @Autowired
    private DepartmentService departmentService;

    // add logger - default we can use sl4j logger and get the bean from LoggerFactory
    // using getLogger method
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    // @RequestBody - convert the json body to java object
    @PostMapping("/save")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("saving department - DepartmentController");
        return departmentService.saveDepartment(department);
    }

    // get all departments
    @GetMapping("/list")
    public List<Department> departments() {
        return departmentService.fetchAll();
    }

    // get department based on id  - @PathVariable will bind the id to method variable
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    // delete department by id
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return "department got deleted successfully";
    }

    // update existing department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }
}
