package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.account.AccountDto;
import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api")
public class AccountController {

    private final ModelMapper modelMapper;
    private final AccountService accountService;

    @PostMapping("signup")
    public ResponseEntity create(@RequestBody @Valid AccountDto accountDto,
                                 Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Account account = modelMapper.map(accountDto, Account.class);
        accountService.createAccount(account);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
