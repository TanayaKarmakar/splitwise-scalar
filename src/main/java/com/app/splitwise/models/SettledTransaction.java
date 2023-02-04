package com.app.splitwise.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author t0k02w6 on 04/02/23
 * @project splitwise-scalar
 */
@Getter
@Setter
@Builder
public class SettledTransaction {
  private User from;
  private User to;
  private Double amount;
}
