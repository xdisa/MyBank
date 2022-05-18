package com.example.mybank.controllers;


import com.example.mybank.exceptions.DontCorrentPinCodeExeption;
import com.example.mybank.models.Person;
import com.example.mybank.models.Transfer;
import com.example.mybank.services.Terminal;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TransferController {

    private final Terminal terminal;


    @GetMapping("/transferToAnother")
    public void transferToAnother(@PathVariable Person sender, Person recipient) throws DontCorrentPinCodeExeption, InterruptedException {

        terminal.transferToAnother(sender, recipient);
    }
    @GetMapping("/transferToMyself")
    public void transferToAnother(@PathVariable Person sender) throws DontCorrentPinCodeExeption, InterruptedException {

        terminal.transferToMySelf(sender);
    }
}
