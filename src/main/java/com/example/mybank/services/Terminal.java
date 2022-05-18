package com.example.mybank.services;

import com.example.mybank.exceptions.*;
import com.example.mybank.models.*;
import com.example.mybank.services.*;

public interface Terminal {

    void transferToMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;

    void transferToAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException;

    void addMoney(Person person);

    void getBalance(Person person);


}