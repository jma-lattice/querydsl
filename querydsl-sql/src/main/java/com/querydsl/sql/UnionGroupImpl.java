/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.sql;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

import com.querydsl.core.types.Visitor;

/**
 * Default implementation of the UnionGroup interface
 *
 * @param <T> projection type
 *
 * @author jma
 */
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
