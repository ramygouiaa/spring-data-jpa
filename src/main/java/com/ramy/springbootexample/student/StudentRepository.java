package com.ramy.springbootexample.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//this is a convention in the JPA world to tell that this interface is responsible for accessing the database
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
