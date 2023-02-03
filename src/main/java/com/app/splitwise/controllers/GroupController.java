package com.app.splitwise.controllers;

import com.app.splitwise.dtos.request.GroupRequest;
import com.app.splitwise.dtos.response.GroupDTO;
import com.app.splitwise.services.GroupService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@RestController
@RequestMapping("/groups")
public class GroupController {
  @Autowired
  private GroupService groupService;

  @PostMapping
  public GroupDTO createGroup(GroupRequest groupRequest) {
    validate(groupRequest);
    return groupService.createGroup(groupRequest);
  }

  private void validate(GroupRequest groupRequest) {
    if(Objects.isNull(groupRequest.getName()))
      throw new RuntimeException("Group name is null");
  }
}
