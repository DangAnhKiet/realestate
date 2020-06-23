package com.estate.real.Repository.inf;

import com.estate.real.Repository.extend.AccountRepositoryExtend;
import com.estate.real.document.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AccountRepository extends MongoRepository<Account, AccountRepositoryExtend> {
}
