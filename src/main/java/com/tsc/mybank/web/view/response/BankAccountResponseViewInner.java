package com.tsc.mybank.web.view.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsc.mybank.web.api.BankConstants.BankAccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountResponseViewInner {

    @JsonProperty("accountNumber")
    private long accountNumber;

    @JsonProperty("accountType")
    private BankAccountType accountType;

    @JsonProperty("balance")
    private BigDecimal accountBalance;


}
