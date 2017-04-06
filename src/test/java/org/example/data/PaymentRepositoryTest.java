package org.example.data;

import org.example.domain.Payment;
import org.example.domain.QPayment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentRepositoryTest extends QueryDSLRepositoryTest
{
  @Autowired
  private PaymentRepository repository;

  @Test
  public void testFindByPredicate()
  {
    final QPayment root = QPayment.payment;

    final Iterable<Payment> payments = repository.findAll(root.bill.contract.buyer.name.equalsIgnoreCase(BUYER_NAME)
                                                                                       .and(root.bill.contract.seller.name.equalsIgnoreCase(SELLER_NAME)));

    assertNotNull(payments);
    assertNotNull(payments.iterator());
    assertTrue(payments.iterator().hasNext());

    payments.forEach(payment ->
                     {
                       assertNotNull(payment.getBill());
                       assertNotNull(payment.getBill().getContract());
                       assertNotNull(payment.getBill().getContract().getAmount());
                       assertNotNull(payment.getBill().getContract().getBuyer());
                       assertNotNull(payment.getBill().getContract().getBuyer().getName());
                       assertTrue(payment.getBill().getContract().getBuyer().getName().equalsIgnoreCase(BUYER_NAME));
                       assertNotNull(payment.getBill().getContract().getSeller());
                       assertNotNull(payment.getBill().getContract().getSeller().getName());
                       assertTrue(payment.getBill().getContract().getSeller().getName().equalsIgnoreCase(SELLER_NAME));
                     });
  }
}
