package com.streaming.analytics.analytics.content.statistics.infrastructure.repository;


import com.streaming.analytics.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.analytics.content.statistics.domain.StatisticsJpa;
import com.streaming.analytics.analytics.content.statistics.infrastructure.repository.jpa.StatisticsRepositoryJpa;
import com.streaming.analytics.analytics.content.statistics.infrastructure.repository.port.SaveStatisticsPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveStatisticsRepository implements SaveStatisticsPort {

    private StatisticsRepositoryJpa statisticsRepositoryJpa;

    @Override
    public Statistics save(Statistics statistics) {
        StatisticsJpa statisticsJpa = new StatisticsJpa(statistics);
        statisticsRepositoryJpa.save(statisticsJpa);
        return new Statistics(statisticsJpa);
    }
}

