# Impact Inference Pseudocode

```
function analyze(changeEvent, maxDepth):
    edges = traversalService.bfsDownstreamEdges(changeEvent.tableId, maxDepth)
    results = []
    for edge in edges:
        ir = sparkSqlParser.parse(edge.rawScript)
        detection = ruleBasedDetector.detect(changeEvent, ir)
        if detection.decision == UNKNOWN and ir.hasStarSelect:
            detection = llmFallbackDetector.infer(changeEvent, ir)
        result = assembleImpactResult(edge, detection)
        results.add(result)
        if detection.decision == NOT_USED and detection.confidence >= 0.7:
            skip enqueueing downstream edges of edge.downstreamTable
    return results
```
