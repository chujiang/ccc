package com.kingnod.etraining.common.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.Attachment;


    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
public interface AttachmentService {

    
    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
    Attachment getAttachment(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
    int saveAttachment(Attachment attachment);

    
    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
    int deleteAttachment(Attachment attachment);

    
    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
    int deleteAttachmentByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
    PagingResult<Attachment> findAttachment(Criteria criteria);
    
    /**
     * 从request中取得上传的文件流并保存到文件服务器
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public int uploadAttachment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    /**
     * 删除Attachment对象及存储的物理文件
     * @param ids
     * @return
     */
    public int removeAttachment(Long... ids);
    
    /**
     * 获取指定附件的url
     * @param attachment
     * @return
     */
    public String getAttachmentUrl(Attachment attachment);
    
    public String getAttachmentUrl(Long id);
}