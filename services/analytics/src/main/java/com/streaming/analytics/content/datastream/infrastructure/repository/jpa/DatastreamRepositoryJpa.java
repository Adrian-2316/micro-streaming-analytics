package com.streaming.analytics.content.datastream.infrastructure.repository.jpa;

import com.streaming.analytics.content.datastream.domain.DatastreamJpa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatastreamRepositoryJpa extends MongoRepository<DatastreamJpa, String> {}
