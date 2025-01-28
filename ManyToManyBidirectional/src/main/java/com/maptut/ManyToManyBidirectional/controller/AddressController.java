package com.maptut.ManyToManyBidirectional.controller;

import com.maptut.ManyToManyBidirectional.dto.AddressDTO;
import com.maptut.ManyToManyBidirectional.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Addressinfo")
public class AddressController
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
    public List<AddressDTO> fetchaddress()
    {
        return addressService.fetchaddress();
    }
}