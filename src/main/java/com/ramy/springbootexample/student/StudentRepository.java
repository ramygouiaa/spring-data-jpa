package com.ramy.springbootexample.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//this is a convention in the JPA world to tell that this interface is responsible for accessing the database
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")//this is optional
    Optional<Student> findStudentByEmail(String email);
}
