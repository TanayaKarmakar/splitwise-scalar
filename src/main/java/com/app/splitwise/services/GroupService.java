package com.app.splitwise.services;

import com.app.splitwise.dtos.request.GroupRequest;
import com.app.splitwise.dtos.response.GroupDTO;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
public interface GroupService {
  GroupDTO createGroup(GroupRequest groupRequest);
}
