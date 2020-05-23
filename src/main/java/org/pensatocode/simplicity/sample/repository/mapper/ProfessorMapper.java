package org.pensatocode.simplicity.sample.repository.mapper;

import org.pensatocode.simplicity.sample.domain.Professor;

import org.pensatocode.simplicity.jdbc.mapper.TransactionalRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProfessorMapper extends TransactionalRowMapper<Professor> {

    @Override
    public Professor mapRow(ResultSet rs, int rowNum) {
        try {
            return new Professor(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getDate("beginDate").toLocalDate()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> mapColumns(Professor entity) {
        Map<String, Object> mapping = new LinkedHashMap<>();
        mapping.put("id", entity.getId());
        mapping.put("name", entity.getName());
        mapping.put("beginDate", entity.getBeginDate());
        return mapping;
    }

    @Override
    public Map<String, Integer> mapTypes() {
        final Map<String, Integer> mapping = new LinkedHashMap<>();
        mapping.put("id", Types.INTEGER);
        mapping.put("name", Types.VARCHAR);
        mapping.put("beginDate", Types.DATE);
        return mapping;
    }
}