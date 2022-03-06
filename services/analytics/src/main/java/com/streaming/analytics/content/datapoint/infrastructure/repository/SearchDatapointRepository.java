package com.streaming.analytics.content.datapoint.infrastructure.repository;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.content.datapoint.infrastructure.repository.jpa.DatapointRepositoryJpa;
import com.streaming.analytics.content.datapoint.infrastructure.repository.port.SearchDatapointPort;
import com.streaming.analytics.content.datastream.domain.Datastream;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SearchDatapointRepository implements SearchDatapointPort {

  private final MongoTemplate mongoTemplate;
  private final DatapointRepositoryJpa datapointRepositoryJpa;

  @Override
  public List<Datapoint> search() {
    List<Datastream> datastream = mongoTemplate.findAll(Datastream.class, "datastream");
    return datastream.stream()
        .flatMap(ds -> ds.getDatapointList().stream())
        .collect(Collectors.toList());
  }
}
