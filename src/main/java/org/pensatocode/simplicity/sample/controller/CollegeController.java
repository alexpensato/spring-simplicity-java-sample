package org.pensatocode.simplicity.sample.controller;

import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.CollegeRepository;
import org.pensatocode.simplicity.sample.repository.StudentRepository;
import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController extends AbstractController<College, Long> {

    public CollegeController(@Autowired CollegeRepository collegeRepository) {
        super(collegeRepository);
    }

}