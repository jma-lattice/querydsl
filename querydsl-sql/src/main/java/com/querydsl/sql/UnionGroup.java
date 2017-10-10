package com.querydsl.sql;

import java.util.List;

import com.querydsl.core.Fetchable;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.SubQueryExpression;

public interface UnionGroup<RT> extends Expression<RT> {
    SQLOps getOperationType();

    List<Union<RT>> getMembers();
}
