package com.example.mybank.services;

import com.example.mybank.exceptions.BlockAccException;
import com.example.mybank.exceptions.DontCorrentPinCodeExeption;
import com.example.mybank.models.Person;
import com.example.mybank.models.Transfer;
import com.example.mybank.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountLockedException;
import java.util.Date;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService  {
    private static final long INPUT_BLOCKING_TIME_MILLIS = 5000L;
    public static int counter = 0;

    private final PersonRepository repository;


    @Override
    public Transfer getBalance(Person sender) {

        Integer id = sender.getId();
        Double balance = repository.getBalanceForId(id);

        if(balance==null){ throw new IllegalArgumentException();}

        int amount = balance.intValue();
        Date transferDate = new Date();
        System.out.println("date operation :" + transferDate);
        return new Transfer(counter, amount, transferDate, sender);
    }

    @Override
    public Transfer addMoney(Person sender, int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice accs number(1-3)");
        int choice = scanner.nextInt();

        Double buff = sender.getAccs().get(choice);
        sender.getAccs().put(choice, buff + amount);

        System.out.println("operation number :" + counter++);

        Date transferDate = new Date();

        System.out.println("date transaction :" + transferDate);

        return new Transfer(counter, amount, transferDate, sender);
    }


    @Override
    public Transfer addMoneyWithPinCode(Person sender) throws DontCorrentPinCodeExeption, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PinValidator blocking = new PinValidator(INPUT_BLOCKING_TIME_MILLIS);

        System.out.println("ENTER PIN CODE");
        int tryCounter = 0;
        while (true) {
            try {
                int pin = scanner.nextInt();
                if (blocking.checkBlocking()) {
                    try {
                        TerminalServer.showBlockingTimeLeft(blocking);
                    } catch (AccountLockedException accountLockedEx) {
                        System.out.println(accountLockedEx.getMessage());
                    }
                } else {
                    TerminalServer.checkPin(pin, sender);
                    break;
                }
            } catch (DontCorrentPinCodeExeption ex) {
                System.out.println(ex.getMessage());
                try {
                    TerminalServer.checkPinInputTryCount(++tryCounter);
                } catch (BlockAccException blockAcException) {
                    System.out.println(blockAcException.getMessage());
                    blocking.start();
                    tryCounter = 0;
                }
            }


            System.out.println("test");
        }

        //добавление денег вот тут, до этого логика из Трансфера

        //выбор счета зачисления
        int amount;

        System.out.println("enter amount :");

        amount = scanner.nextInt();

            System.out.println("Choice accs number(1-3)");
            int choice = scanner.nextInt();

            Double buff = sender.getAccs().get(choice);
            sender.getAccs().put(choice, buff + amount);




        System.out.println("operation number :" + counter++);

        Date transferDate = new Date();

        System.out.println("date transaction :" + transferDate);

        return new Transfer(counter, amount, transferDate, sender);
    }

    @Override
    public Transfer getBalanceWithPinCode(Person sender) throws DontCorrentPinCodeExeption, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PinValidator blocking = new PinValidator(INPUT_BLOCKING_TIME_MILLIS);

        System.out.println("ENTER PIN CODE");
        int tryCounter = 0;
        while (true) {
            try {
                int pin = scanner.nextInt();
                if (blocking.checkBlocking()) {
                    try {
                        TerminalServer.showBlockingTimeLeft(blocking);
                    } catch (AccountLockedException accountLockedEx) {
                        System.out.println(accountLockedEx.getMessage());
                    }
                } else {
                    TerminalServer.checkPin(pin, sender);
                    break;
                }
            } catch (DontCorrentPinCodeExeption ex) {
                System.out.println(ex.getMessage());
                try {
                    TerminalServer.checkPinInputTryCount(++tryCounter);
                } catch (BlockAccException blockAcException) {
                    System.out.println(blockAcException.getMessage());
                    blocking.start();
                    tryCounter = 0;
                }
            }
        }
        System.out.println("Choice accs number(1-3)");
        int choice = scanner.nextInt();
        Double buff = sender.getAccs().get(choice);
        int amount = buff.intValue();
        Date transferDate = new Date();
        System.out.println("date operation :" + transferDate);
        return new Transfer(counter, amount, transferDate, sender);
    }
}
