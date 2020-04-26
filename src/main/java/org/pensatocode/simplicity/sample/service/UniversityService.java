package org.pensatocode.simplicity.sample.service;

import org.pensatocode.simplicity.sample.bean.UniversityBean;
import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.CollegeRepository;
import org.pensatocode.simplicity.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UniversityService {

    private CollegeRepository collegeRepository;
    private StudentRepository studentRepository;

    public UniversityService(@Autowired CollegeRepository collegeRepository, @Autowired StudentRepository studentRepository) {
        this.collegeRepository = collegeRepository;
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudentsByCollege(@PathVariable Long collegeId) {
        return studentRepository.findAllByCollege(collegeId);
    }

    @Transactional
    public UniversityBean createUniversity(UniversityBean universityBean) {
        College newCollege = collegeRepository.save(universityBean.getCollege());
        List<Student> newStudents = studentRepository.save(universityBean.getStudents());
        return new UniversityBean(newCollege, newStudents);
    }
}
