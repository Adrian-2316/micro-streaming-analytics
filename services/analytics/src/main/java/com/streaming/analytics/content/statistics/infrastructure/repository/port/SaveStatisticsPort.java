package com.streaming.analytics.content.statistics.infrastructure.repository.port;

import com.streaming.analytics.content.statistics.domain.Statistics;

public interface SaveStatisticsPort {
  Statistics save(Statistics statistics) throws Exception;
}
