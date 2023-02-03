package com.app.splitwise.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Entity
@Data
public class Expense extends BaseModel{
  private String description;
  private Double amount;

  @Enumerated
  private Currency currency;

  @ManyToOne
  private User createdBy;

  @ManyToMany
  private List<User> users = new ArrayList<>();

  @ElementCollection
  private Map<User, Double> paidBy = new HashMap<>();

  @ElementCollection
  private Map<User, Double> owedBy = new HashMap<>();

}
