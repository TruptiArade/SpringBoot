package com.maptut.ManyToManyBidirectional.service.Impl;

import com.maptut.ManyToManyBidirectional.dto.AddressDTO;
import com.maptut.ManyToManyBidirectional.entity.Address;
import com.maptut.ManyToManyBidirectional.repository.AddressRepository;
import com.maptut.ManyToManyBidirectional.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDTO saveaddress(AddressDTO addressDTO)
    {
        Address a=modelMapper.map(addressDTO, Address.class);
        Address savedata=addressRepository.save(a);
        return modelMapper.map(savedata,AddressDTO.class);
    }

    @Override
    public List<AddressDTO> fetchaddress()
    {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream()
                .map(entity -> modelMapper.map(entity, AddressDTO.class))
                .collect(Collectors.toList());
    }
}
