package org.pensatocode.simplicity.sample.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pensatocode.simplicity.sample.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UniversityServiceIntegrationTest {

    @Autowired
    private UniversityService universityService;

    @Test
    public void testFindAllStudentsByCollege_shouldReturnEmptyListWhenIdIsInvalid() {
        List<Student> studentList = universityService.findAllStudentsByCollege(0L);

        // Verify return value
        Assertions.assertNotNull(studentList);
        Assertions.assertEquals(0, studentList.size());
    }
}
