package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.Entity;

@Entity
@QueryEntity
public class Company extends Model
{
  private String name;

  Company()
  {
  }

  public Company(final String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
