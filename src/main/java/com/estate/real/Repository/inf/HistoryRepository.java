package com.estate.real.Repository.inf;

import com.estate.real.Repository.extend.HistoryRepositoryExtend;
import com.estate.real.document.History;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HistoryRepository extends MongoRepository<History, ObjectId>, HistoryRepositoryExtend {

    @Query(value = "{'buyer':?0}")
    public List<History> getAllByBuyer(String buyer);
}
