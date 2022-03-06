package com.streaming.analytics.content.statistics.domain;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.streaming.analytics.shared.ObjectUtil.copyProperties;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {

  private Double arithmeticMean; // Media aritmética
  private Double median; // Media
  private Double mode; // Moda
  private Double standardDeviation; // Desviación típica
  private Double quartile; // Cuartiles
  private Double maxValue; // Valor máximo
  private Double minValue; // Valor mínimo
  private StatisticsJpa statisticsJpa;

  public Statistics(StatisticsJpa statisticsJpa) {
    if (statisticsJpa == null) return;
    this.statisticsJpa = statisticsJpa;
    this.setArithmeticMean(statisticsJpa.getArithmeticMean());
    this.setMedian(statisticsJpa.getMedian());
    this.setMode(statisticsJpa.getMode());
    this.setStandardDeviation(statisticsJpa.getStandardDeviation());
    this.setQuartile(statisticsJpa.getQuartile());
    this.setMinValue(statisticsJpa.getMinValue());
    this.setMaxValue(statisticsJpa.getMaxValue());
  }

  public void update(Statistics statistics) {
    copyProperties(
        statistics,
        this,
        new String[] {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"});
  }

  public Statistics calculate(List<Datapoint> datapointList) {
    List<Double> values =
        datapointList.stream().map(Datapoint::getValue).collect(Collectors.toList());
    calculateArithmeticMean(values);
    calculateMode(values);
    calculateMedian(values);
    calculateStandardDeviation(values);
    calculateQuartile(values);
    calculateMaxValue(values);
    calculateMinValue(values);
    return this;
  }

  private void calculateMinValue(List<Double> values) {
    this.setMinValue(Collections.min(values));
  }

  private void calculateMaxValue(List<Double> values) {
    this.setMaxValue(Collections.max(values));
  }

  private void calculateQuartile(List<Double> values) {
    double sum = values.stream().mapToDouble(value -> value).sum();
    this.setQuartile(sum / values.size() / values.size());
  }

  private void calculateArithmeticMean(List<Double> values) {
    double sum = values.stream().mapToDouble(v -> v).sum();
    this.setArithmeticMean(sum / values.size());
  }

  public void calculateMode(List<Double> values) {
    double mode = values.get(0);
    int maxCount = 0;
    for (int i = 0; i < values.size(); i++) {
      double value = values.get(i);
      int count = 1;
      for (Double aDouble : values) {
        if (aDouble == value) count++;
        if (count > maxCount) {
          mode = value;
          maxCount = count;
        }
      }
    }
    this.setMode(mode);
  }

  public void calculateMedian(List<Double> values) {
    Collections.sort(values);
    double median;
    int middle = values.size() / 2;
    if (values.size() % 2 == 0) median = (values.get(middle - 1) + values.get(middle)) / 2;
    else median = values.get(middle);
    this.setMedian(median);
  }

  public void calculateStandardDeviation(List<Double> values) {
    double sum, standardDeviation;
    sum = values.stream().mapToDouble(num -> num).sum();
    double mean = sum / values.size();
    standardDeviation =
        values.stream().mapToDouble(num -> num).map(num -> Math.pow(num - mean, 2)).sum();
    this.setStandardDeviation(Math.sqrt(standardDeviation / values.size()));
  }
}
