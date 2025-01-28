package com.maptut.ManyToManyUnidirectional.controller;


import com.maptut.ManyToManyUnidirectional.dto.AddressDTO;
import com.maptut.ManyToManyUnidirectional.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Addressinfo")
public class AddresssController
{
    @Autowired
    private AddressService addressService;

    //Add Address
    @PostMapping("/add")
    public AddressDTO saveaddress(@RequestBody AddressDTO addressDTO)

    {
        return addressService.saveaddress(addressDTO);
    }

    //Display all Address
    @GetMapping("/addresslist")
    public List<AddressDTO>  fetchaddress()
    {
        return addressService.fetchaddress();
    }
}