package org.example.data;

import org.example.domain.Company;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CompanyRepository extends ModelRepository<Company>, QueryDslPredicateExecutor<Company>
{
}
