package com.streaming.analytics.content.datastream.infrastructure.controller.dto.output;

import com.streaming.analytics.content.datastream.domain.Datastream;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleDatastreamOutputDTO implements Serializable {

  protected Long id;
  protected String feed;

  public SimpleDatastreamOutputDTO(Datastream datastream) {
    if (datastream == null) return;
    if (datastream.getId() != null) this.setId(datastream.getId());
    if (datastream.getFeed() != null) this.setFeed(datastream.getFeed());
  }
}
