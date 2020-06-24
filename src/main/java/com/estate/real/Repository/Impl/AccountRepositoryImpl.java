package com.estate.real.Repository.Impl;

import com.estate.real.Repository.extend.AccountRepositoryExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepositoryExtend {
    @Autowired
    MongoTemplate mongoTemplate;
}
