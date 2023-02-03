package com.app.splitwise.dtos.request;

import com.app.splitwise.models.User;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Data
public class UserRequest {
  private String name;
  private String phoneNumber;
  private String password;


  public User toUser() {
    User user = new User();
    user.setName(this.name);
    user.setPhoneNumber(this.phoneNumber);
    user.setHashedPassword(this.password);
    return user;
  }
}
