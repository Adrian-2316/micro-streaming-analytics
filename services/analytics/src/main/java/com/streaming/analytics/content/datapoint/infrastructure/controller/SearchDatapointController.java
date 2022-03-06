package com.streaming.analytics.content.datapoint.infrastructure.controller;

import com.streaming.analytics.content.datapoint.domain.Datapoint;
import com.streaming.analytics.content.datapoint.infrastructure.controller.dto.output.SimpleDatapointOutputDTO;
import com.streaming.analytics.content.datapoint.infrastructure.repository.port.SearchDatapointPort;
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
@Api(tags = {"Datapoint"})
@SwaggerDefinition(tags = {@Tag(name = "Datapoint", description = "Datapoint endpoints")})
@RequestMapping("api/v0/datapoint")
@AllArgsConstructor
public class SearchDatapointController {
  private final SearchDatapointPort searchDatapointPort;

  @ApiOperation(value = "Search datapoint", notes = "Collect data form datapoint database.")
  @GetMapping("search")
  public List<SimpleDatapointOutputDTO> search() {
    List<Datapoint> searchDatapoint = searchDatapointPort.search();
    return searchDatapoint.stream().map(SimpleDatapointOutputDTO::new).collect(Collectors.toList());
  }
}
