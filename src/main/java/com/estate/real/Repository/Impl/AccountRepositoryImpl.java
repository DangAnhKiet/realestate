package com.estate.real.Repository.Impl;

import com.estate.real.Repository.extend.AccountRepositoryExtend;
import com.estate.real.document.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AccountRepositoryImpl implements AccountRepositoryExtend {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateInformation(String nameLogin, Map<String, Object> updateValues) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nameLogin").is(nameLogin));
        Update update = new Update();
        if (updateValues != null) {
            for (String key : updateValues.keySet()) {
                if (updateValues.get(key) == null)
                    update.unset(key);
                else update.set(key, updateValues.get(key));
            }
        }
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true).upsert(true);
        mongoTemplate.findAndModify(query, update, options, Account.class);
    }
}
