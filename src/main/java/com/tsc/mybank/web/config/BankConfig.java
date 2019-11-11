package com.tsc.mybank.web.config;

import com.tsc.mybank.web.api.helper.BankAccountHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix="mybank")
public class BankConfig {

    private String officehoursStartTime;
    private String officehoursCloseTime;
    private Account account = new Account();

    @Getter
    @Setter
    public class Account{
        private List<Integer> typeCodes;
        private BigDecimal minBalance;

    }

    @Bean
    public BankAccountHelper bankAccountHelper(){
        return new BankAccountHelper();
    }

}

