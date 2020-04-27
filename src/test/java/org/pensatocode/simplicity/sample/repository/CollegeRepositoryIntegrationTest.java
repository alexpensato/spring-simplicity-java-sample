package org.pensatocode.simplicity.sample.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pensatocode.simplicity.sample.domain.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CollegeRepositoryIntegrationTest {

    @Autowired
    private CollegeRepository collegeRepository;

    @Test
    public void testCreateAndFindOneCollege() {
        // Create mock College
        College mockCollege = new College("MockCollege", "MockCity");

        Assertions.assertEquals(0L, mockCollege.getId());

        College newCollege = collegeRepository.save(mockCollege);

        Assertions.assertNotNull(newCollege);
        Assertions.assertTrue(newCollege.getId() > 0L);

        College collegeFound = collegeRepository.findOne(newCollege.getId());

        Assertions.assertNotNull(collegeFound);
        Assertions.assertEquals(newCollege.getId(), collegeFound.getId());
        Assertions.assertEquals(newCollege, collegeFound);
        Assertions.assertNotSame(newCollege, collegeFound);

    }

}
