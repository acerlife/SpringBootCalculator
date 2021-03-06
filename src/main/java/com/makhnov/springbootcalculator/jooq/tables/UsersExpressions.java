/*
 * This file is generated by jOOQ.
*/
package com.makhnov.springbootcalculator.jooq.tables;


import com.makhnov.springbootcalculator.jooq.Indexes;
import com.makhnov.springbootcalculator.jooq.Keys;
import com.makhnov.springbootcalculator.jooq.PostfixResults;
import com.makhnov.springbootcalculator.jooq.tables.records.UsersExpressionsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class UsersExpressions extends TableImpl<UsersExpressionsRecord> {

    private static final long serialVersionUID = 904608916;

    /**
     * The reference instance of <code>postfix_results.users_expressions</code>
     */
    public static final UsersExpressions USERS_EXPRESSIONS = new UsersExpressions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersExpressionsRecord> getRecordType() {
        return UsersExpressionsRecord.class;
    }

    /**
     * The column <code>postfix_results.users_expressions.id</code>.
     */
    public final TableField<UsersExpressionsRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>postfix_results.users_expressions.postfix_expression</code>.
     */
    public final TableField<UsersExpressionsRecord, String> POSTFIX_EXPRESSION = createField("postfix_expression", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>postfix_results.users_expressions.status</code>.
     */
    public final TableField<UsersExpressionsRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(14).nullable(false), this, "");

    /**
     * Create a <code>postfix_results.users_expressions</code> table reference
     */
    public UsersExpressions() {
        this(DSL.name("users_expressions"), null);
    }

    /**
     * Create an aliased <code>postfix_results.users_expressions</code> table reference
     */
    public UsersExpressions(String alias) {
        this(DSL.name(alias), USERS_EXPRESSIONS);
    }

    /**
     * Create an aliased <code>postfix_results.users_expressions</code> table reference
     */
    public UsersExpressions(Name alias) {
        this(alias, USERS_EXPRESSIONS);
    }

    private UsersExpressions(Name alias, Table<UsersExpressionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsersExpressions(Name alias, Table<UsersExpressionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return PostfixResults.POSTFIX_RESULTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_EXPRESSIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UsersExpressionsRecord, Long> getIdentity() {
        return Keys.IDENTITY_USERS_EXPRESSIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersExpressionsRecord> getPrimaryKey() {
        return Keys.KEY_USERS_EXPRESSIONS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersExpressionsRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersExpressionsRecord>>asList(Keys.KEY_USERS_EXPRESSIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersExpressions as(String alias) {
        return new UsersExpressions(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersExpressions as(Name alias) {
        return new UsersExpressions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersExpressions rename(String name) {
        return new UsersExpressions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersExpressions rename(Name name) {
        return new UsersExpressions(name, null);
    }
}
