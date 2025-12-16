package com.example.lineage.gateway.client;

import com.example.lineage.parser.model.SparkSqlIr;
import java.util.Map;

public interface LlmGatewayClient {

    Map<String, Object> inferUsage(String fieldName, SparkSqlIr ir);

    // TODO define request/response model and implement HTTP client
}
