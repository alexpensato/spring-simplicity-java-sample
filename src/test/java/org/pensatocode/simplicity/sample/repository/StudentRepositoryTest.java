package org.pensatocode.simplicity.sample.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.mapper.StudentMapper;
import org.pensatocode.simplicity.sample.repository.impl.StudentRepositoryImpl;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private final StudentRepository studentRepository = new StudentRepositoryImpl(jdbcTemplate);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllByCollege() {
        // Create mock Student List
        Student mockStudentA = new Student("John", "mockAddress");
        Student mockStudentB = new Student("Mary", "mockAddress");
        List<Student> mockStudentList = List.of(mockStudentA, mockStudentB);

        Mockito.when(jdbcTemplate.query(ArgumentMatchers.contains("FROM student WHERE college_id = ?"),
                ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(StudentMapper.class)))
                .thenReturn(mockStudentList);

        List<Student> resultList = studentRepository.findAllByCollege(1L);

        Assertions.assertNotNull(resultList);
        Assertions.assertIterableEquals(mockStudentList, resultList);
    }
}
