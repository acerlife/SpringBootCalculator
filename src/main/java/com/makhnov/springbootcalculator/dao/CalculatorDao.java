package com.makhnov.springbootcalculator.dao;

import com.makhnov.springbootcalculator.PostfixResult;
import org.jooq.*;
import org.jooq.sources.tables.PostfixResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorDao {
    private final DSLContext dslContext;

    @Autowired
    public CalculatorDao(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    public String saveResult(String postfixExpression) throws Exception {
        PostfixResult postfixResult = new PostfixResult();

        Record record = dslContext.insertInto(PostfixResults.POSTFIX_RESULTS_,
                PostfixResults.POSTFIX_RESULTS_.POSTFIX_EXPRESSION, PostfixResults.POSTFIX_RESULTS_.RESULT)
                .values(postfixExpression, postfixResult.getResult(postfixExpression))
                .returning(PostfixResults.POSTFIX_RESULTS_.ID)
                .fetchOne();

        return dslContext.select(PostfixResults.POSTFIX_RESULTS_.POSTFIX_EXPRESSION, PostfixResults.POSTFIX_RESULTS_.RESULT)
                .from(PostfixResults.POSTFIX_RESULTS_)
                .where(PostfixResults.POSTFIX_RESULTS_.ID.eq(record.getValue(PostfixResults.POSTFIX_RESULTS_.ID)))
                .fetchOne()
                .formatJSON();
    }
}



