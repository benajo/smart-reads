package com.benajo.smartreads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmartMeterDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long accountNumber;
  private Long gasId;
  private Long elecId;
  private Long elecSmartRead;
  private Long gasSmartRead;

  public SmartMeterDetail() {
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Long getGasId() {
    return gasId;
  }

  public void setGasId(Long gasId) {
    this.gasId = gasId;
  }

  public Long getElecId() {
    return elecId;
  }

  public void setElecId(Long elecId) {
    this.elecId = elecId;
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
  public String toString() {
    return "SmartMeterDetail{" +
        "accountNumber=" + accountNumber +
        ", gasId='" + gasId + '\'' +
        ", elecId='" + elecId + '\'' +
        ", elecSmartRead='" + elecSmartRead + '\'' +
        ", gasSmartRead='" + gasSmartRead + '\'' +
        '}';
  }
}
