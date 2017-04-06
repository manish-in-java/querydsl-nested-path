package org.example.data;

import org.example.domain.Posting;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface PostingRepository extends ModelRepository<Posting>, QueryDslPredicateExecutor<Posting>
{
}
