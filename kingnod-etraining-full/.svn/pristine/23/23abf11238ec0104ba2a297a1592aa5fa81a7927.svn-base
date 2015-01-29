package com.kingnod.etraining.common.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.common.entity.NoticeUsers;
import com.kingnod.etraining.common.service.NoticeUsersService;
import com.kingnod.etraining.security.entity.UserAccount;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "notice-users", "namespace", "/cmn"})
}
)

    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
public class NoticeUsersAction extends FilterableEntityAction<NoticeUsers, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    private NoticeUsersService noticeUsersService;

@Override public void preparedCriteriaBuilder(CriteriaBuilder cb){
  cb.andEQ("userId",getUserId());
}
public long getUserId(){
  UserAccount userAccount=(UserAccount)SecurityUtils.getCurrentUser();
  return userAccount.getId();
}

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    public String filterDefines() {
        return "cmn.noticeUsersFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    protected Object getEntityService() {
        return this.noticeUsersService;
    }
}