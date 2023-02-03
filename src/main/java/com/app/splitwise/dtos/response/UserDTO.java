package com.app.splitwise.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Getter
@Data
public class UserDTO {
  private String name;
  private String phoneNumber;
}
