package com.benajo.smartreads.model;

import java.io.Serializable;
import java.util.Objects;

public class SmartMeterDetailDTO implements Serializable {

  private Long elecSmartRead;
  private Long gasSmartRead;

  public SmartMeterDetailDTO() {
  }

  public Long getElecSmartRead() {
    return elecSmartRead;
  }

  public void setElecSmartRead(Long elecSmartRead) {
    this.elecSmartRead = elecSmartRead;
  }

  public Long getGasSmartRead() {
    return gasSmartRead;
  }

  public void setGasSmartRead(Long gasSmartRead) {
    this.gasSmartRead = gasSmartRead;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmartMeterDetailDTO that = (SmartMeterDetailDTO) o;
    return Objects.equals(elecSmartRead, that.elecSmartRead) &&
        Objects.equals(gasSmartRead, that.gasSmartRead);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elecSmartRead, gasSmartRead);
  }

  @Override
  public String toString() {
    return "SmartMeterDetailDTO{" +
        "elecSmartRead=" + elecSmartRead +
        ", gasSmartRead=" + gasSmartRead +
        '}';
  }
}
