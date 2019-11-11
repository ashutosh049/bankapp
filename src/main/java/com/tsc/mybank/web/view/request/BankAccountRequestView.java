package com.tsc.mybank.web.view.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountRequestView {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String accountType;
    private BigDecimal openingBalance;
}
