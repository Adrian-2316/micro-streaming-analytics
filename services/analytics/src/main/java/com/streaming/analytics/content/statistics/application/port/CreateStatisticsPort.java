package com.streaming.analytics.content.statistics.application.port;

import com.streaming.analytics.content.statistics.domain.Statistics;

public interface CreateStatisticsPort {
  Statistics create(Statistics statistics) throws Exception;
}
