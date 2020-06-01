package org.pensatocode.simplicity.sample.controllers.api;

import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.repository.CollegeRepository;

import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colleges")
public class CollegeRestController extends AbstractController<College, Long> {
    public CollegeRestController(@Autowired CollegeRepository collegeRepository) {
        super(collegeRepository);
    }
}