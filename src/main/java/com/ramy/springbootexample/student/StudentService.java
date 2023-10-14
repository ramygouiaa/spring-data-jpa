package com.ramy.springbootexample.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void registerNewStudent(Student student) {
        Optional<Student> optionalStudent =
        studentRepository.findStudentByEmail(student.getEmail());

        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }

        studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {

        Boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist" );
        }
        studentRepository.deleteById(studentId);

    }

    public void updateStudentById(Long studentId, String name, String email) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isEmpty()) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist" );
        }
        Student student = optionalStudent.get();
        student.setFirstName(name);
        student.setEmail(email);
        studentRepository.save(student);
    }
}
