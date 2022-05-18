package com.example.mybank.controllers;


import com.example.mybank.models.Person;
import com.example.mybank.models.Transfer;
import com.example.mybank.services.BankServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController("/balance")
public class BalanceController {

    private final BankServiceImpl bankService;




    @GetMapping("/{id}")
public Transfer getBalance(@PathVariable Person person) {
       return bankService.getBalance(person);
}

@PostMapping("/add")
    public Transfer addMoney(@RequestBody Person person, int amount) {
 return bankService.addMoney(person, amount);

}

}
