package com.sts.CarJWT.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="car")
@Data
public class Car
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
