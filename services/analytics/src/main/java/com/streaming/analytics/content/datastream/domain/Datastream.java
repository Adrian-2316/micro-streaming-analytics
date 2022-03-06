package com.streaming.analytics.content.datastream.domain;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.shared.Auditable;
import lombok.*;

import java.util.List;

import static com.streaming.analytics.shared.ObjectUtil.copyProperties;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Datastream extends Auditable {

  private Long id;
  private String feed;
  private List<Datapoint> datapointList;
  private Statistics statistics;

  private DatastreamJpa datastreamJpa;

  public Datastream(DatastreamJpa datastreamJpa) {
    if (datastreamJpa == null) return;
    this.datastreamJpa = datastreamJpa;
    this.setId(datastreamJpa.getId());
    this.setFeed(datastreamJpa.getFeed());
    this.setDatapointList(datastreamJpa.getDatapointList());
    this.setStatistics(datastreamJpa.getStatistics());
  }

  public void update(Datastream datastream) {
    copyProperties(
        datastream,
        this,
        new String[] {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"});
  }
}
