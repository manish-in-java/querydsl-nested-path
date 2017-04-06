package org.example.data;

import org.example.domain.Posting;
import org.example.domain.QPosting;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PostingRepositoryTest extends QueryDSLRepositoryTest
{
  @Autowired
  private PostingRepository repository;

  @Test
  public void testFindByPredicate()
  {
    final QPosting root = QPosting.posting;

    final Iterable<Posting> postings = repository.findAll(root.payment.bill.contract.buyer.name.equalsIgnoreCase(BUYER_NAME)
                                                                                               .and(root.payment.bill.contract.seller.name.equalsIgnoreCase(SELLER_NAME)));

    assertNotNull(postings);
    assertNotNull(postings.iterator());
    assertTrue(postings.iterator().hasNext());

    postings.forEach(posting ->
                     {
                       assertNotNull(posting);
                       assertNotNull(posting.getPayment());
                       assertNotNull(posting.getPayment().getBill());
                       assertNotNull(posting.getPayment().getBill().getContract());
                       assertNotNull(posting.getPayment().getBill().getContract().getAmount());
                       assertNotNull(posting.getPayment().getBill().getContract().getBuyer());
                       assertNotNull(posting.getPayment().getBill().getContract().getBuyer().getName());
                       assertTrue(posting.getPayment().getBill().getContract().getBuyer().getName().equalsIgnoreCase(BUYER_NAME));
                       assertNotNull(posting.getPayment().getBill().getContract().getSeller());
                       assertNotNull(posting.getPayment().getBill().getContract().getSeller().getName());
                       assertTrue(posting.getPayment().getBill().getContract().getSeller().getName().equalsIgnoreCase(SELLER_NAME));
                     });
  }
}
