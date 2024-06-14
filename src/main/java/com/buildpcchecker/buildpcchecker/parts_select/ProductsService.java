package com.buildpcchecker.buildpcchecker.parts_select;


import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import com.buildpcchecker.buildpcchecker.form.GpuSelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private ProductsDao productsDao;

    @Override
    public  List<CpuSelectForm> selectCpuParts(){
        return productsDao.selectCpuParts();
    }
    @Override
    public  List<GpuSelectForm> selectGpuParts(){
        return productsDao.selectGpuParts();
    }
}
