package com.streaming.analytics.content.statistics.infrastructure.repository;

import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.content.statistics.infrastructure.repository.port.SearchStatisticsPort;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SearchStatisticsRepository implements SearchStatisticsPort {

  private final MongoTemplate mongoTemplate;

  @Override
  public List<Statistics> search() {
    List<Datastream> all = mongoTemplate.findAll(Datastream.class, "datastream");

    return all.stream().map(Datastream::getStatistics).collect(Collectors.toList());
  }
}
