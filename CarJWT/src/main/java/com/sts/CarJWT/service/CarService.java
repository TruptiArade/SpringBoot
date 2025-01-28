package com.sts.CarJWT.service;

import com.sts.CarJWT.dto.CarDto;
import com.sts.CarJWT.entity.Car;

import java.util.List;

public interface CarService
{
    CarDto saveCar(CarDto carDto);
    List<CarDto> fetchCarList();
    CarDto fetchCarById(Integer cid);
    CarDto updateCar(CarDto carDto, Integer cid);
    CarDto updatepatchCar(CarDto carDto, Integer cid);
    void deleteCarById(Integer cid);
    List<CarDto> findByCname(String cname);
    List<CarDto> searchByCname(String cname);
    List<CarDto> searchByCcompanyname(String ccompanyname);
    List<CarDto> searchByCmodel(String cmodel);
    List<CarDto> searchByCprice(String minCprice,String maxCprice);
}
