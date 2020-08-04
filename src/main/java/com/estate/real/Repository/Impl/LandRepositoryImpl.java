package com.estate.real.Repository.Impl;

import com.estate.real.Repository.extend.LandRepositoryExtend;
import com.estate.real.document.Land;
import com.estate.real.model.enums.LandStatus;
import com.estate.real.model.request.LandFilterRequest;
import com.estate.real.model.request.LandPagingRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Repository
public class LandRepositoryImpl implements LandRepositoryExtend {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Land> getLandPaging(LandPagingRequest request) {
        Criteria criteria = new Criteria();
        if (StringUtils.hasText(request.getId())) {
            if ("previous".equals(request.getAction())) {
                criteria = criteria.and("_id").gt(new ObjectId(request.getAction()));
            } else criteria = criteria.and("_id").lt(new ObjectId(request.getAction()));
        }
        Query query = new Query(criteria);
        query.limit(request.getLimit());
        query.addCriteria(Criteria.where("status").is(request.getStatus()));

        return mongoTemplate.find(query, Land.class);
    }

    @Override
    public List<Land> getAllLands() {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(LandStatus.active.toString()));
        return mongoTemplate.find(query, Land.class);
    }

    @Override
    public List<Land> getFilterLand(LandFilterRequest request) {
        Criteria criteria = new Criteria();
        criteria = criteria.and("district").is(request.getDistrict());
        criteria = criteria.and("street").is(request.getStreet());
        criteria = criteria.and("price").gte(request.getPrice());
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Land.class);
    }

    @Override
    public void updateLand(int landId, Map<String, Object> updateValues) {
        Query query = new Query();
        query.addCriteria(Criteria.where("landId").is(landId));
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
        mongoTemplate.findAndModify(query, update, options, Land.class);
    }
}
