package com.sts.CarJWT.dto;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CarDto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;

    String cname;
    String ccompanyname;
    String cprice;
    String cmodel;
    String cquantity;

}
