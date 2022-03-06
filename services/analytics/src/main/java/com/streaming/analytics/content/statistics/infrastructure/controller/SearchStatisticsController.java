package com.streaming.analytics.content.statistics.infrastructure.controller;

import com.streaming.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.content.statistics.infrastructure.controller.dto.output.SimpleStatisticsOutputDTO;
import com.streaming.analytics.content.statistics.infrastructure.repository.port.SearchStatisticsPort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = {"Statistics"})
@SwaggerDefinition(tags = {@Tag(name = "Statistics", description = "Statistics endpoints")})
@RequestMapping("api/v0/statistics")
@AllArgsConstructor
public class SearchStatisticsController {
  private final SearchStatisticsPort searchStatisticsPort;

  @ApiOperation(value = "Search statistics", notes = "Collect data form statistics database.")
  @GetMapping("search")
  public List<SimpleStatisticsOutputDTO> search() {
    List<Statistics> searchStatistics = searchStatisticsPort.search();
    return searchStatistics.stream()
        .map(SimpleStatisticsOutputDTO::new)
        .collect(Collectors.toList());
  }
}
