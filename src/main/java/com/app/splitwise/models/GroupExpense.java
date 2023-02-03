package com.app.splitwise.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Entity
@Data
public class GroupExpense extends BaseModel {
  @ManyToOne
  private Group group;

  @OneToOne
  private Expense expense;
}
