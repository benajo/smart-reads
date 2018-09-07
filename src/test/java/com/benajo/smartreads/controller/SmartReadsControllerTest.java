package com.benajo.smartreads.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.benajo.smartreads.model.SmartMeterDetailDTO;
import com.benajo.smartreads.service.SmartMeterDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class SmartReadsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SmartMeterDetailService smartMeterDetailService;

  @Before
  public void setUp() {
  }

  @Test
  public void getSmartMeterReads() throws Exception {
    Long accountNumber = 1L;

    SmartMeterDetailDTO smartMeterDetailDTO = new SmartMeterDetailDTO();
    smartMeterDetailDTO.setElecSmartRead(2L);
    smartMeterDetailDTO.setGasSmartRead(3L);

    ObjectMapper mapper = new ObjectMapper();
    String expectedJson = mapper.writeValueAsString(smartMeterDetailDTO);

    when(smartMeterDetailService.getSmartMeterDetail(accountNumber))
        .thenReturn(smartMeterDetailDTO);

    mockMvc.perform(get("/api/smart/reads/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(expectedJson)));
  }

  @Test
  public void getSmartMeterReads404() throws Exception {
    when(smartMeterDetailService.getSmartMeterDetail(1L)).thenReturn(null);

    mockMvc.perform(get("/api/smart/reads/1"))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }
}
