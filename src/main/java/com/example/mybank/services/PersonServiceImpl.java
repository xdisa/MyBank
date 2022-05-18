package com.example.mybank.services;

import java.util.HashMap;
import java.util.Scanner;
import com.example.mybank.exceptions.*;
import com.example.mybank.models.*;
import com.example.mybank.services.*;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPerson() {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();

        System.out.println("enter firstName :");
        person.setFirstName(scanner.nextLine());
        System.out.println("enter lastName :");
        person.setLastName(scanner.nextLine());
        System.out.println("enter fatherName :");
        person.setPatronymic(scanner.nextLine());
        System.out.println("enter pin :");
        person.setPin(scanner.nextInt());
        System.out.println("Enter accs :");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter  number " + i + ": ");
            Integer num = scanner.nextInt();
            System.out.print("Enter value " + i + ": ");
            Double value = scanner.nextDouble();
            person.getAccs().put(num, value);
        }
        return person;
    }
}