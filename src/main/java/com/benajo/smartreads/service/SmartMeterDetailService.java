package com.benajo.smartreads.service;

import com.benajo.smartreads.model.SmartMeterDetailDTO;

public interface SmartMeterDetailService {

  SmartMeterDetailDTO getSmartMeterDetail(Long accountNumber);
}
