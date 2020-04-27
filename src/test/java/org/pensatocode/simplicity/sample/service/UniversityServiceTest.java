package org.pensatocode.simplicity.sample.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pensatocode.simplicity.sample.bean.UniversityBean;
import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.CollegeRepository;
import org.pensatocode.simplicity.sample.repository.StudentRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UniversityServiceTest {

    @Mock
    private CollegeRepository collegeRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private UniversityService universityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUniversity() {
        // Mock attributes
        String mockName = "MockCollege";
        String mockCity = "MockCity";
        String mockAddress = "MockAddress";
        // Create College
        College mockCollege = new College(1001L, mockName, mockCity);
        // Create Student List
        Student mockStudentA = new Student(2001L,"John", mockAddress);
        Student mockStudentB = new Student(2002L,"Mary", mockAddress);
        List<Student> mockStudentList = List.of(mockStudentA, mockStudentB);

        Mockito.when(collegeRepository.save(Mockito.any(College.class))).thenReturn(mockCollege);
        Mockito.when(studentRepository.save(ArgumentMatchers.anyIterable())).thenReturn(mockStudentList);

        UniversityBean newUniversityBean = universityService.createUniversity(
                new UniversityBean(new College(), new ArrayList<>()));

        // Verify return value
        Assertions.assertNotNull(newUniversityBean);
        // Verify College
        Assertions.assertNotNull(newUniversityBean.getCollege());
        Assertions.assertTrue(newUniversityBean.getCollege().getId() > 0L);
        Assertions.assertEquals(mockName, newUniversityBean.getCollege().getName());
        // Verify Student List
        Assertions.assertNotNull(newUniversityBean.getStudents());
        Assertions.assertEquals(mockStudentList.size(), newUniversityBean.getStudents().size());
        Assertions.assertIterableEquals(mockStudentList, newUniversityBean.getStudents());
        Assertions.assertTrue(newUniversityBean.getStudents().get(0).getId() > 0L);
    }

}
