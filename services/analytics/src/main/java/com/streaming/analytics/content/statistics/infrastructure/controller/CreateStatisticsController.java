package com.streaming.analytics.content.statistics.infrastructure.controller;

import com.streaming.analytics.content.statistics.application.port.CreateStatisticsPort;
import com.streaming.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.content.statistics.infrastructure.controller.dto.input.StatisticsInputDTO;
import com.streaming.analytics.content.statistics.infrastructure.controller.dto.output.SimpleStatisticsOutputDTO;
import com.streaming.analytics.content.statistics.infrastructure.controller.dto.output.StatisticsOutputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = {"Statistics"})
@SwaggerDefinition(tags = {@Tag(name = "Statistics", description = "Statistics endpoints")})
@RequestMapping("api/v0/statistics")
public class CreateStatisticsController {

  private CreateStatisticsPort createStatisticsPort;

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public SimpleStatisticsOutputDTO create(
      @RequestParam(name = "style", defaultValue = "full") String style,
      @RequestBody StatisticsInputDTO statisticsInputDTO)
      throws Exception {
    Statistics statistics = statisticsInputDTO.statistics(new Statistics());
    Statistics createdStatistics = createStatisticsPort.create(statistics);
    return getDTO(createdStatistics, style);
  }

  private SimpleStatisticsOutputDTO getDTO(Statistics statistics, String style) {
    return style.equals("simple")
        ? new SimpleStatisticsOutputDTO(statistics)
        : new StatisticsOutputDTO(statistics);
  }
}
