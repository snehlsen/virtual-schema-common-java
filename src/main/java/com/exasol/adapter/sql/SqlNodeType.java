package com.exasol.adapter.sql;

/**
 * All types of nodes that can be part of a pushdown request.
 * Each type represents a different class inheriting from SqlNode.
 */
public enum SqlNodeType {
    SELECT,
    TABLE,
    JOIN,
    SELECT_LIST,
    GROUP_BY,
    COLUMN,
    LITERAL_NULL,
    LITERAL_BOOL,
    LITERAL_DATE,
    LITERAL_TIMESTAMP,
    LITERAL_TIMESTAMPUTC,
    LITERAL_DOUBLE,
    LITERAL_EXACTNUMERIC,
    LITERAL_STRING,
    LITERAL_INTERVAL,
    PREDICATE_AND,
    PREDICATE_OR,
    PREDICATE_NOT,
    PREDICATE_EQUAL,
    PREDICATE_NOTEQUAL,
    PREDICATE_LESS,
    PREDICATE_LESSEQUAL,
    PREDICATE_LIKE,
    PREDICATE_LIKE_REGEXP,
    PREDICATE_BETWEEN,
    PREDICATE_IN_CONSTLIST,
    PREDICATE_IS_NULL,
    PREDICATE_IS_NOT_NULL,
    FUNCTION_SCALAR,
    FUNCTION_SCALAR_CASE,
    FUNCTION_SCALAR_CAST,
    FUNCTION_SCALAR_EXTRACT,
    FUNCTION_AGGREGATE,
    FUNCTION_AGGREGATE_GROUP_CONCAT,
    ORDER_BY,
    LIMIT
}
