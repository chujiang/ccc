package com.kingnod.etraining.common.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.ui.components.TreeNode;
import java.util.List;

@com.kingnod.core.annotation.Generated("2012-02-14 11:19")
public interface TypeService {
    List<Type> getTreeNodeList(Long nodeId, String nodeType,Long siteID);
  
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    Type getType(Long id);
  
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    int saveType(Type type);
  
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    int deleteType(Type type);
  
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    int deleteTypes(Long id);
    
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    int deleteTypeByIds(Long[] ids);
  
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    PagingResult<Type> findType(Criteria criteria);
  
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    int updateType(Long id, String typeName);
    
    @com.kingnod.core.annotation.Generated("2012-02-14 11:19")
    public boolean getChildLevel(Type type);
    
    public int move2before(Long typeId, Long targetId);
    
    public int move2after(Long typeId, Long targetId);
    
}