package com.poc.controller;

import com.poc.contrainte.validation.UserValidator;
import com.poc.donnee.dto.UserDTO;
import com.poc.donnee.dto.UserRequestDTO;
import com.poc.service.applicatif.UserCUDSA;
import com.poc.service.applicatif.UserRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserCUDSA userCUDSA;
    private final UserRSA userRSA;
    private final UserValidator userValidator;

    @InitBinder("userRequestDTO")
    protected void initUserRequestDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(userValidator);
    }

    @Operation(summary = "WS used to create user")
    @PostMapping
    public UserDTO saveUser(@RequestBody @Validated UserRequestDTO userRequest) {
        return userCUDSA.saveUser(userRequest);
    }

    @Operation(summary = "WS used to get all users")
    @GetMapping
    public HelpPage<UserDTO> getAllUsers(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRSA.getAllUsers(pageable);
    }

    @Operation(summary = "WS used to get user by id")
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userRSA.getUserById(id);
    }

    @Operation(summary = "WS used to delete note by id")
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userCUDSA.deleteUserById(id);
        return "User with id " + id + " deleted successfully !";
    }

}
