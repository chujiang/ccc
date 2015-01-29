package com.kingnod.etraining.course.action;


  import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.course.service.SCOPerformanceService;
import com.kingnod.etraining.course.utils.AbbreviateUtil;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

  @Namespace("/crs")
  public class TreeJasonAction extends ActionSupport {
    
    private static final long serialVersionUID = 4242612202520616657L;  
    
    protected static Logger log = LoggerFactory.getLogger(TreeJasonAction.class);
    
    private String lessonMode;
    private String scoId;
    private String courseId;
    private Long id = 0L;
    private String nodeType = "";
    
    @Autowired
    SCOPerformanceService  scoPerformanceService;
    
    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNodeType() {
      return nodeType;
    }

    public void setNodeType(String nodeType) {
      this.nodeType = nodeType;
    }

    
    public String execute() throws Exception {

      List<TreeNode> listTemp= new ArrayList<TreeNode>(); 
      
      UserAccount userDetails = SecurityUtils.getCurrentUser();
      Long userId = null!=userDetails.getId()?userDetails.getId():0L;
      
      log.info(courseId);
      log.info(getCourseId());
      String courseId =getCourseId();
      Long courseIdL=0l;
      if(StringUtils.isNotBlank(courseId)){
         courseIdL = Long.valueOf(courseId);
      }
      
      
      String scoId =getScoId();
      Long scoIdL=0l;
      if(StringUtils.isNotBlank(scoId)){
        scoIdL = Long.valueOf(scoId);
      }

      
      listTemp = scoPerformanceService.getSCOTreeList(courseIdL,scoIdL, userId);
      
      
      
      JsonConfig jsonconfig = new JsonConfig();
      jsonconfig.registerJsonBeanProcessor(TreeNode.class, new JsonBeanProcessor(){
        public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
          TreeNode treeNode = (TreeNode)bean;
          JSONObject jsonobj = new JSONObject();
          jsonobj.element("id", treeNode.getId())
          .element("pId", treeNode.getParentId())
          .element("name", treeNode.getName())
          .element("src", treeNode.getSrc())
          .element("openMode", treeNode.getOpenMode())
          .element("target", treeNode.getTarget())
          .element("click", treeNode.isClick())
          .element("icon", treeNode.getIcon())
          .element("open", treeNode.isOpen());
          return jsonobj;
        }});
      
      ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", listTemp);
      ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
     return "jsonResult";
    }

    public String getLessonMode() {
      return lessonMode;
    }

    public void setLessonMode(String lessonMode) {
      this.lessonMode = lessonMode;
    }

    public String getScoId() {
      return scoId;
    }

    public void setScoId(String scoId) {
      this.scoId = scoId;
    }

    public String getCourseId() {
      return courseId;
    }

    public void setCourseId(String courseId) {
      this.courseId = courseId;
    }
  }