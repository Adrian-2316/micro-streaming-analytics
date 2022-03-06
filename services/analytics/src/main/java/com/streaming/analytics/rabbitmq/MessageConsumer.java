package com.streaming.analytics.rabbitmq;

import com.streaming.analytics.content.datastream.domain.Datastream;
import com.streaming.analytics.content.datastream.infrastructure.repository.port.SaveDatastreamPort;
import com.streaming.analytics.content.statistics.domain.Statistics;
import com.streaming.analytics.wrapper.Wrapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageConsumer {

  private SaveDatastreamPort createDatastreamPort;

  @Async
  @RabbitListener(queues = MQConfig.QUEUE)
  public void listener(Wrapper<Datastream> data) {
    try {
      Datastream datastream = data.getData();
      setRelatedEntities(datastream);
      createDatastreamPort.save(datastream);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void setRelatedEntities(Datastream datastream) {
    if (datastream.getDatapointList() != null && !datastream.getDatapointList().isEmpty()) {
      Statistics statistics = new Statistics();
      datastream.setStatistics(statistics.calculate(datastream.getDatapointList()));
    }
  }
}
