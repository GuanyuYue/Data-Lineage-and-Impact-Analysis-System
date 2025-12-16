package com.example.lineage.graph.service;

import com.example.lineage.domain.model.JobLineage;
import com.example.lineage.domain.model.TableAsset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LineageTraversalService {

    // TODO inject mapper beans

    public List<JobLineage> bfsDownstreamEdges(String startTableId, int maxDepth) {
        // TODO use JobLineageMapper and TableAssetMapper
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        List<JobLineage> edges = new ArrayList<>();
        queue.add(startTableId);
        int depth = 0;
        while (!queue.isEmpty() && depth <= maxDepth) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tableId = queue.poll();
                if (!visited.add(tableId)) {
                    continue;
                }
                // TODO load outgoing edges via mapper
                // for each edge: edges.add(edge); queue.add(edge.getDownstreamTableId());
            }
            depth++;
        }
        return edges;
    }

    public List<JobLineage> dfsDownstreamEdges(String startTableId, int maxDepth) {
        List<JobLineage> edges = new ArrayList<>();
        dfs(startTableId, maxDepth, 0, new HashSet<>(), edges);
        return edges;
    }

    private void dfs(String tableId, int maxDepth, int currentDepth, Set<String> visited, List<JobLineage> edges) {
        if (currentDepth > maxDepth || visited.contains(tableId)) {
            return;
        }
        visited.add(tableId);
        // TODO load outgoing edges via mapper
        List<JobLineage> outgoing = new ArrayList<>();
        for (JobLineage edge : outgoing) {
            edges.add(edge);
            dfs(edge.getDownstreamTableId(), maxDepth, currentDepth + 1, visited, edges);
        }
    }
}
