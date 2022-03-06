package com.streaming.analytics.content.statistics.infrastructure.controller.dto.output;

import com.streaming.analytics.content.statistics.domain.Statistics;
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
    if (statistics == null) return;
    if (statistics.getArithmeticMean() != null)
      this.setArithmeticMean(statistics.getArithmeticMean());
    if (statistics.getMedian() != null) this.setMedian(statistics.getMedian());
    if (statistics.getMode() != null) this.setMode(statistics.getMode());
    if (statistics.getStandardDeviation() != null)
      this.setStandardDeviation(statistics.getStandardDeviation());
    if (statistics.getQuartile() != null) this.setQuartile(statistics.getQuartile());
    if (statistics.getMinValue() != null) this.setMinValue(statistics.getMinValue());
    if (statistics.getMaxValue() != null) this.setMaxValue(statistics.getMaxValue());
  }
}
