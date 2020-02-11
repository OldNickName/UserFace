package com.corp.UserFace.repository;

import com.corp.UserFace.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends CrudRepository<UserAccount, Long> {
    UserAccount findByUserName (String userName);
}
