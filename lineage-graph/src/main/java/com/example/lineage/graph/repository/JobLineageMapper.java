package com.example.lineage.graph.repository;

import com.example.lineage.domain.model.JobLineage;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JobLineageMapper {

    List<JobLineage> findOutgoingEdges(@Param("tableId") String tableId);

    List<JobLineage> findIncomingEdges(@Param("tableId") String tableId);
}
