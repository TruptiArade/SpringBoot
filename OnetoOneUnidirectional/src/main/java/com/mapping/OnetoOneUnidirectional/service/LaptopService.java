package com.mapping.OnetoOneUnidirectional.service;

import com.mapping.OnetoOneUnidirectional.dto.LaptopDTO;

import java.util.List;

public interface LaptopService
{
    LaptopDTO saveLaptop(LaptopDTO laptopDTO);
    List<LaptopDTO> fetchLaptop();
}
