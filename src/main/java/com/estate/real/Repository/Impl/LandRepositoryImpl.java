package com.estate.real.Repository.Impl;

import com.estate.real.Repository.extend.LandRepositoryExtend;
import com.estate.real.document.Land;
import com.estate.real.model.enums.LandStatus;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.response.LandResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class LandRepositoryImpl implements LandRepositoryExtend {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Land> getLandPaging(LandPagingRequest request) {
        Criteria criteria = new Criteria();
        if (StringUtils.hasText(request.getId())){
            if ("previous".equals(request.getAction())) {
                criteria = criteria.and("_id").gt(new ObjectId(request.getAction()));
            }
            else criteria = criteria.and("_id").lt(new ObjectId(request.getAction()));
        }
        Query query = new Query(criteria);
        query.limit(request.getLimit());
        query.addCriteria(Criteria.where("status").is(request.getStatus()));

        return mongoTemplate.find(query, Land.class);
    }

    @Override
    public List<Land> getAllLands() {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").lt(LandStatus.deleted.ordinal()));

        return mongoTemplate.find(query, Land.class);
    }
}
