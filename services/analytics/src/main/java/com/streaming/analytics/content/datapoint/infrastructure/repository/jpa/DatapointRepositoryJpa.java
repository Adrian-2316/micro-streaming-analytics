package com.streaming.analytics.content.datapoint.infrastructure.repository.jpa;

import com.streaming.analytics.content.datapoint.domain.DatapointJpa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatapointRepositoryJpa extends MongoRepository<DatapointJpa, String> {}
