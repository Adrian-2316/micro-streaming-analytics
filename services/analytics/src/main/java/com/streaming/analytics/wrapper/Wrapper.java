package com.streaming.analytics.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Wrapper<T> {

  private String version;
  private String device;
  private T data;
}
