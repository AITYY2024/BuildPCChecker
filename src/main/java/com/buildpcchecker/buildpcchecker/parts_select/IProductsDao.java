package com.buildpcchecker.buildpcchecker.parts_select;

import com.buildpcchecker.buildpcchecker.form.CpuSelectForm;
import com.buildpcchecker.buildpcchecker.form.GpuSelectForm;
import com.buildpcchecker.buildpcchecker.form.MemorySelectForm;

import java.util.List;

public interface IProductsDao {
    List<CpuSelectForm> selectCpuParts();
    List<GpuSelectForm> selectGpuParts();
  //  List<MemorySelectForm> selectMemoryParts();
}
