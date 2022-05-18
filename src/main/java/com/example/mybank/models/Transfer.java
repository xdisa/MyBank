package com.example.mybank.models;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import javax.security.auth.login.AccountLockedException;
import com.example.mybank.services.*;
import com.example.mybank.exceptions.*;
import lombok.Data;


@Data
public class Transfer {

    private int numberOfTransfer;
    private Date date;
    private Person sender;
    private Person recipient;
    private int amount;

    public Transfer(int numberOfTransfer, int amount, Date date, Person sender, Person recipient) {
        this.numberOfTransfer = numberOfTransfer;
        this.amount = amount;
        this.date = date;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Transfer(int numberOfTransfer, int amount, Date date, Person sender) {
        this.numberOfTransfer = numberOfTransfer;
        this.amount = amount;
        this.date = date;
        this.sender = sender;
    }


    @Override
    public String toString() {
        return "models.Transfer{" +
                "numberOfTransfer=" + numberOfTransfer +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return numberOfTransfer == transfer.numberOfTransfer && amount == transfer.amount && Objects.equals(date, transfer.date) && Objects.equals(sender, transfer.sender) && Objects.equals(recipient, transfer.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTransfer, amount, date, sender, recipient);
    }
}
