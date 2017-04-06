package org.example.data;

import org.example.domain.Contract;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ContractRepository extends ModelRepository<Contract>, QueryDslPredicateExecutor<Contract>
{
}
