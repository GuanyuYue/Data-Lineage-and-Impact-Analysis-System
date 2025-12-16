package com.example.lineage.parser.model;

import java.util.List;
import java.util.Map;

public class SparkSqlIr {

    private List<String> inputTables;
    private List<String> outputTables;
    private List<String> selectExprs;
    private List<String> wherePredicates;
    private List<String> joinConditions;
    private List<String> groupByFields;
    private boolean hasStarSelect;
    private List<String> udfCalls;
    private Map<String, String> tableAliasMapping;

    public List<String> getInputTables() {
        return inputTables;
    }

    public void setInputTables(List<String> inputTables) {
        this.inputTables = inputTables;
    }

    public List<String> getOutputTables() {
        return outputTables;
    }

    public void setOutputTables(List<String> outputTables) {
        this.outputTables = outputTables;
    }

    public List<String> getSelectExprs() {
        return selectExprs;
    }

    public void setSelectExprs(List<String> selectExprs) {
        this.selectExprs = selectExprs;
    }

    public List<String> getWherePredicates() {
        return wherePredicates;
    }

    public void setWherePredicates(List<String> wherePredicates) {
        this.wherePredicates = wherePredicates;
    }

    public List<String> getJoinConditions() {
        return joinConditions;
    }

    public void setJoinConditions(List<String> joinConditions) {
        this.joinConditions = joinConditions;
    }

    public List<String> getGroupByFields() {
        return groupByFields;
    }

    public void setGroupByFields(List<String> groupByFields) {
        this.groupByFields = groupByFields;
    }

    public boolean isHasStarSelect() {
        return hasStarSelect;
    }

    public void setHasStarSelect(boolean hasStarSelect) {
        this.hasStarSelect = hasStarSelect;
    }

    public List<String> getUdfCalls() {
        return udfCalls;
    }

    public void setUdfCalls(List<String> udfCalls) {
        this.udfCalls = udfCalls;
    }

    public Map<String, String> getTableAliasMapping() {
        return tableAliasMapping;
    }

    public void setTableAliasMapping(Map<String, String> tableAliasMapping) {
        this.tableAliasMapping = tableAliasMapping;
    }
}
