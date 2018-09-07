package com.benajo.smartreads.service.impl;

import com.benajo.smartreads.model.SmartMeterDetail;
import com.benajo.smartreads.model.SmartMeterDetailDTO;
import com.benajo.smartreads.jpa.SmartMeterDetailRepository;
import com.benajo.smartreads.service.SmartMeterDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SmartMeterDetailServiceImpl implements SmartMeterDetailService {

  private SmartMeterDetailRepository smartMeterDetailRepository;

  public SmartMeterDetailServiceImpl(SmartMeterDetailRepository smartMeterDetailRepository) {
    this.smartMeterDetailRepository = smartMeterDetailRepository;
  }

  /**
   * Retrieves a SmartMeterDetail from the repository and converts it to a SmartMeterDetailDTO.
   *
   * @param accountNumber Account number to find by.
   * @return A SmartMeterDetailDTO a record was found, otherwise null.
   */
  public SmartMeterDetailDTO getSmartMeterDetail(Long accountNumber) {

    SmartMeterDetailDTO smartMeterDetailDTO = new SmartMeterDetailDTO();
    SmartMeterDetail smartMeterDetail = smartMeterDetailRepository.findByAccountNumber(accountNumber);

    if (null != smartMeterDetail) {
      BeanUtils.copyProperties(smartMeterDetail, smartMeterDetailDTO);

      return smartMeterDetailDTO;
    }

    return null;
  }
}
