/*
 * This file is generated by jOOQ.
*/
package com.makhnov.springbootcalculator.jooq.tables.records;


import com.makhnov.springbootcalculator.jooq.tables.PostfixResults;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PostfixResultsRecord extends UpdatableRecordImpl<PostfixResultsRecord> implements Record3<Long, String, String> {

    private static final long serialVersionUID = -982451432;

    /**
     * Setter for <code>postfix_results.postfix_results.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>postfix_results.postfix_results.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>postfix_results.postfix_results.postfix_expression</code>.
     */
    public void setPostfixExpression(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>postfix_results.postfix_results.postfix_expression</code>.
     */
    public String getPostfixExpression() {
        return (String) get(1);
    }

    /**
     * Setter for <code>postfix_results.postfix_results.result</code>.
     */
    public void setResult(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>postfix_results.postfix_results.result</code>.
     */
    public String getResult() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return PostfixResults.POSTFIX_RESULTS_.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return PostfixResults.POSTFIX_RESULTS_.POSTFIX_EXPRESSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return PostfixResults.POSTFIX_RESULTS_.RESULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getPostfixExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPostfixExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostfixResultsRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostfixResultsRecord value2(String value) {
        setPostfixExpression(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostfixResultsRecord value3(String value) {
        setResult(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostfixResultsRecord values(Long value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PostfixResultsRecord
     */
    public PostfixResultsRecord() {
        super(PostfixResults.POSTFIX_RESULTS_);
    }

    /**
     * Create a detached, initialised PostfixResultsRecord
     */
    public PostfixResultsRecord(Long id, String postfixExpression, String result) {
        super(PostfixResults.POSTFIX_RESULTS_);

        set(0, id);
        set(1, postfixExpression);
        set(2, result);
    }
}