package com.streaming.device.device.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {

  private final RabbitTemplate template;

  public MessagePublisher(RabbitTemplate template) {
    this.template = template;
  }

  @PostMapping("/publish")
  public String publishMessage(@RequestBody CustomMessage message) {
    template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    return "Message published.";
  }
}
