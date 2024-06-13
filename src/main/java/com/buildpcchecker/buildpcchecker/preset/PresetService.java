package com.buildpcchecker.buildpcchecker.preset;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PresetService implements IpresetService {

    @Autowired
    private PresetDao presetDao;


}
