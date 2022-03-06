package com.streaming.analytics.content.statistics.application;

import com.streaming.analytics.content.statistics.application.port.CreateStatisticsPort;
import com.streaming.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.content.statistics.infrastructure.repository.port.SaveStatisticsPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStatisticsUseCase implements CreateStatisticsPort {

  private SaveStatisticsPort saveStatisticsPort;

  @Override
  public Statistics create(Statistics statistics) throws Exception {
    return saveStatisticsPort.save(statistics);
  }
}
