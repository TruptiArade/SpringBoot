package com.maptut.ManyToManyUnidirectional.service;

import com.maptut.ManyToManyUnidirectional.dto.AddressDTO;

import java.util.List;

public interface AddressService
{
    AddressDTO saveaddress(AddressDTO addressDTO);
    List<AddressDTO> fetchaddress();

}
