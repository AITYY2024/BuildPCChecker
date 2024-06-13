package com.buildpcchecker.buildpcchecker.preset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PresetDao implements IpresetDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


}
