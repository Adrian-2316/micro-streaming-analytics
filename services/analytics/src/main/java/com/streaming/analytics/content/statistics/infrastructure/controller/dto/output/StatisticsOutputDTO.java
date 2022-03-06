package com.streaming.analytics.content.statistics.infrastructure.controller.dto.output;

import com.streaming.analytics.content.statistics.domain.Statistics;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatisticsOutputDTO extends SimpleStatisticsOutputDTO implements Serializable {

  public StatisticsOutputDTO(Statistics statistics) {
    super(statistics);
  }
}
