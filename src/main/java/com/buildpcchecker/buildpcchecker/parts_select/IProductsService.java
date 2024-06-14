package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import com.buildpcchecker.buildpcchecker.form.GpuSelectForm;

import java.util.List;

public interface IProductsService {
    public List<CpuSelectForm> selectCpuParts();
    public List<GpuSelectForm> selectGpuParts();
}
