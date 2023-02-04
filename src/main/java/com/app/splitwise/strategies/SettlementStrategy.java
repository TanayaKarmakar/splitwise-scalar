package com.app.splitwise.strategies;

import com.app.splitwise.models.Expense;
import com.app.splitwise.models.SettledTransaction;
import java.util.List;

/**
 * @author t0k02w6 on 04/02/23
 * @project splitwise-scalar
 */
public interface SettlementStrategy {
  List<SettledTransaction> settleExpenses(List<Expense> expenses);
}
