package com.exasol.adapter.sql;

import com.exasol.adapter.AdapterException;

/**
 * The type Sql predicate is null.
 */
public class SqlPredicateIsNull extends SqlPredicate {
    private final SqlNode expression;

    /**
     * Instantiates a new Sql predicate is null.
     *
     * @param expression the expression
     */
    public SqlPredicateIsNull(final SqlNode expression) {
        super(Predicate.IS_NULL);
        this.expression = expression;
        if (this.expression != null) {
            this.expression.setParent(this);
        }
    }

    /**
     * Gets expression.
     *
     * @return the expression
     */
    public SqlNode getExpression() {
        return this.expression;
    }

    @Override
    public SqlNodeType getType() {
        return SqlNodeType.PREDICATE_IS_NULL;
    }

    @Override
    public <R> R accept(final SqlNodeVisitor<R> visitor) throws AdapterException {
        return visitor.visit(this);
    }
}