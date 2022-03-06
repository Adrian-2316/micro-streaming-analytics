package com.streaming.analytics.content.datastream.infrastructure.controller.dto.input;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.content.datapoint.infrastructure.controller.dto.input.DatapointInputDTO;
import com.streaming.analytics.content.datastream.domain.Datastream;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class DatastreamInputDTO {

  private Long id;
  private String feed;
  private List<DatapointInputDTO> datapointList;

  public Datastream datastream(Datastream datastream) {
    datastream.setId(this.getId());
    datastream.setFeed(this.getFeed());
    datastream.setDatapointList(
        this.datapointList.stream()
            .map(datapointInputDTO -> datapointInputDTO.datapoint(new Datapoint()))
            .collect(Collectors.toList()));
    return datastream;
  }
}
