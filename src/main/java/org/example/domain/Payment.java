package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@QueryEntity
public class Payment extends Model
{
  @ManyToOne(cascade = CascadeType.ALL)
  @QueryInit("*.*")
  private Bill bill;

  Payment()
  {
  }

  public Payment(final Bill bill)
  {
    this.bill = bill;
  }

  public Bill getBill()
  {
    return bill;
  }
}
