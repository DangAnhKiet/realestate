package com.estate.real.Repository.inf;

import com.estate.real.Repository.extend.LandRepositoryExtend;
import com.estate.real.document.Land;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LandRepository extends MongoRepository<Land, ObjectId>, LandRepositoryExtend {
    @Query(value = "{'addressHolder':?0}")
    public List<Land> getAllByAddressHolder(String addressHolder);

    @Query(value = "{'landId':?0, 'status':?1}")
    public Land getByLandIdAndStatus(int landId, String status);

    @Query(value = "{'landId':?0}")
    public Land getByLandId(int landId);
}
