package com.app.splitwise.exceptions;

import java.util.function.Supplier;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
