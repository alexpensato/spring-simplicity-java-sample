package org.pensatocode.simplicity.sample.controller;

import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.StudentRepository;

import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<Student, Long> {
    public StudentController(@Autowired StudentRepository studentRepository) {
        super(studentRepository);
    }
}