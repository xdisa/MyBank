package com.example.mybank.services;

import com.example.mybank.exceptions.*;
import com.example.mybank.models.*;
import com.example.mybank.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class PinValidator {
    private boolean starting = false;
    private long endTimeMillis;
    private final long blockingTimeMillis;


    public long getSecondsCountToEnd() {
        return (endTimeMillis - System.currentTimeMillis()) / 1000L;
    }

    public void start() {
        long startTimeMillis = System.currentTimeMillis();
        endTimeMillis = startTimeMillis + blockingTimeMillis;
        starting = true;
    }

    private void stop() {
        starting = false;
    }

    public boolean checkBlocking() {
        if (!starting || System.currentTimeMillis() >= endTimeMillis) {
            stop();
            return false;
        } else {
            return true;
        }
    }
}
