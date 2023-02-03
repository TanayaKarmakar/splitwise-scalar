package com.app.splitwise.dtos.request;

import java.util.List;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Data
public class GroupRequest {
  private String name;
  private List<Long> admins;
  private List<Long> members;
  private Long createdBy;
}
