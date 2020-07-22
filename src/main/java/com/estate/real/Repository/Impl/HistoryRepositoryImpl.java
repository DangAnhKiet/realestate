package com.estate.real.Repository.Impl;

import com.estate.real.Repository.extend.HistoryRepositoryExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryRepositoryImpl implements HistoryRepositoryExtend {
    @Autowired
    MongoTemplate mongoTemplate;
}
