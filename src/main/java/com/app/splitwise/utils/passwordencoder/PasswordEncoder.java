package com.app.splitwise.utils.passwordencoder;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
public interface PasswordEncoder {
  String encode(String password);

  boolean matches(String plainText, String encodePassword);
}
