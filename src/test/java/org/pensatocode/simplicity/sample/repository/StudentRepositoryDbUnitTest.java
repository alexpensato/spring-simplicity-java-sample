package org.pensatocode.simplicity.sample.repository;

import junit.framework.TestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pensatocode.simplicity.sample.domain.Student;
import org.pensatocode.simplicity.sample.repository.impl.StudentRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentRepositoryDbUnitTest extends TestCase {

    private IDatabaseTester databaseTester;

    private StudentRepository studentRepository;

    protected DataSource getDataSource() {
        var ds = new SimpleDriverDataSource();
        ds.setDriver(new org.h2.Driver());
        ds.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/schema.sql'");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass()
                .getClassLoader()
                .getResourceAsStream("dataset.xml"));
    }

    @BeforeEach
    protected void setUp() throws Exception {
        this.databaseTester = new DataSourceDatabaseTester(getDataSource());
        databaseTester.setDataSet( getDataSet() );
        databaseTester.onSetup();
        this.studentRepository = new StudentRepositoryImpl(new JdbcTemplate(this.getDataSource()));
    }

    protected void tearDown() throws Exception
    {
        // will call default tearDownOperation
        databaseTester.onTearDown();
    }

    @Test
    public void testFindAllByCollege() {
        List<Student> studentList = studentRepository.findAllByCollege(1L);

        Assertions.assertNotNull(studentList);
        Assertions.assertEquals(4, studentList.size());
    }
}
