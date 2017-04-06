package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@QueryEntity
public class Posting extends Model
{
  @ManyToOne(cascade = CascadeType.ALL)
  @QueryInit("*.*")
  private Payment payment;

  Posting()
  {
  }

  public Posting(final Payment payment)
  {
    this.payment = payment;
  }

  public Payment getPayment()
  {
    return payment;
  }
}
