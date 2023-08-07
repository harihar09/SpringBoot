package com.jpa.demo.jpdDemo.repository;

import com.jpa.demo.jpdDemo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // custom methods for pagination and sorting
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
