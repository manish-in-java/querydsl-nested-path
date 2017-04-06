package org.example.data;

import org.example.domain.Bill;
import org.example.domain.QBill;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BillRepositoryTest extends QueryDSLRepositoryTest
{
  @Autowired
  private BillRepository repository;

  @Test
  public void testFindByPredicate()
  {
    final QBill root = QBill.bill;

    final Iterable<Bill> bills = repository.findAll(root.contract.buyer.name.equalsIgnoreCase(BUYER_NAME)
                                                                            .and(root.contract.seller.name.equalsIgnoreCase(SELLER_NAME)));

    assertNotNull(bills);
    assertNotNull(bills.iterator());
    assertTrue(bills.iterator().hasNext());

    bills.forEach(bill ->
                  {
                    assertNotNull(bill.getContract());
                    assertNotNull(bill.getContract().getAmount());
                    assertNotNull(bill.getContract().getBuyer());
                    assertNotNull(bill.getContract().getBuyer().getName());
                    assertTrue(bill.getContract().getBuyer().getName().equalsIgnoreCase(BUYER_NAME));
                    assertNotNull(bill.getContract().getSeller());
                    assertNotNull(bill.getContract().getSeller().getName());
                    assertTrue(bill.getContract().getSeller().getName().equalsIgnoreCase(SELLER_NAME));
                  });
  }
}
