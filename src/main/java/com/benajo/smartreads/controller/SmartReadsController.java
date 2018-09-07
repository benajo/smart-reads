package com.benajo.smartreads.controller;

import com.benajo.smartreads.model.SmartMeterDetailDTO;
import com.benajo.smartreads.service.SmartMeterDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class SmartReadsController {

  private SmartMeterDetailService service;

  public SmartReadsController(SmartMeterDetailService service) {
    this.service = service;
  }

  /**
   * This endpoint retrieves smart meter read information with a given account number.
   *
   * @param accountNumber Path variable from URL for an account number.
   * @return A SmartMeterDetail and HTTP OK if found, otherwise just HTTP 404.
   */
  @RequestMapping(value = "smart/reads/{accountNumber}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<SmartMeterDetailDTO> getSmartMeterReads(
      @PathVariable("accountNumber") Long accountNumber) {
    SmartMeterDetailDTO smartMeterDetailDTO = service.getSmartMeterDetail(accountNumber);

    if (null != smartMeterDetailDTO) {
      return new ResponseEntity<>(smartMeterDetailDTO, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
