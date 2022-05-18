package com.example.mybank.services;

import com.example.mybank.exceptions.*;
import com.example.mybank.models.*;
import com.example.mybank.services.*;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountLockedException;

@Service
public class TerminalServer {

    public static void showBlockingTimeLeft(PinValidator blocking) throws AccountLockedException {
        throw new AccountLockedException("доступ заблокирован на: " + blocking.getSecondsCountToEnd() + "s.");
    }

    public static void checkPin(int pin, Person person) throws DontCorrentPinCodeExeption {
        if (pin != getCorrectPin(person)) {
            throw new DontCorrentPinCodeExeption("неверный пин код");
        } else {
            System.out.println("доступ разрешен");
        }
    }

    public static void checkPinInputTryCount(int currentTry) {
        if (currentTry == 4) {
            throw new BlockAccException("доступ заблокирован");
        }
    }

    private static int getCorrectPin(Person person) {
        return person.getPin();
    }
}
