package com.tsc.mybank.web.api.helper;

import java.math.BigDecimal;
import java.util.Random;

public class BankAccountHelper {

    private static final String availableChars = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvxyz";
    private static final String availableCharsWithSpecial = availableChars+" -,./#@$!()*";
    private static final Random random = new Random();

    public String generateRandomString(int length) {

        StringBuffer randomValue = new StringBuffer();

        for (int i = 0; i < length; i++) {
            randomValue.append(availableChars.charAt(random.nextInt(availableChars.length()-1)));
        }
        return randomValue.toString();
    }

    public Long generateRandomLong(int length) {

        StringBuffer randomValue = new StringBuffer();

        for (int i = 0; i < length; i++) {
            randomValue.append(random.nextInt(9));
        }
        return Long.valueOf(randomValue.toString());
    }

    public BigDecimal generateRandomDecimal(int length, int precision) {
        StringBuffer randomValue = new StringBuffer();

        for (int i = 0; i <= length - precision; i++) {
            randomValue.append(random.nextInt(9));
        }
        randomValue.append(".");

        for (int i = 0; i < precision; i++) {
            randomValue.append(random.nextInt(9));
        }
        return new BigDecimal(randomValue.toString());
    }

    public String generateRandomStringWithSpecialChars(int length) {
        StringBuffer randomValue = new StringBuffer();

        for (int i = 0; i < length; i++) {
            randomValue.append(availableChars.charAt(random.nextInt(availableCharsWithSpecial.length()-1)));
        }
        return randomValue.toString();
    }
}
