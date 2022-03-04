package com.streaming.analytics.analytics.content.statistics.infrastructure.controller.dto.input;

import com.streaming.analytics.analytics.content.statistics.domain.Statistics;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class StatisticsInputDTO {

    private Double arithmeticMean;
    private Double median;
    private Double mode;
    private Double standardDeviation;
    private Double quartile;
    private Double maxValue;
    private Double minValue;

    public Statistics statistics(Statistics statistics) {
        statistics.setArithmeticMean(this.getArithmeticMean());
        statistics.setMedian(this.getMedian());
        statistics.setMode(this.getMode());
        statistics.setStandardDeviation(this.getStandardDeviation());
        statistics.setQuartile(this.getQuartile());
        statistics.setMinValue(this.getMinValue());
        statistics.setMaxValue(this.getMaxValue());
        return statistics;
    }
}

