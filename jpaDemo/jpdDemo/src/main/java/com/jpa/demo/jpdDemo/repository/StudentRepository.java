package com.jpa.demo.jpdDemo.repository;

import com.jpa.demo.jpdDemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // find students by firstNames
    List<Student> findByFirstName(String name);

    // first name containing with some chars
    List<Student> findByFirstNameContaining(String name);

    // find by lastName not null
    List<Student> findByLastNameNotNull();

    // find by guardian name
    @Meta(comment = "find by guardians names")
    List<Student> findByGuardianName(String guardianName);

    // JPQL Query
    @Query("select student from Student student where student.emailId=?1")
    Student getStudentByEmailId(String emailId);

    // Native query
    @Query(
            value = "select * from student_tbl s where s.email_address=?1",
            nativeQuery = true)
    Student getStudentByEmailIDUsingNativeQuery(String emailId);

    // Native named param
    @Query(
            value = "select * from student_tbl s where s.email_address =:emailId",
            nativeQuery = true)
    Student getStudentByEmailIDUsingNamingParam(@Param("emailId") String emailId);

    // update the firstName - @ modifying
    @Modifying // used for insert,update and delete queries
    @Transactional  // used for performing end-to-end transaction i.e. start transaction, save and commit
    @Query(
            value = "update student_tbl set first_name=:firstName where email_address=:emailId",
            nativeQuery = true
    )
    int updateFirstNameUsingEmailId(@Param("firstName") String firstName,@Param("emailId") String emailId);


}
