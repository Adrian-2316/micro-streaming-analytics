package com.streaming.device.content.datapoint.domain;


import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Datapoint {

    private Long from;
    private Long at;
    private Double value;

}
