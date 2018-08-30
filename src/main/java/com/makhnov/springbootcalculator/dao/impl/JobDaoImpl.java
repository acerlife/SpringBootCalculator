package com.makhnov.springbootcalculator.dao.impl;

import com.makhnov.springbootcalculator.PostfixResult;
import com.makhnov.springbootcalculator.dao.JobDao;
import com.makhnov.springbootcalculator.jooq.tables.PostfixResults;
import com.makhnov.springbootcalculator.jooq.tables.UsersExpressions;
import com.makhnov.springbootcalculator.model.JobExpression;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JobDaoImpl implements JobDao{
    private final DSLContext dslContext;
    private final PostfixResult postfixResult;

    @Override
    public void saveCalculatedExpressions() {
        List<JobExpression> jobExpressions = dslContext.select(UsersExpressions.USERS_EXPRESSIONS.ID, UsersExpressions.USERS_EXPRESSIONS.POSTFIX_EXPRESSION)
                .from(UsersExpressions.USERS_EXPRESSIONS)
                .where(UsersExpressions.USERS_EXPRESSIONS.STATUS.eq("not calculated"))
                .fetch()
                .into(JobExpression.class);

        if (jobExpressions.size()>0) {
            for (JobExpression jobExpression : jobExpressions) {
                dslContext.insertInto(PostfixResults.POSTFIX_RESULTS_,
                        PostfixResults.POSTFIX_RESULTS_.POSTFIX_EXPRESSION, PostfixResults.POSTFIX_RESULTS_.RESULT)
                        .values(jobExpression.getExpression(), postfixResult.getResult(jobExpression.getExpression()))
                        .execute();

                dslContext.update(UsersExpressions.USERS_EXPRESSIONS)
                        .set(UsersExpressions.USERS_EXPRESSIONS.STATUS, "calculated")
                        .where(UsersExpressions.USERS_EXPRESSIONS.ID.eq(jobExpression.getId()))
                        .execute();
            }
        }
    }
}
