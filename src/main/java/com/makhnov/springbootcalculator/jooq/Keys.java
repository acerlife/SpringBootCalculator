/*
 * This file is generated by jOOQ.
*/
package com.makhnov.springbootcalculator.jooq;


import com.makhnov.springbootcalculator.jooq.tables.PostfixResults;
import com.makhnov.springbootcalculator.jooq.tables.records.PostfixResultsRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>postfix_results</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<PostfixResultsRecord, Long> IDENTITY_POSTFIX_RESULTS_ = Identities0.IDENTITY_POSTFIX_RESULTS_;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<PostfixResultsRecord> KEY_POSTFIX_RESULTS_PRIMARY = UniqueKeys0.KEY_POSTFIX_RESULTS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<PostfixResultsRecord, Long> IDENTITY_POSTFIX_RESULTS_ = Internal.createIdentity(PostfixResults.POSTFIX_RESULTS_, PostfixResults.POSTFIX_RESULTS_.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<PostfixResultsRecord> KEY_POSTFIX_RESULTS_PRIMARY = Internal.createUniqueKey(PostfixResults.POSTFIX_RESULTS_, "KEY_postfix_results_PRIMARY", PostfixResults.POSTFIX_RESULTS_.ID);
    }
}
