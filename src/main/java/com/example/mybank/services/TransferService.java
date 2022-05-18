package com.example.mybank.services;

import com.example.mybank.exceptions.*;
import com.example.mybank.models.*;
import com.example.mybank.services.*;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    Transfer getForAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException;

    Transfer getForMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;
}
