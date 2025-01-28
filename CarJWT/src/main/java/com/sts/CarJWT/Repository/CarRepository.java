package com.sts.CarJWT.Repository;

import com.sts.CarJWT.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer>
{
    List<Car> findByCname(String cname);
    List<Car> findByCnameContainingIgnoreCaseOrderByCnameAsc(String cname);
    List<Car> findByCcompanynameContainingIgnoreCaseOrderByCnameAsc(String ccompanyname);
    List<Car> findByCmodelContainingIgnoreCaseOrderByCnameAsc(String cmodel);

   //To Get the price based on range
    @Query("SELECT c FROM Car c WHERE c.cprice BETWEEN :minCPrice AND :maxCPrice")
    List<Car> findCarsByPriceRange(String minCPrice, String maxCPrice);
}
