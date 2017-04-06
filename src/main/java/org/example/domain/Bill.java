package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@QueryEntity
public class Bill extends Model
{
  @ManyToOne(cascade = CascadeType.ALL)
  @QueryInit("*.*")
  private Contract contract;

  Bill()
  {
  }

  public Bill(final Contract contract)
  {
    this.contract = contract;
  }

  public Contract getContract()
  {
    return contract;
  }
}
