package com.benajo.smartreads.jpa;

import com.benajo.smartreads.model.SmartMeterDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartMeterDetailRepository extends CrudRepository<SmartMeterDetail, Long> {

  /**
   * Find a SmartMeterDetail by an account number.
   *
   * @param accountNumber Account number to find by.
   * @return A SmartMeterDetail if found, otherwise null.
   */
  SmartMeterDetail findByAccountNumber(Long accountNumber);
}
