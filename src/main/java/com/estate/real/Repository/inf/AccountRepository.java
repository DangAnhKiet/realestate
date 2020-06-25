package com.estate.real.Repository.inf;

import com.estate.real.Repository.extend.AccountRepositoryExtend;
import com.estate.real.document.Account;
import com.estate.real.model.AccountStatus;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, ObjectId>, AccountRepositoryExtend {
    @Query(value = "{'nameLogin':?0}")
    public Account findByNameLogin(String nameLogin);

    @Query(value = "{'status':?0}")
    public List<Account> findByStatus(String status);

}
