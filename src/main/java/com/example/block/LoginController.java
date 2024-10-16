package com.example.block;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

  @GetMapping("/user")
  public String getUser() {
    return "Welcome, User";
  }

  @GetMapping("/admin")
  public String getAdmin() {
    return "Welcome, Admin";
  }

}
