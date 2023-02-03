package com.app.splitwise.utils.passwordencoder.impl;

import com.app.splitwise.utils.passwordencoder.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Service
public class BCryptEncoder implements PasswordEncoder {
  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public String encode(String password) {
    return encoder.encode(password);
  }

  @Override
  public boolean matches(String plainText, String encodePassword) {
    return encoder.matches(plainText, encodePassword);
  }
}
