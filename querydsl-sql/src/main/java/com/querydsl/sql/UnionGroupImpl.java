package com.querydsl.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;
import javax.naming.OperationNotSupportedException;

import com.mysema.commons.lang.CloseableIterator;
import com.querydsl.core.QueryMetadata;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Visitor;

public class UnionGroupImpl<T> implements UnionGroup<T> {

    private SQLOps operationType;

    private List<Union<T>> members;

    public UnionGroupImpl(SQLOps operationType, Union<T>... unions) {
        this.operationType = operationType;
        this.members = Arrays.asList(unions);
    }

    @Override
    public List<Union<T>> getMembers() {
        return this.members;
    }

    @Override
    public SQLOps getOperationType() {
        return operationType;
    }

    @Nullable
    @Override
    public <R, C> R accept(Visitor<R, C> v, @Nullable C context) {
        return null;
    }

    @Override
    public Class<? extends T> getType() {
        return this.members.get(0).getType();
    }
}
