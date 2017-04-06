package org.example.data;

import org.example.domain.Contract;
import org.example.domain.QContract;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ContractRepositoryTest extends QueryDSLRepositoryTest
{
  @Autowired
  private ContractRepository repository;

  @Test
  public void testFindByPredicate()
  {
    final QContract root = QContract.contract;

    final Iterable<Contract> contracts = repository.findAll(root.buyer.name.equalsIgnoreCase(BUYER_NAME)
                                                                           .and(root.seller.name.equalsIgnoreCase(SELLER_NAME)));

    assertNotNull(contracts);
    assertNotNull(contracts.iterator());
    assertTrue(contracts.iterator().hasNext());

    contracts.forEach(contract ->
                      {
                        assertNotNull(contract.getAmount());
                        assertNotNull(contract.getBuyer());
                        assertNotNull(contract.getBuyer().getName());
                        assertTrue(contract.getBuyer().getName().equalsIgnoreCase(BUYER_NAME));
                        assertNotNull(contract.getSeller());
                        assertNotNull(contract.getSeller().getName());
                        assertTrue(contract.getSeller().getName().equalsIgnoreCase(SELLER_NAME));
                      });
  }
}
