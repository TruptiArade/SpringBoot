package com.mapping.OnetoOneBidirectional.controller;

import com.mapping.OnetoOneBidirectional.dto.LaptopDTO;
import com.mapping.OnetoOneBidirectional.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LaptopInfo")
public class LaptopController
{
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/add")
    public LaptopDTO saveLaptop(@RequestBody LaptopDTO laptopDTO)
    {
        return laptopService.saveLaptop(laptopDTO);
    }

    @GetMapping("/laptopList")
    public List<LaptopDTO> fetchLaptop()
    {
        return laptopService.fetchLaptop();
    }

}
