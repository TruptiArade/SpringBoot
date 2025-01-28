package com.maptut.ManyToManyUnidirectional.repository;

import com.maptut.ManyToManyUnidirectional.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{
}
