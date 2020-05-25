package org.pensatocode.simplicity.sample.repository.mapper;

import org.pensatocode.simplicity.sample.domain.College;

import org.pensatocode.simplicity.jdbc.mapper.TransactionalRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollegeMapper extends TransactionalRowMapper<College> {

    @Override
    public College mapRow(ResultSet rs, int rowNum) {
        try {
            return new College(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("nameOfCity")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> mapColumns(College entity) {
        Map<String, Object> mapping = new LinkedHashMap<>();
        mapping.put("id", entity.getId());
        mapping.put("name", entity.getName());
        mapping.put("nameOfCity", entity.getNameOfCity());
        return mapping;
    }

    @Override
    public Map<String, Integer> mapTypes() {
        final Map<String, Integer> mapping = new LinkedHashMap<>();
        mapping.put("id", Types.BIGINT);
        mapping.put("name", Types.VARCHAR);
        mapping.put("nameOfCity", Types.VARCHAR);
        return mapping;
    }
}