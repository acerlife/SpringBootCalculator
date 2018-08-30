package com.makhnov.springbootcalculator.dao.impl;

import com.makhnov.springbootcalculator.dao.ExpressionDao;
import com.makhnov.springbootcalculator.jooq.tables.UsersExpressions;
import com.makhnov.springbootcalculator.model.JobExpression;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ExpressionDaoImpl implements ExpressionDao{
    private final DSLContext dslContext;

    @Override
    public long saveResult(String expression) {
        Record record = dslContext.insertInto(UsersExpressions.USERS_EXPRESSIONS,
                 UsersExpressions.USERS_EXPRESSIONS.POSTFIX_EXPRESSION, UsersExpressions.USERS_EXPRESSIONS.STATUS)
                .values(expression, "not calculated")
                .returning(UsersExpressions.USERS_EXPRESSIONS.ID)
                .fetchOne();

        return new JobExpression(record.getValue(record.field(UsersExpressions.USERS_EXPRESSIONS.ID))).getId();
    }
}
