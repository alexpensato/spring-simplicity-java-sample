package org.pensatocode.simplicity.sample.controllers.api;

import org.pensatocode.simplicity.sample.domain.Professor;
import org.pensatocode.simplicity.sample.repository.ProfessorRepository;

import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professors")
public class ProfessorRestController extends AbstractController<Professor, Long> {
    public ProfessorRestController(@Autowired ProfessorRepository professorRepository) {
        super(professorRepository);
    }
}