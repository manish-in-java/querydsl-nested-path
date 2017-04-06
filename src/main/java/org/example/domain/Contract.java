package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@QueryEntity
public class Contract extends Model
{
  private BigDecimal amount;

  @ManyToOne(cascade = CascadeType.ALL)
  @QueryInit("*.*")
  private Company buyer;

  @ManyToOne(cascade = CascadeType.ALL)
  @QueryInit("*.*")
  private Company seller;

  Contract()
  {
  }

  public Contract(final Company seller, final Company buyer, final BigDecimal amount)
  {
    this.amount = amount;
    this.buyer = buyer;
    this.seller = seller;
  }

  public BigDecimal getAmount()
  {
    return amount;
  }

  public Company getBuyer()
  {
    return buyer;
  }

  public Company getSeller()
  {
    return seller;
  }
}
