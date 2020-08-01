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

    @Query(value = "{'nameLogin':?0,'status':?1}")
    public Account findByNameLoginAndStatus(String nameLogin, String status);

    @Query(value = "{'address':?0}")
    public Account findByAddress(String address);

    @Query(value = "{'nameLogin':?0, 'role':?1}")
    public Account findByNameLoginAndRole(String nameLogin, String role);
}
