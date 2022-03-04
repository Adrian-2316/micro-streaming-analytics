package com.streaming.analytics.analytics.content.statistics.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "statistics")
public class StatisticsJpa {

    private Double arithmeticMean; // Media aritmética
    private Double median; // Media
    private Double mode; // Moda
    private Double standardDeviation; // Desviación típica
    private Double quartile; // Cuartiles
    private Double maxValue; // Valor máximo
    private Double minValue; // Valor mínimo

    public StatisticsJpa(Statistics statistics) {
        if (statistics == null) return;
        this.setArithmeticMean(statistics.getArithmeticMean());
        this.setMedian(statistics.getMedian());
        this.setMode(statistics.getMode());
        this.setStandardDeviation(statistics.getStandardDeviation());
        this.setQuartile(statistics.getQuartile());
        this.setMinValue(statistics.getMinValue());
        this.setMaxValue(statistics.getMaxValue());
    }
}
