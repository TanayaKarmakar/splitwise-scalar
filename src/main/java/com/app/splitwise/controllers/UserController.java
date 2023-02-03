package com.app.splitwise.controllers;

import com.app.splitwise.dtos.request.UserRequest;
import com.app.splitwise.dtos.response.UserDTO;
import com.app.splitwise.services.UserService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping
  public UserDTO createUser(@RequestBody UserRequest userRequest) {
    validate(userRequest);
    return userService.createUser(userRequest);
  }

  private void validate(UserRequest userRequest) {
    if(Objects.isNull(userRequest.getPassword())) {
      throw new RuntimeException("Password is null");
    }
  }
}
