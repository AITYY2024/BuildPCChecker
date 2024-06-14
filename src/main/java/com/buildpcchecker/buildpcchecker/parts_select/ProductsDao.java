package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import com.buildpcchecker.buildpcchecker.form.GpuSelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDao implements IProductsDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<CpuSelectForm> selectCpuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM cpu
                """,new DataClassRowMapper<>(CpuSelectForm.class));
    }
    @Override
    public List<GpuSelectForm> selectGpuParts(){
        return jdbcTemplate.query("""
                SELECT * FROM gpu
                """,new DataClassRowMapper<>(GpuSelectForm.class));
    }

}
