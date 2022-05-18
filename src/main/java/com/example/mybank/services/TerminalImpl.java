package com.example.mybank.services;

import com.example.mybank.exceptions.*;
import com.example.mybank.models.*;
import com.example.mybank.services.*;
import org.springframework.stereotype.Service;

@Service
public class TerminalImpl implements Terminal {
    private final TransferService transferService;

    public TerminalImpl(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public void transferToMySelf(Person sender) throws DontCorrentPinCodeExeption, InterruptedException {
        transferService.getForMySelf(sender);

    }

    @Override
    public void transferToAnother(Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException {
        transferService.getForAnother(sender, recipient);
    }

////////////////////////////////////////////////////////
    @Override
    public void addMoney(Person sender) {

    }

    @Override
    public void getBalance(Person person) {

    }
}
