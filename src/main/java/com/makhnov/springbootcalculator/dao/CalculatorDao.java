package com.makhnov.springbootcalculator.dao;

import com.makhnov.springbootcalculator.PostfixResult;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.jooq.impl.DSL.*;

@Repository
public class CalculatorDao {
    private final DSLContext dslContext;

    @Autowired
    public CalculatorDao(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    public String saveResult(String postfixExpression) throws Exception {
        PostfixResult postfixResult = new PostfixResult();
        Field resultField = field("result");
        Field postfixExpressionField = field("postfix_expression");

        dslContext.insertInto(table(name("postfix_results")),
                field("postfix_expression"), field("result"))
                .values(postfixExpression, postfixResult.getResult(postfixExpression))
                .execute();

        String recordGet = dslContext.select(resultField)
                .from(table(name("postfix_results")))
                .where(postfixExpressionField.eq(postfixExpression))
                .fetch()
                .getValue(0, resultField)
                .toString();
        return recordGet;
    }
}



