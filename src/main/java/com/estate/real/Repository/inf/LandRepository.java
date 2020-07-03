package com.estate.real.Repository.inf;

import com.estate.real.Repository.extend.LandRepositoryExtend;
import com.estate.real.document.Land;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LandRepository extends MongoRepository<Land, ObjectId>, LandRepositoryExtend {
}
