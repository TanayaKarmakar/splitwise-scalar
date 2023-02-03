package com.app.splitwise.utils.passwordencoder.impl;

import com.app.splitwise.utils.passwordencoder.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@Service
public class BCryptPasswordEncoder implements PasswordEncoder {


  @Override
  public String encode(String password) {
    return null;
  }

  @Override
  public boolean matches(String plainText, String encodePassword) {
    return false;
  }
}
