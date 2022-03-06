package com.streaming.analytics.content.datastream.infrastructure.controller.dto.output;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.statistics.domain.Statistics;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DatastreamOutputDTO extends SimpleDatastreamOutputDTO implements Serializable {

  protected List<Datapoint> datapointList;
  protected Statistics statistics;

  public DatastreamOutputDTO(Datastream datastream) {
    super(datastream);
    if (datastream.getDatapointList() != null) this.setDatapointList(datastream.getDatapointList());
    if (datastream.getStatistics() != null) this.setStatistics(datastream.getStatistics());
  }
}
