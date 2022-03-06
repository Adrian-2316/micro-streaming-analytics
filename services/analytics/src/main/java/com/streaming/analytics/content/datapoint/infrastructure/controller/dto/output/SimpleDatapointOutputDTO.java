package com.streaming.analytics.content.datapoint.infrastructure.controller.dto.output;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleDatapointOutputDTO implements Serializable {
  protected Long at;
  protected Long from;
  protected Double value;

  public SimpleDatapointOutputDTO(Datapoint datapoint) {
    if (datapoint == null) return;
    if (datapoint.getAt() != null) this.setAt(datapoint.getAt());
    if (datapoint.getFrom() != null) this.setFrom(datapoint.getFrom());
    if (datapoint.getValue() != null) this.setValue(datapoint.getValue());
  }
}
