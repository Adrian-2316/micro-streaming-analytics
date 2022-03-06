package com.streaming.analytics.content.datapoint.domain;

import com.streaming.analytics.shared.Auditable;
import lombok.*;

import static com.streaming.analytics.shared.ObjectUtil.copyProperties;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Datapoint extends Auditable {

  private Long from;
  private Long at;
  private Double value;

  private DatapointJpa datapointJpa;

  public Datapoint(DatapointJpa datapointJpa) {
    if (datapointJpa == null) return;
    this.datapointJpa = datapointJpa;
    this.setAt(datapointJpa.getAt());
    this.setFrom(datapointJpa.getFrom());
    this.setValue(datapointJpa.getValue());
  }

  public void update(Datapoint datapoint) {
    copyProperties(
        datapoint,
        this,
        new String[] {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"});
  }
}
