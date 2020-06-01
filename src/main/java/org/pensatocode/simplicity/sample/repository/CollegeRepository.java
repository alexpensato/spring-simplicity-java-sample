package org.pensatocode.simplicity.sample.repository;

import org.pensatocode.simplicity.sample.domain.College;

import org.pensatocode.simplicity.jdbc.JdbcRepository;

public interface CollegeRepository extends JdbcRepository<College, Long> {
}