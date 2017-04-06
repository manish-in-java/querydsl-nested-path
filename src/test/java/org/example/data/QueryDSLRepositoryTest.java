package org.example.data;

import org.example.domain.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
abstract class QueryDSLRepositoryTest
{
  static final String BUYER_NAME  = "Buyer";
  static final String SELLER_NAME = "Seller";

  @Autowired
  private PostingRepository repository;

  @Before
  public void setup()
  {
    repository.saveAndFlush(new Posting(new Payment(new Bill(new Contract(new Company(SELLER_NAME), new Company(BUYER_NAME), BigDecimal.TEN)))));
  }
}
