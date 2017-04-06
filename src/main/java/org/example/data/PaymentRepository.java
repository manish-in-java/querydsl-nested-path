package org.example.data;

import org.example.domain.Payment;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface PaymentRepository extends ModelRepository<Payment>, QueryDslPredicateExecutor<Payment>
{
}
