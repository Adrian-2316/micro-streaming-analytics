package com.streaming.analytics.analytics.content.statistics.infrastructure.controller.dto.output;


import com.streaming.analytics.analytics.content.statistics.domain.Statistics;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleStatisticsOutputDTO implements Serializable {

    protected Double arithmeticMean;
    protected Double median;
    protected Double mode;
    protected Double standardDeviation;
    protected Double quartile;
    protected Double maxValue;
    protected Double minValue;

    public SimpleStatisticsOutputDTO(Statistics statistics) {
        this.setArithmeticMean(statistics.getArithmeticMean());
        this.setMedian(statistics.getMedian());
        this.setMode(statistics.getMode());
        this.setStandardDeviation(statistics.getStandardDeviation());
        this.setQuartile(statistics.getQuartile());
        this.setMinValue(statistics.getMinValue());
        this.setMaxValue(statistics.getMaxValue());
    }
}

