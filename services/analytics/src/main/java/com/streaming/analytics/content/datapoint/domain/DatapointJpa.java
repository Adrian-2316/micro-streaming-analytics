package com.streaming.analytics.content.datapoint.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "datapoint")
public class DatapointJpa {

  private Long from;
  private Long at;
  private Double value;

  public DatapointJpa(Datapoint datapoint) {
    if (datapoint == null) return;
    this.setAt(datapoint.getAt());
    this.setFrom(datapoint.getFrom());
    this.setValue(datapoint.getValue());
  }
}
