package org.pensatocode.simplicity.sample.bean;

import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.domain.Student;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

public class UniversityBean {

    @NotNull(message = "College cannot be null")
    private College college;

    @NotNull(message = "Students list cannot be null")
    @NotEmpty(message = "Students list cannot be empty")
    private List<Student> students;

    public UniversityBean() {
        // Default constructor
    }

    public UniversityBean(@NotNull(message = "College cannot be null")
                                  College college,
                          @NotNull(message = "Students list cannot be null")
                          @NotEmpty(message = "Students list cannot be empty")
                                  List<Student> students) {
        this.college = college;
        this.students = students;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public List<Student> getStudents() {
        if (students == null) {
            return Collections.emptyList();
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
