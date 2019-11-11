package com.tsc.mybank.web.view.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BankAccountResponseView {

    /*@JsonProperty("accountNumber")
    private long accountNumber;

    @JsonProperty("lastName")
    private String lname;

    @JsonProperty("accountType")
    @JsonIgnore
    private BankAccountType accountType;

    @JsonProperty("balance")
    private BigDecimal accountBalance;

    @JsonProperty("firstName")
    private String fname;*/


    @JsonProperty("lastName")
    private String lname;

    @JsonProperty("firstName")
    private String fname;

    @JsonProperty("account-details")
    private BankAccountResponseViewInner bankAccountResponseViewInner;


}
