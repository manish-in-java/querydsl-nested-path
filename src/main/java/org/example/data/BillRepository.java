package org.example.data;

import org.example.domain.Bill;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BillRepository extends ModelRepository<Bill>, QueryDslPredicateExecutor<Bill>
{
}
