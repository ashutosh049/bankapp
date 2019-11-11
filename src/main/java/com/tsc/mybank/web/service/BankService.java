package com.tsc.mybank.web.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BankService {

    private final Random  random = new Random();

    public int generate10DigitBankAccountNumber(){

        StringBuffer bankAccountNo = new StringBuffer();

        for (int i = 0; i <10 ; i++) {
            bankAccountNo.append(random.nextInt(9));
        }
        return Integer.valueOf(bankAccountNo.toString());
    }
}
