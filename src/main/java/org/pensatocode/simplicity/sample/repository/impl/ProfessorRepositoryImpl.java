package org.pensatocode.simplicity.sample.repository.impl;

import org.pensatocode.simplicity.sample.domain.Professor;
import org.pensatocode.simplicity.sample.repository.mapper.ProfessorMapper;
import org.pensatocode.simplicity.sample.repository.ProfessorRepository;

import org.pensatocode.simplicity.jdbc.AbstractJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "professorRepository")
public class ProfessorRepositoryImpl extends AbstractJdbcRepository<Professor, Long> implements ProfessorRepository {

    public ProfessorRepositoryImpl(@Autowired JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new ProfessorMapper(), "professor", Professor.class, "id");
    }
}