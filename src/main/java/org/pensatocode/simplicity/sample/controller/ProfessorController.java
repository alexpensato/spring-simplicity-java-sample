package org.pensatocode.simplicity.sample.controller;

import org.pensatocode.simplicity.sample.domain.Professor;
import org.pensatocode.simplicity.sample.repository.ProfessorRepository;

import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController extends AbstractController<Professor, Long> {
    public ProfessorController(@Autowired ProfessorRepository professorRepository) {
        super(professorRepository);
    }
}