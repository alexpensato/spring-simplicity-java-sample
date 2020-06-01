package org.pensatocode.simplicity.sample.controllers.api;

import org.pensatocode.simplicity.sample.bean.UniversityBean;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityRestController {

    private UniversityService universityService;

    public UniversityRestController(@Autowired UniversityService universityService) {
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