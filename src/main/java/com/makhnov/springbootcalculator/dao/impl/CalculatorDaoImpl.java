package com.makhnov.springbootcalculator.dao.impl;

import com.makhnov.springbootcalculator.PostfixResult;
import com.makhnov.springbootcalculator.dao.CalculatorDao;
import com.makhnov.springbootcalculator.jooq.tables.PostfixResults;
import com.makhnov.springbootcalculator.model.CalculatorResult;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CalculatorDaoImpl implements CalculatorDao{
    private final DSLContext dslContext;
    private final PostfixResult postfixResult;

    @Override
    public CalculatorResult saveResult(String postfixExpression) {
        Record record = dslContext.insertInto(PostfixResults.POSTFIX_RESULTS_,
                PostfixResults.POSTFIX_RESULTS_.POSTFIX_EXPRESSION, PostfixResults.POSTFIX_RESULTS_.RESULT)
                .values(postfixExpression, postfixResult.getResult(postfixExpression))
                .returning(PostfixResults.POSTFIX_RESULTS_.ID)
                .fetchOne();

        return dslContext.select(PostfixResults.POSTFIX_RESULTS_.RESULT)
                .from(PostfixResults.POSTFIX_RESULTS_)
                .where(PostfixResults.POSTFIX_RESULTS_.ID.eq(record.getValue(PostfixResults.POSTFIX_RESULTS_.ID)))
                .fetchAny()
                .into(CalculatorResult.class);
    }
}



