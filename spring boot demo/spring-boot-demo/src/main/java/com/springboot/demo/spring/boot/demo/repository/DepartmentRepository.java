package com.springboot.demo.spring.boot.demo.repository;

import com.springboot.demo.spring.boot.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
