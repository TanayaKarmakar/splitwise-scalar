package com.app.splitwise.repositories;

import com.app.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author t0k02w6 on 01/02/23
 * @project splitwise-scalar
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
}
