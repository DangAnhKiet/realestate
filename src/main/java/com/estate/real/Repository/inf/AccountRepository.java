package com.estate.real.Repository.inf;

import com.estate.real.Repository.extend.AccountRepositoryExtend;
import com.estate.real.document.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, ObjectId>, AccountRepositoryExtend {

    @Query(value = "{'status':?0}")
    public List<Account> findAllByStatus(String status);

    @Query(value = "{'nameLogin':?0,'role':?1}")
    public Account findByNameLogin(String nameLogin, String role);

    @Query(value = "{'address':?0}")
    public Account findByAddress(String address);
}
