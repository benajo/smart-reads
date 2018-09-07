package com.benajo.smartreads.service.impl;

import static org.mockito.Mockito.when;

import com.benajo.smartreads.jpa.SmartMeterDetailRepository;
import com.benajo.smartreads.model.SmartMeterDetail;
import com.benajo.smartreads.model.SmartMeterDetailDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SmartMeterDetailServiceImplTest {

  @InjectMocks
  private SmartMeterDetailServiceImpl smartMeterDetailService;

  @Mock
  private SmartMeterDetailRepository smartMeterDetailRepository;

  @Test
  public void getSmartMeterDetail() {

    Long accountNumber = 1L;
    Long elecSmartRead = 2L;
    Long gasSmartRead = 3L;

    SmartMeterDetail smartMeterDetail = new SmartMeterDetail();
    smartMeterDetail.setAccountNumber(accountNumber);
    smartMeterDetail.setElecSmartRead(elecSmartRead);
    smartMeterDetail.setGasSmartRead(gasSmartRead);

    SmartMeterDetailDTO expectedSmartMeterDetailDTO = new SmartMeterDetailDTO();
    expectedSmartMeterDetailDTO.setElecSmartRead(elecSmartRead);
    expectedSmartMeterDetailDTO.setGasSmartRead(gasSmartRead);

    when(smartMeterDetailRepository.findByAccountNumber(accountNumber)).thenReturn(smartMeterDetail);

    Assert.assertEquals(expectedSmartMeterDetailDTO, smartMeterDetailService.getSmartMeterDetail(accountNumber));
  }

  @Test
  public void getSmartMeterDetailNullReturn() {

    Long accountNumber = 1L;

    when(smartMeterDetailRepository.findByAccountNumber(accountNumber)).thenReturn(null);

    Assert.assertNull(smartMeterDetailService.getSmartMeterDetail(accountNumber));
  }
}