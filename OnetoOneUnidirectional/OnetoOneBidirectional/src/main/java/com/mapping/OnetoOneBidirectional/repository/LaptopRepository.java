package com.mapping.OnetoOneBidirectional.repository;

import com.mapping.OnetoOneBidirectional.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer>{

}
