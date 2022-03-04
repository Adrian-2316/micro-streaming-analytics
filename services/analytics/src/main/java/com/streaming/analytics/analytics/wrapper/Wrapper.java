package com.streaming.analytics.analytics.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Wrapper<T> {

    private String version;
    private String device;
    private T data;
}
