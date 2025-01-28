package com.maptut.ManyToManyBidirectional.service;

import com.maptut.ManyToManyBidirectional.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO saveaddress(AddressDTO addressDTO);
    List<AddressDTO> fetchaddress();
}
