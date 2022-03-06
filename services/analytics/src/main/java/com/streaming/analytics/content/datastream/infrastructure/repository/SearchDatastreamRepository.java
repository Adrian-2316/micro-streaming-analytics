package com.streaming.analytics.content.datastream.infrastructure.repository;

import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.datastream.infrastructure.repository.jpa.DatastreamRepositoryJpa;
import com.streaming.analytics.content.datastream.infrastructure.repository.port.SearchDatastreamPort;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SearchDatastreamRepository implements SearchDatastreamPort {

  private final MongoTemplate mongoTemplate;
  private final DatastreamRepositoryJpa datastreamRepositoryJpa;

  @Override
  public List<Datastream> search() {
    return mongoTemplate.findAll(Datastream.class, "datastream");
  }
}
