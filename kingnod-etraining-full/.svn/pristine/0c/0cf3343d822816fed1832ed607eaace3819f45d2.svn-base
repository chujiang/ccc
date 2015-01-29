package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.AuthorityRef;
import com.kingnod.etraining.organization.entity.Function;


@com.kingnod.core.annotation.Generated("2012-03-07 15:30")
public interface AuthorityService {

    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    Authority getAuthority(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    int saveAuthority(Authority authority);

    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    int deleteAuthority(Authority authority);

    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    int deleteAuthorityByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    PagingResult<Authority> findAuthority(Criteria criteria);
    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    List<Authority> getAllAuthority();
    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    List<AuthorityRef> getAuthorityID(Long id);
    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    void applicationAuthority(Long roleId,List<Long> authorityId);
    
    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
    public List<Function> findFunctionStair(String functionType);
    
    public List<Function> findFunctionSecondary(Long id);
    
    public List<Authority> findFunctionAuthority(Long id);
}