package com.streaming.analytics.analytics.content.statistics.application.port;


import com.streaming.analytics.analytics.content.statistics.domain.Statistics;

public interface CreateStatisticsPort {
    Statistics create(Statistics statistics) throws Exception;
}
