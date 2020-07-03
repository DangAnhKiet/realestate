package com.estate.real.Repository.Impl;

import com.estate.real.Repository.extend.LandRepositoryExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LandRepositoryImpl implements LandRepositoryExtend {
    @Autowired
    MongoTemplate mongoTemplate;
}
