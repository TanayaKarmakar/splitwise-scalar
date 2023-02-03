package com.app.splitwise.services;

import com.app.splitwise.dtos.request.UserRequest;
import com.app.splitwise.dtos.response.UserDTO;
import com.app.splitwise.models.User;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
public interface UserService {
  UserDTO createUser(UserRequest userRequest);

  User getUser(Long id);
}
