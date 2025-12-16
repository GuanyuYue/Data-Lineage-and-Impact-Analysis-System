package com.example.lineage.parser.impl;

import com.example.lineage.parser.SparkSqlParser;
import com.example.lineage.parser.model.SparkSqlIr;

public class DefaultSparkSqlParser implements SparkSqlParser {

    @Override
    public SparkSqlIr parse(String script) {
        // TODO integrate Spark SQL parser to build structured IR
        // Should extract inputTables, outputTables, selectExprs, wherePredicates, joinConditions, groupByFields, hasStarSelect, udfCalls
        return new SparkSqlIr();
    }
}
