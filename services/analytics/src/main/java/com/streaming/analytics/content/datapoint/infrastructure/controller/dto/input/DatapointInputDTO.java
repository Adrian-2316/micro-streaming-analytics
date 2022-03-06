package com.streaming.analytics.content.datapoint.infrastructure.controller.dto.input;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class DatapointInputDTO {

  private Long from;
  private Long at;
  private Double value;

  public Datapoint datapoint(Datapoint datapoint) {
    datapoint.setAt(this.getAt());
    datapoint.setFrom(this.getFrom());
    datapoint.setValue(this.getValue());
    return datapoint;
  }
}
