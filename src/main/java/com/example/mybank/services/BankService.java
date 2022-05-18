package com.example.mybank.services;

import com.example.mybank.exceptions.DontCorrentPinCodeExeption;
import com.example.mybank.models.Person;
import com.example.mybank.models.Transfer;

public interface BankService {

    public Transfer getBalance(Person sender);

    public Transfer addMoney(Person sender, int amount);

    public Transfer addMoneyWithPinCode(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;

    public Transfer getBalanceWithPinCode(Person sender) throws DontCorrentPinCodeExeption, InterruptedException;
}
