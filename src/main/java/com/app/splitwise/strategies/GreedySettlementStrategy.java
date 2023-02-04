package com.app.splitwise.strategies;

import com.app.splitwise.models.Expense;
import com.app.splitwise.models.SettledTransaction;
import com.app.splitwise.models.User;
import com.app.splitwise.services.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

/**
 * @author t0k02w6 on 04/02/23
 * @project splitwise-scalar
 */
@Component
public class GreedySettlementStrategy implements SettlementStrategy{
  @Autowired
  private UserService userService;

  @Override
  public List<SettledTransaction> settleExpenses(List<Expense> expenses) {
    // step1 - compute the balances
    Map<Long, Double> balances = computeBalances(expenses);

    // step 1.5 - create treeset
    // step2 - iterate over the balances
    TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((left, right) ->
        (int)(left.getSecond() - right.getSecond()));
    for(Map.Entry<Long, Double> entry: balances.entrySet()) {
      expenseTree.add(Pair.of(entry.getKey(), entry.getValue()));
    }

    List<SettledTransaction> transactions = new ArrayList<>();
    while(expenseTree.size() > 1) {
      // step3 - pick the max and min
      Pair<Long, Double> min = expenseTree.first();
      Pair<Long, Double> max = expenseTree.last();

      SettledTransaction settledTransaction = SettledTransaction
          .builder()
          .from(userService.getUser(max.getFirst()))
          .to(userService.getUser(min.getFirst()))
          .amount(max.getSecond())
          .build();
      expenseTree.remove(min);
      expenseTree.remove(max);
      expenseTree.add(Pair.of(min.getFirst(), min.getSecond() + max.getSecond()));
      transactions.add(settledTransaction);
    }

    // step4 - update the existing balances and add a new one
    return transactions;
  }

  private Map<Long, Double> computeBalances(List<Expense> expenses) {
    Map<Long, Double> balances = new HashMap<>();
    // iterate over expenses

    for(Expense expense: expenses) {
      // owed by
      for(User user: expense.getOwedBy().keySet()) {
        if(!balances.containsKey(user.getId())) {
          balances.put(user.getId(), 0.0);
        }
        balances.put(user.getId(), expense.getOwedBy().get(user) + balances.get(user.getId()));
      }

      for(User user: expense.getPaidBy().keySet()) {
        if(!balances.containsKey(user.getId())) {
          balances.put(user.getId(), 0.0);
        }
        balances.put(user.getId(), balances.get(user.getId()) - expense.getPaidBy().get(user));
      }

    }
    // in the expense what is the owed by and paid by
    // update the balance
    return balances;

  }
}
