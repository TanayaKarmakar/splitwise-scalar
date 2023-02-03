package com.app.splitwise.services.impl;

import com.app.splitwise.dtos.request.UserRequest;
import com.app.splitwise.dtos.response.UserDTO;
import com.app.splitwise.exceptions.NotFoundException;
import com.app.splitwise.models.User;
import com.app.splitwise.repositories.UserRepository;
import com.app.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO createUser(UserRequest userRequest) {
    User user = userRequest.toUser();

    User savedUser = userRepository.save(user);
    return savedUser.toUserDTO();
  }

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("User not found"));
  }
}
