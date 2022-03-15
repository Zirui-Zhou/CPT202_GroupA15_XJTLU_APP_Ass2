package com.groupa15.repo;

import com.groupa15.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findOneByUsername(String username);
}
