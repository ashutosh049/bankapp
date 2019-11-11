package com.tsc.mybank.web.controller;

import com.tsc.mybank.web.api.BankConstants.BankAccountType;
import com.tsc.mybank.web.api.helper.BankAccountHelper;
import com.tsc.mybank.web.config.BankConfig;
import com.tsc.mybank.web.persistence.entity.BankAccount;
import com.tsc.mybank.web.persistence.entity.User;
import com.tsc.mybank.web.persistence.repository.UserRepository;
import com.tsc.mybank.web.service.BankService;
import com.tsc.mybank.web.view.request.BankAccountRequestView;
import com.tsc.mybank.web.view.response.BankAccountResponseView;
import com.tsc.mybank.web.view.response.BankAccountResponseViewInner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class BankController {

    private final BankService bankService;
    private final BankConfig bankConfig;
    private final BankAccountHelper bankAccountHelper;
    private final UserRepository userRepository;

    private BankAccountResponseView bankAccountResponseView;

    @Autowired
    public BankController(BankService bankService, BankConfig bankConfig_, BankAccountHelper bankAccountHelper,
                          UserRepository userRepository) {
        this.bankService = bankService;
        this.bankConfig = bankConfig_;
        this.bankAccountHelper = bankAccountHelper;
        this.userRepository = userRepository;
    }

    @GetMapping({"/health"})
    public ResponseEntity<?> health(){
        return ResponseEntity.ok("OK");
    }

    /*@PostMapping(value ="/create", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> create(@RequestBody Map<String, Object> payload){

        String firstName = String.valueOf(payload.get("firstName"));
        String lastName = String.valueOf(payload.get("lastName"));
        int age = Integer.parseInt(String.valueOf(payload.get("age")));
        String address = String.valueOf(payload.get("address"));
        String accountType = String.valueOf(payload.get("accountType"));
        String openingBalance = String.valueOf(payload.get("openingBalance"));


        User user  =  new User();
        user.setFirstName(StringUtils.isNotEmpty(firstName)? firstName.trim() : bankAccountHelper.generateRandomString(6));
        user.setLastName(StringUtils.isNotEmpty(lastName)? lastName.trim() : bankAccountHelper.generateRandomString(10));
        user.setLastName(StringUtils.isNotEmpty(lastName)? lastName.trim() : bankAccountHelper.generateRandomString(10));
        user.setAddress(StringUtils.isNotEmpty(lastName)? lastName.trim() : bankAccountHelper.generateRandomStringWithSpecialChars(20));
        user.setAge(age);


        BankAccount bankAccount  =  new BankAccount();
        bankAccount.setAccountType(BankAccountType.valueOf(accountType));
        bankAccount.setAccountBalance(new BigDecimal(openingBalance));

        user.setBankAccount(bankAccount);

        User persisted = userRepository.save(user);

        if(persisted !=null){
             return ResponseEntity.ok(persisted);
        }

        user.setBankAccount(null);
        return new ResponseEntity<>("Invalid request:["+user+"]", HttpStatus.BAD_REQUEST);
    }*/


    @PostMapping(value ="/create", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> create(@RequestBody BankAccountRequestView requestView){


        User user  =  new User();
        user.setFirstName(requestView.getFirstName());
        user.setLastName(requestView.getLastName());
        user.setAddress(requestView.getAddress());
        user.setAge(requestView.getAge());


        BankAccount bankAccount  =  new BankAccount();
        bankAccount.setAccountType(BankAccountType.valueOf(requestView.getAccountType()));
        bankAccount.setAccountBalance(requestView.getOpeningBalance());

        user.setBankAccount(bankAccount);

        User persisted = userRepository.save(user);

        if(persisted !=null){
            bankAccountResponseView = new BankAccountResponseView();

            bankAccountResponseView.setFname(persisted.getFirstName());
            bankAccountResponseView.setLname(persisted.getFirstName());

            BankAccountResponseViewInner viewInner = new BankAccountResponseViewInner();

            viewInner.setAccountNumber(persisted.getBankAccount().getAccountNumber());
            viewInner.setAccountBalance(persisted.getBankAccount().getAccountBalance());
            viewInner.setAccountType(persisted.getBankAccount().getAccountType());

            /* bankAccountResponseView.setAccountNumber(persisted.getBankAccount().getAccountNumber());
            bankAccountResponseView.setAccountBalance(persisted.getBankAccount().getAccountBalance());
            bankAccountResponseView.setAccountType(persisted.getBankAccount().getAccountType());*/

            bankAccountResponseView.setBankAccountResponseViewInner(viewInner);

            return ResponseEntity.ok(bankAccountResponseView);
        }

        user.setBankAccount(null);
        return new ResponseEntity<>("Invalid request:["+user+"]", HttpStatus.BAD_REQUEST);
    }
    /*@GetMapping({"/","/testBankAccountCreation"})
    public ResponseEntity<?> health(){

        bankAccountResponseView = new BankAccountResponseView();

        bankAccountResponseView.setFname(bankAccountHelper.generateRandomString(6));
        bankAccountResponseView.setLname(bankAccountHelper.generateRandomString(10));
        bankAccountResponseView.setAccountNumber(bankAccountHelper.generateRandomLong(10));
        bankAccountResponseView.setAccountBalance(bankAccountHelper.generateRandomDecimal(10, 2));
        bankAccountResponseView.setAccountType(BankAccountType.valueOf("SALARY"));

        System.out.println("Min Balance"+bankConfig.getAccount().getMinBalance());
        System.out.println("Type Codes : ");
        bankConfig.getAccount().getTypeCodes().forEach(t -> System.out.println(""+t));
        return ResponseEntity.ok(bankAccountResponseView);
    }*/

}
