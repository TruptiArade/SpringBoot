package com.sts.CarJWT.service.impl;

import com.sts.CarJWT.Repository.CarRepository;
import com.sts.CarJWT.customexception.ResourceNotFoundException;
import com.sts.CarJWT.customexception.ValidException;
import com.sts.CarJWT.dto.CarDto;
import com.sts.CarJWT.entity.Car;
import com.sts.CarJWT.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService
{
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final String carinfo="^[A-Za-z]{2,50}$";
    private static final String carquantity="[0-9]{1,2}";

    public static boolean validatecarinfo(String cname, String comname)
    {
        if(cname == null || !Pattern.matches(carinfo,cname)
                || comname == null || !Pattern.matches(carinfo,comname))
        {
            throw new ValidException("Enter only characters with range 2 to 15");
        }
        return  true;

    }

    public  static boolean validatequantity(String quantity)
    {
       if(quantity == null || !Pattern.matches(carquantity,quantity))
       {
           throw new ValidException("Enter only digits");
       }
        return true;
    }


    @Override
    public CarDto saveCar(CarDto carDto)
    {
        validatecarinfo(carDto.getCname(),carDto.getCcompanyname());
        validatequantity(carDto.getCquantity());
        carDto.getCprice();

       //Convert CarDto to Class Entity using model mapper
        Car c=modelMapper.map(carDto,Car.class);
        Car savedata =carRepository.save(c);
        return modelMapper.map(savedata, CarDto.class);
    }

    @Override
    public List<CarDto> fetchCarList()
    {
        List<Car> carList = carRepository.findAll();
        return carList.stream()
                .map(entity -> modelMapper.map(entity,CarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDto fetchCarById(Integer cid)
    {
        Car car = carRepository.findById(cid)
                .orElseThrow(()->new ResourceNotFoundException("Car not found"+ "  "+cid));
        return modelMapper.map(car, CarDto.class);
    }

    @Override
    public CarDto updateCar(CarDto carDto,Integer cid)
    {
       Car existingcar=carRepository.findById(cid)
               .orElseThrow(()->new ResourceNotFoundException("Car not found"+ "  "+cid));

       if((carDto.getCname()!=null)||(carDto.getCcompanyname()!=null))
       {
          validatecarinfo(carDto.getCname(),carDto.getCcompanyname());
          existingcar.setCname(carDto.getCname());
          existingcar.setCcompanyname(carDto.getCcompanyname());

       }
       if(carDto.getCmodel()!=null)
       {
           carDto.getCmodel();
           existingcar.setCmodel(carDto.getCmodel());
       }

       if(carDto.getCquantity()!=null)
       {
           validatequantity(carDto.getCquantity());
           existingcar.setCquantity(carDto.getCquantity());
       }

       if(carDto.getCprice()!=null)
       {
           carDto.getCprice();
           existingcar.setCprice(carDto.getCprice());
       }

       Car updatedcar=carRepository.save(existingcar);
       return modelMapper.map(updatedcar,CarDto.class);
    }

    @Override
    public CarDto updatepatchCar(CarDto carDto,Integer cid)
    {
        Car existingcar=carRepository.findById(cid)
                .orElseThrow(()->new ResourceNotFoundException("Car not found"+ "  "+cid));

        if((carDto.getCname()!=null)||(carDto.getCcompanyname()!=null))
        {
            validatecarinfo(carDto.getCname(),carDto.getCcompanyname());
            existingcar.setCname(carDto.getCname());
            existingcar.setCcompanyname(carDto.getCcompanyname());

        }
        if(carDto.getCmodel()!=null)
        {
            carDto.getCmodel();
            existingcar.setCmodel(carDto.getCmodel());
        }

        if(carDto.getCquantity()!=null)
        {
            validatequantity(carDto.getCquantity());
            existingcar.setCquantity(carDto.getCquantity());
        }

        if(carDto.getCprice()!=null)
        {
            carDto.getCprice();
            existingcar.setCprice(carDto.getCprice());
        }

        Car updatedcar=carRepository.save(existingcar);
        return modelMapper.map(updatedcar,CarDto.class);

    }

    @Override
    public void deleteCarById(Integer cid)
    {
        Car existing= carRepository.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with ID: " + cid));
        carRepository.delete(existing);
    }

    @Override
    public List<CarDto> findByCname(String cname)
    {
       List<Car> searchcar =carRepository.findByCname(cname);
       List<CarDto> carDtoList = new ArrayList<>();
       for(Car c:searchcar)
       {
           CarDto carDto =modelMapper.map(c,CarDto.class);
           carDtoList.add(carDto);

       }
      return carDtoList;
    }

    @Override
    public List<CarDto> searchByCname(String cname)
    {
        List<Car> searchcar =carRepository.findByCnameContainingIgnoreCaseOrderByCnameAsc(cname);
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car c:searchcar)
        {
            CarDto carDto =modelMapper.map(c,CarDto.class);
            carDtoList.add(carDto);

        }
        return carDtoList;
    }

    @Override
    public List<CarDto> searchByCcompanyname(String ccompanyname)
    {
        List<Car> searchcompany = carRepository.findByCcompanynameContainingIgnoreCaseOrderByCnameAsc(ccompanyname);
        List<CarDto> carDtoList=new ArrayList<>();
        for(Car c: searchcompany)
        {
            CarDto carDto = modelMapper.map(c,CarDto.class);
            carDtoList.add(carDto);
        }
        return carDtoList;
    }

    @Override
    public List<CarDto> searchByCmodel(String cmodel)
    {
        List<Car> searchmodel = carRepository.findByCmodelContainingIgnoreCaseOrderByCnameAsc(cmodel);
        List<CarDto> carDtoList=new ArrayList<>();
        for(Car c: searchmodel)
        {
            CarDto carDto = modelMapper.map(c,CarDto.class);
            carDtoList.add(carDto);
        }
        return carDtoList;
    }

    @Override
    public List<CarDto> searchByCprice(String minCprice, String maxCprice)
    {
        List<Car> searchprice = carRepository.findCarsByPriceRange(minCprice, maxCprice);
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car c: searchprice)
        {
            CarDto carDto = modelMapper.map(c,CarDto.class);
            carDtoList.add(carDto);
        }
        return carDtoList;

    }

}
