package com.app.splitwise.services.impl;

import com.app.splitwise.dtos.request.GroupRequest;
import com.app.splitwise.dtos.response.GroupDTO;
import com.app.splitwise.models.Group;
import com.app.splitwise.models.User;
import com.app.splitwise.repositories.GroupRepository;
import com.app.splitwise.services.GroupService;
import com.app.splitwise.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Service
public class GroupServiceImpl implements GroupService {
  @Autowired
  private UserService userService;

  @Autowired
  private GroupRepository groupRepository;

  @Override
  public GroupDTO createGroup(GroupRequest groupRequest) {

    List<User> members = groupRequest.getMembers().stream()
        .map(memberId -> userService.getUser(memberId))
        .collect(Collectors.toList());

    List<User> admins = groupRequest.getAdmins().stream()
        .map(adminId -> userService.getUser(adminId))
        .collect(Collectors.toList());

    User createdBy = userService.getUser(groupRequest.getCreatedBy());
    Group group = new Group();
    group.setName(groupRequest.getName());
    group.setAdmins(admins);
    group.setMembers(members);
    group.setCreatedBy(createdBy);

    Group savedGroup = groupRepository.save(group);
    return savedGroup.toGroupDTO();
  }
}
