package com.example.lineage.graph.repository;

import com.example.lineage.domain.model.TableAsset;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TableAssetMapper {

    List<TableAsset> findDownstreamTables(@Param("tableId") String tableId);

    List<TableAsset> findUpstreamTables(@Param("tableId") String tableId);
}
