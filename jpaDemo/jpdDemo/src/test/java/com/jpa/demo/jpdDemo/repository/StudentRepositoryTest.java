package com.jpa.demo.jpdDemo.repository;

import com.jpa.demo.jpdDemo.entity.Guardian;
import com.jpa.demo.jpdDemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest // it will be used to test and flush the data after testing
        // to avoid impact on database
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    // test save method
    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("test@gamil.com")
                .firstName("john")
                .lastName("doe")
                .build();
        Student student2 = Student.builder()
                .emailId("adam.john@gamil.com")
                .firstName("marry")
                .lastName("doe")
                .build();

        studentRepository.save(student);
        studentRepository.save(student2);
    }

    // save with guardians details
    @Test
    public void saveWithGuardians() {
        Guardian guardian = Guardian.builder()
                .name("clare_guardian")
                .email("clare.guardian@gmail.com")
                .mobile("2039020920")
                .build();
        Student student = Student.builder()
                .firstName("merry")
                .lastName("doe")
                .emailId("merry.doe@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    // print all students
    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("All students data " + studentList);
    }

    // get students with first name
    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("merry");
        System.out.println("students with first names " + students);
    }

    // get students with first name containing
    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("a");
        System.out.println("students with first names containing " + students);
    }

    // print guardians names
    @Test
    public void printGuardianNames() {
        List<Student> studentList = studentRepository.findByGuardianName("clare_guardian");
        System.out.println("Guardian details " + studentList);
    }

    // find by last names
    @Test
    public void printByLastNames() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("Find By last names " + studentList);
    }

    // test getStudentByEmailId method
    @Test
    public void getStudentByEmailIdTest() {
        Student student = studentRepository
                .getStudentByEmailId("merry.doe@gmail.com");
        System.out.println("getStudentByEmailId " + student);
    }

    @Test
    public void getStudentByEmailIDUsingNativeQueryTest() {
        Student student = studentRepository.
                getStudentByEmailIDUsingNativeQuery("merry.doe@gmail.com");
        System.out.println("native query " + student);
    }

    @Test
    public void getStudentByEmailIDUsingNamingParamTest() {
        Student student = studentRepository.
                getStudentByEmailIDUsingNamingParam("merry.doe@gmail.com");
        System.out.println("native query with named param " + student);
    }

    // test update method
    @Test
    public void updateFirstNameUsingEmailId() {
        int returnVal = studentRepository
                .updateFirstNameUsingEmailId("john", "merry.doe@gmail.com");
        System.out.println("Return value is "+returnVal);
    }

}
