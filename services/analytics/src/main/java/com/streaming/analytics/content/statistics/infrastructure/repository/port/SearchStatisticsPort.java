package com.streaming.analytics.content.statistics.infrastructure.repository.port;

import com.streaming.analytics.content.statistics.domain.Statistics;

import java.util.List;

public interface SearchStatisticsPort {
  List<Statistics> search();
}
