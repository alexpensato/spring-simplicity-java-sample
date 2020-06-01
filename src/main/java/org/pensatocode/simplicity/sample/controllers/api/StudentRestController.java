package org.pensatocode.simplicity.sample.controllers.api;

import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.StudentRepository;

import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentRestController extends AbstractController<Student, Long> {
    public StudentRestController(@Autowired StudentRepository studentRepository) {
        super(studentRepository);
    }
}