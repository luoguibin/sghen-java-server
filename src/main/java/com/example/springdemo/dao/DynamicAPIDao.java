package com.example.springdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.example.springdemo.entity.DynamicAPI;

@Repository
public class DynamicAPIDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DynamicAPI> getList() {
        String sql = "SELECT * FROM dynamic_api2";
        List<DynamicAPI> list = jdbcTemplate.query(sql, new RowMapper<DynamicAPI>() {
            DynamicAPI api = null;

            @Override
            public DynamicAPI mapRow(ResultSet rs, int rowNum) throws SQLException {
                api = new DynamicAPI(rs.getBigDecimal("id").toBigInteger(), rs.getString("name"),
                        rs.getString("suffix_path"));
                api.setComment(rs.getString("comment"));
                api.setContent(rs.getString("content"));
                api.setStatus(rs.getInt("status"));
                api.setTimeCreate(rs.getTimestamp("time_create"));
                api.setTimeUpdate(rs.getTimestamp("time_update"));
                api.setUserId(rs.getBigDecimal("user_id").toBigInteger());
                api.setCount(rs.getInt("count"));
                return api;
            }
        });
        return list;
    }

    public int create() {
        DynamicAPI api = new DynamicAPI(new BigInteger("0"), "测试test", "test");
        api.setCount(0);
        api.setContent("[{\"key\":\"data\",\"sql\":\"SELECT * FROM dynamic_api2\"}]");
        api.setTimeCreate(new Timestamp(System.currentTimeMillis()));
        api.setTimeUpdate(api.getTimeCreate());
        api.setStatus(1);
        api.setUserId(new BigInteger("16405"));
        api.setComment("-");
        String keys = "name, suffix_path, content, time_update, time_create, count, status, comment, user_id";
        int result = jdbcTemplate.update("insert into dynamic_api2 (" + keys + ") values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                api.getName(), api.getSuffixPath(), api.getContent(), api.getTimeUpdate(), api.getTimeCreate(),
                api.getCount(), api.getStatus(), api.getComment(), api.getUserId());
        return result;
    }
}