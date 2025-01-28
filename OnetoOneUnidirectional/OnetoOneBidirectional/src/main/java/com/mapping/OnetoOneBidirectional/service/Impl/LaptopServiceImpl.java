package com.mapping.OnetoOneBidirectional.service.Impl;

import com.mapping.OnetoOneBidirectional.dto.LaptopDTO;
import com.mapping.OnetoOneBidirectional.entity.Laptop;
import com.mapping.OnetoOneBidirectional.repository.LaptopRepository;
import com.mapping.OnetoOneBidirectional.service.LaptopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LaptopDTO saveLaptop(LaptopDTO laptopDTO)
    {
        Laptop L=modelMapper.map(laptopDTO,Laptop.class);
        Laptop savedata=laptopRepository.save(L);
        return  modelMapper.map(savedata,LaptopDTO.class);
    }
    @Override
    public List<LaptopDTO> fetchLaptop()
    {
        List<Laptop> laptopList = laptopRepository.findAll();
        return laptopList.stream()
                .map(entity -> modelMapper.map(entity, LaptopDTO.class))
                .collect(Collectors.toList());
    }
}
