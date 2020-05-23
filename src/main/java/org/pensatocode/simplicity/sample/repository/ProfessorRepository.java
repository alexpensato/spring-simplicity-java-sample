package org.pensatocode.simplicity.sample.repository;

import org.pensatocode.simplicity.sample.domain.Professor;

import org.pensatocode.simplicity.jdbc.JdbcRepository;

public interface ProfessorRepository extends JdbcRepository<Professor, Long> {
}