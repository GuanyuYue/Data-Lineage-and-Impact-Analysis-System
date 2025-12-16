package com.example.lineage.parser;

import com.example.lineage.parser.model.SparkSqlIr;

public interface SparkSqlParser {

    SparkSqlIr parse(String script);
}
