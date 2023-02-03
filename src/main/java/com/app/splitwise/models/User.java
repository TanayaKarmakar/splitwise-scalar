package com.app.splitwise.models;

import com.app.splitwise.dtos.response.UserDTO;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Entity
@Table(name = "users")
@Data
public class User extends BaseModel{
  private String name;
  private String phoneNumber;
  private String hashedPassword;

  public UserDTO toUserDTO() {
    UserDTO userDTO = new UserDTO();
    userDTO.setName(this.name);
    userDTO.setPhoneNumber(this.phoneNumber);
    return userDTO;
  }
}
