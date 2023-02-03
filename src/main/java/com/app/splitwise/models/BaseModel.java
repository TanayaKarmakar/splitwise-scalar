package com.app.splitwise.models;

import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @CreatedDate
  protected Date createdAt;

  @LastModifiedDate
  protected Date lastUpdatedAt;
}
