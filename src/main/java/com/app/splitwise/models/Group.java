package com.app.splitwise.models;

import com.app.splitwise.dtos.response.GroupDTO;
import com.app.splitwise.dtos.response.UserDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Entity
@Table(name = "groups")
@Data
public class Group extends BaseModel {
  private String name;

  @ManyToMany
  private List<User> admins = new ArrayList<>();

  @ManyToMany
  private List<User> members = new ArrayList<>();

  @ManyToOne
  private User createdBy;

  public GroupDTO toGroupDTO() {
    GroupDTO groupDTO = new GroupDTO();
    groupDTO.setGroupId(this.id);
    groupDTO.setName(this.name);

    List<UserDTO> admins = this.admins.stream()
        .map(User::toUserDTO)
        .collect(Collectors.toList());
    groupDTO.setAdmins(admins);

    List<UserDTO> members = this.members.stream()
        .map(User::toUserDTO)
        .collect(Collectors.toList());
    groupDTO.setMembers(members);
    return groupDTO;
  }
}
