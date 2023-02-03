package com.app.splitwise.dtos.response;

import java.util.List;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Data
public class GroupDTO {
  private Long groupId;
  private String name;
  private List<UserDTO> admins;
  private List<UserDTO> members;
  private UserDTO createdBy;
}
