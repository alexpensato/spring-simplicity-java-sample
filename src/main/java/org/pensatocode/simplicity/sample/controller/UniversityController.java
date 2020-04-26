package org.pensatocode.simplicity.sample.controller;

import org.pensatocode.simplicity.sample.bean.UniversityBean;
import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.CollegeRepository;
import org.pensatocode.simplicity.sample.repository.StudentRepository;
import org.pensatocode.simplicity.sample.service.UniversityService;
import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private UniversityService universityService;

    public UniversityController(@Autowired UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("college/{collegeId}/students")
    @ResponseBody
    public List<Student> findAllStudentsByCollege(@Valid @PathVariable Long collegeId) {
        //Assert.notNull(collegeId, "You must provide a college ID to locate students.");
        return universityService.findAllStudentsByCollege(collegeId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UniversityBean createCollegeWithStudents(@Valid @RequestBody UniversityBean universityBean) {
        return universityService.createUniversity(universityBean);
    }

}