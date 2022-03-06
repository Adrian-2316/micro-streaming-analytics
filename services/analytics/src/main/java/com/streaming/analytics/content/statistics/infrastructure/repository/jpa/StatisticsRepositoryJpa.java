package com.streaming.analytics.content.statistics.infrastructure.repository.jpa;

import com.streaming.analytics.content.statistics.domain.StatisticsJpa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepositoryJpa extends MongoRepository<StatisticsJpa, String> {}
