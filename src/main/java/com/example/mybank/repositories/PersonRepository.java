package com.example.mybank.repositories;

import com.example.mybank.models.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

 //private final Map<Integer, Person> storage = new HashMap<Integer, Person>(0, new Person(0,"disa","disa","disa",new HashMap<Integer, Double>(),0000));


public Double getBalanceForId(Integer id){
 return storage.get(id).getAccs().get(1);

}

}
