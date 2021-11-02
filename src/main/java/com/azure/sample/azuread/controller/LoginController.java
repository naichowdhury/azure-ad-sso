package com.azure.sample.azuread.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@GetMapping("Admin")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Welcome to Admin Screen";
    }
	
	@GetMapping("User")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('APPROLE_User', 'APPROLE_Admin')")
    public String User() {
        return "Welcome to User Screen";
    }
}
