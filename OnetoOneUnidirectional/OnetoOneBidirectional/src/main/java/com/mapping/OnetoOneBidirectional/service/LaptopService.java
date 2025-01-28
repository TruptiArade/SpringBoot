package com.mapping.OnetoOneBidirectional.service;

import com.mapping.OnetoOneBidirectional.dto.LaptopDTO;

import java.util.List;

public interface LaptopService
{
    LaptopDTO saveLaptop(LaptopDTO laptopDTO);
    List<LaptopDTO> fetchLaptop();
}
