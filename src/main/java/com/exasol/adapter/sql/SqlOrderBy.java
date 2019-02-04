package com.exasol.adapter.sql;

import com.exasol.adapter.AdapterException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SqlOrderBy extends SqlNode {
    private List<SqlNode> expressions;
    private List<Boolean> isAsc;

    // True, if the desired position of nulls is at the end, false if at beginning.
    // This does not necessarily mean the user explicitly specified NULLS LAST or NULLS FIRST.
    private List<Boolean> nullsLast;

    public SqlOrderBy(List<SqlNode> expressions, List<Boolean> isAsc, List<Boolean> nullsFirst) {
        this.expressions = expressions;
        this.isAsc = isAsc;
        this.nullsLast = nullsFirst;
        if (this.expressions != null) {
            for (SqlNode node : this.expressions) {
                node.setParent(this);
            }
        }
    }

    public List<SqlNode> getExpressions() {
        if (expressions == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(expressions);
        }
    }

    public List<Boolean> isAscending() {
        if (isAsc == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(isAsc);
        }
    }

    public List<Boolean> nullsLast() {
        if (nullsLast == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(nullsLast);
        }
    }

    @Override
    public String toSimpleSql() {
        // ORDER BY <expr> [ASC/DESC] [NULLS FIRST/LAST]
        // ASC and NULLS LAST are default
        List<String> sqlOrderElement = new ArrayList<>();
        for (int i = 0; i < expressions.size(); ++i) {
            String elementSql = expressions.get(i).toSimpleSql();
            if (!isAsc.get(i)) {
                elementSql += " DESC";
            }
            if (!nullsLast.get(i)) {
                elementSql += " NULLS FIRST";
            }
            sqlOrderElement.add(elementSql);
        }
        return "ORDER BY " + String.join(", ", sqlOrderElement);
    }

    @Override
    public SqlNodeType getType() {
        return SqlNodeType.ORDER_BY;
    }

    @Override
    public <R> R accept(SqlNodeVisitor<R> visitor) throws AdapterException {
        return visitor.visit(this);
    }
}
