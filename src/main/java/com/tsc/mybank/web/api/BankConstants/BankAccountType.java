package com.tsc.mybank.web.api.BankConstants;

public enum BankAccountType {
    SAVING("Savings Account", 0),
    SALARY("Salary Account", 1),
    PPF("PPF Account", 2);

    private String accountType;
    private int accountTypeCode;

    BankAccountType(String s, int i) {
    }
}
