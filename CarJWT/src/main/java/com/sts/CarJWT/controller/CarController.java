package com.sts.CarJWT.controller;

import com.sts.CarJWT.dto.CarDto;
import com.sts.CarJWT.entity.Car;
import com.sts.CarJWT.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carproduct")
public class CarController
{
   @Autowired
    private CarService carService;

   //Add car
   @PostMapping("/add")
    public CarDto saveCar(@RequestBody CarDto carDto)
   {
     return carService.saveCar(carDto);
   }

   //Display all car
    @GetMapping("/carlist")
    public List<CarDto> fetchCarList()
    {
        return carService.fetchCarList();
    }

    //Search Car based on id
    @GetMapping("/carsearch/{id}")
    public CarDto fetchCarById(@PathVariable("id")Integer cid)

    {
        return carService.fetchCarById(cid);
    }

    //update car data
    @PutMapping("/carupdate/{id}")
    public CarDto updateCar(@RequestBody CarDto carDto, @PathVariable("id") Integer cid)
    {
         return carService.updateCar(carDto,cid);
    }

    //update car data (not required entire body part)
    @PatchMapping("/cartpatch/{id}")
    public CarDto updatepatchCar(@RequestBody CarDto carDto, @PathVariable("id") Integer cid)
    {
        return carService.updatepatchCar(carDto,cid);
    }

    //Delete Car
    @DeleteMapping("/{id}")
    public String deleteCarById(@PathVariable("id") Integer cid)
    {
        carService.deleteCarById(cid);
        return "Deleted Successfully";
    }

    //Search car by car name
    @GetMapping("/carsearchname/{cname}")
    public List<CarDto> searchByCname(@PathVariable("cname") String cname)
    {
        //carService.findByCarName(cname);
        return  carService.searchByCname(cname);
    }

    //Search car by company name
    @GetMapping("/carsearchcompany/{ccompanyname}")
    public List<CarDto> searchByCcompanyname(@PathVariable("ccompanyname") String ccompanyname)
    {
        return carService.searchByCcompanyname(ccompanyname);
    }

    //search car by company model
    @GetMapping("/carsearchmodel/{cmodel}")
    public List<CarDto> searchByCmodel(@PathVariable("cmodel") String cmodel)
    {
        return carService.searchByCmodel(cmodel);
    }

    //search car by company range
    @GetMapping("/carpricerange/")
    public List<CarDto> searchByCprice(@RequestParam String minCprice,
                                       @RequestParam String maxCprice)
    {
        return carService.searchByCprice(minCprice, maxCprice);
    }



}
