package org.pensatocode.simplicity.sample.repository.mapper;

import org.pensatocode.simplicity.sample.domain.Book;

import org.pensatocode.simplicity.jdbc.mapper.TransactionalRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookMapper extends TransactionalRowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) {
        try {
            return new Book(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("isbn")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> mapColumns(Book entity) {
        Map<String, Object> mapping = new LinkedHashMap<>();
        mapping.put("id", entity.getId());
        mapping.put("title", entity.getTitle());
        mapping.put("author", entity.getAuthor());
        mapping.put("isbn", entity.getIsbn());
        return mapping;
    }

    @Override
    public Map<String, Integer> mapTypes() {
        final Map<String, Integer> mapping = new LinkedHashMap<>();
        mapping.put("id", Types.INTEGER);
        mapping.put("title", Types.VARCHAR);
        mapping.put("author", Types.VARCHAR);
        mapping.put("isbn", Types.VARCHAR);
        return mapping;
    }
}