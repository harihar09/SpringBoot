package com.jpa.demo.jpdDemo.repository;

import com.jpa.demo.jpdDemo.entity.Course;
import com.jpa.demo.jpdDemo.entity.Student;
import com.jpa.demo.jpdDemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    // add the dependency
    @Autowired
    private CourseRepository courseRepository;

    // print all courses
    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses " + courses);
    }

    // save course with teacher details
    @Test
    public void saveCourseWithTeacher() {
        // Teacher object
        Teacher teacher = Teacher.builder()
                .firstName("Radhika")
                .lastName("Singh")
                .build();
        // Course object
        Course course = Course.builder()
                .title("python")
                .credit(10)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    // test pagination
    @Test
    public void findAllPagination() {
        Pageable firstPageWithTwoRecords =
                PageRequest.of(0, 2);
        Pageable secondPageWithThreeRecords =
                PageRequest.of(1, 3);
        List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();
        System.out.println("courses " + courses);

        List<Course> course2 = courseRepository.findAll(secondPageWithThreeRecords).getContent();
        System.out.println("courses " + course2);

        long totalElements = courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();
        System.out.println("total elements are " + totalElements);

        long totalPages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();
        System.out.println("total pages are " + totalPages);
    }

    // pagination with sorting
    @Test
    public void paginationSortingTest() {
        Pageable paginationWithSorting = PageRequest.of(0, 3, Sort.by("title"));
        List<Course> courses = courseRepository.findAll(paginationWithSorting).getContent();
        System.out.println("pagination with sorting " + courses);

        // sort based on title in descending order and then credit
        Pageable sortWithTitleAndCredit = PageRequest.of(0, 2, Sort.by("title").descending()
                .and(Sort.by("credit")));
        List<Course> coursesList = courseRepository.findAll(sortWithTitleAndCredit).getContent();
        System.out.println("sort with title in desc order and then with credit " + coursesList);
    }

  // test custom pagination method
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageWithTenRecords =
                PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("D",firstPageWithTenRecords).getContent();
        System.out.println("custom pagination "+courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        // Teacher object
        Teacher teacher = Teacher.builder()
                .firstName("Radhika")
                .lastName("Singh")
                .build();
        // Course object
        Course course = Course.builder()
                .title("python")
                .credit(10)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("merry")
                .lastName("doe")
                .emailId("merry.doe@gmail.com")
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}

