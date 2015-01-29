

/*==============================================================*/
/* Table: ATY_ACTIVITY                                          */
/*==============================================================*/
create table ATY_ACTIVITY
(
   ACTIVITY_ID          bigint   not null ,
   TYPE                 char(4) default '',
   FOLDER_ID            bigint  ,
   NAME                 varchar(100),
   OBJECT_DETAILS       varchar(3000),
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   GRADE                numeric(1,0) comment '活动星级',
   RELEASE_DATE         datetime comment '发布日期',
   COMPLETE_NUMBER      bigint   comment '完成人数',
   ONLINE_NUMBER        bigint   comment '在线人数',
   RELEASE_STAUTS       char(1) comment '状态, P：编辑，C：审核中 R：发布' 
);

/*==============================================================*/
/* Index: ATY_ACTIVITY_PK                                       */
/*==============================================================*/
create unique index ATY_ACTIVITY_PK on ATY_ACTIVITY
(
   ACTIVITY_ID,
   TYPE
);

/*==============================================================*/
/* Table: ATY_ELEARNING                                         */
/*==============================================================*/
create table ATY_ELEARNING
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '活动文件夹ID',
   COURSE_ID            bigint   comment '课程ID',
   NAME                 varchar(100) comment '活动名称',
   TRAINER              bigint   comment '讲师ID',
   LESSONS              numeric(9,0) comment '课时',
   CREDIT               numeric(9,0) comment '学分',
   FINISH_TIME          datetime comment '目标完成时间',
   START_ENROLL_TIME    datetime comment '报名开始时间',
   END_ENROLL_TIME      datetime comment '报名结束时间',
   MIN_ENROLL_NUMBER    numeric(9,0) comment '最少报名人数',
   MAX_ENROLL_NUMBER    numeric(9,0) comment '最多报名人数',
   ENABLED_WAITING      char(1) default '' comment '启用等待列表',
   ALLOW_LOGOUT         char(1) default 'Y' comment '允许注销,Y:是,N:否',
   COURSE_TYPE_ID       bigint   comment '课程类别ID',
   RELEASE_STAUTS       char(1) default '' comment '状态, P：编辑，C：审核中 R：发布',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   RELEASE_DATE         datetime comment '发布日期',
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_ENROLL_EXAM_WORKER                                */
/*==============================================================*/
create table ATY_ENROLL_EXAM_WORKER
(
   ID                   bigint   not null auto_increment,
   ACTIVITY_ID          bigint   comment '活动ID',
   USER_ID              bigint   comment '考试工作人员用户ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   WORK_TYPE            char(18) comment '考试工作人员类型 I-监考员   M-阅卷员   A-审核员',
   QUESTION_ID          bigint   not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_ENROLL_LEARNER                                    */
/*==============================================================*/
create table ATY_ENROLL_LEARNER
(
   ID                   bigint   not null auto_increment,
   ACTIVITY_ID          bigint   comment '活动ID',
   USER_ID              bigint   comment '用户ID',
   ENROLL_MODE          char(1) default '' comment '登记方式， S：自愿， F：强制， C：审核',
   STAUTS               char(1) default '' comment '状态， R：注册， O：注销',
   EXCLUDED             char(1) default '' comment '是否排除',
   ACTIVITY_TYPE        char(4) default '' comment '活动类型',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   IS_NEW               char(1),
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_ENROLL_LEARNER_FILTER                             */
/*==============================================================*/
create table ATY_ENROLL_LEARNER_FILTER
(
   ID                   bigint   not null auto_increment,
   ACTIVITY_ID          bigint   comment '活动ID',
   GROUP_NUMBER         numeric(9,0) comment '条件区标记',
   GROUP_NAME           varchar(100) comment '条件区名称',
   TYPE                 char(4) default '' comment '条件类型：S：站点， O:组织， U：用户, G：用户组， R：角色， P：用户属性',
   FILTER_NAME          varchar(100) comment '条件名',
   FILTER_OPERATOR      varchar(100) comment '条件过滤操作符',
   FILTER_VALUE         varchar(100) comment '条件过滤的值',
   ENROLL_MODE          char(1) default '' comment '登记方式， S：自愿， F：强制， C：审核',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_EXAMINATION                                       */
/*==============================================================*/
create table ATY_EXAMINATION
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '资源文件夹ID',
   ATY_PAPER_ID         bigint   comment '试卷ID',
   NAME                 varchar(200) comment '考试名称',
   OPEN_TIME            datetime comment '开考时间',
   CLOSE_TIME           datetime comment '结束',
   SCORING_TYPE         char(1) default 'H' comment '计分方式， H:最高得分， L：最后得分，A：平均得分',
   ATY_TIME             numeric(9,0) comment '考试时长，单位为分钟',
   ENABLED_CHECH        char(1) default 'N' comment '是否审核， Y：是， N：否',
   ANSWER_ORDER         char(1) default 'N' comment '答题次序, N: 正常次序， R：不限制次序',
   DISPLAY_SCORE        char(1) default 'N' comment '显示成绩，N：不显示成绩，Y：显示成绩， A：显示所有人成绩',
   DISPLAY_ORDER        char(1) default 'F' comment '试题显示次序，F：固定显示， R：随机显示',
   ANSWER_DISPLAY_ORDER char(1) default 'F' comment '答案选项显示次序， F：固定显示， R：随机显示',
   DISPLAY_ANSWER       char(1) default 'N' comment '是否显示答案， Y：是， N：否',
   DISPLAY_OBJECTIVE_SCORE char(1) default 'N' comment '显示客观题分数， Y：是， N：否',
   DISPLAY_QUESTION_NUMBER varchar(3) default '3' comment '每页显示题目数量',
   ENABLED_CUT_SCREEN   char(1) default 'Y' comment '防止切屏， Y：是， N：否',
   CUT_SCREEN_TIMES     numeric(4,0) comment '切屏次数',
   ATY_RESTRAINT        char(1) default '' comment '考试限制, N：无，D：每天， W：每周， M：每月',
   ATY_RESTRAINT_TIMES  numeric(9,0) comment '考试限制次数',
   REEXAM_TIME_INTERVAL numeric(9,0) comment '重考间隔时间， 单位为分钟',
   REEXAM_TIMES         numeric(9,0) comment '重考次数',
   REQUIRED_ANSWER_COUNT numeric(9,0) comment '必答题数',
   ENABLED_FEEDBACK     char(1) default 'N' comment '启用答题反馈， Y：是， N：否',
   RESTRICT_IP          char(1) default 'N' comment '是否限制IP， Y：是， N：否',
   SAVING_IP            char(1) default 'Y' comment '是否记录IP， Y：是， N：否',
   WARNING_TIME         numeric(9,0) default 10 comment '结束前时间提醒',
   WARNING_TEXT         varchar(500) default '' comment '提醒内容',
   REMARKS              varchar(1000) comment '考试说明',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   PUBLISH_STATUS       char(1) default 'P' comment '考试发布状态， P：未发布， C: 审核中， R：已发布',
   ADVANCE_TIME         numeric(8,0) default 0 comment '迟到时间',
   OVERDUE_TIME         numeric(8,0) default 0 comment '提前交卷时间',
   MARKING_CHECK        char(1) default 'N' comment '审核阅卷:Y是N否',
   PASS_SCORE           numeric(16,1),
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_EXAMINEES_HISTORY                                 */
/*==============================================================*/
create table ATY_EXAMINEES_HISTORY
(
   ID                   bigint   not null auto_increment,
   USER_ID              bigint   comment '考生ID',
   ATY_PAPER_ID         bigint   comment '试卷ID',
   EXAMINATION_ID       bigint   comment '考试ID',
   GENERATED            char(1) comment '是否已经生成试卷',
   STATUS               char(1) comment '状态，S：考试中，E：考试结束，N：还未开始考试，A：阅卷中，R：阅卷完成',
   START_TIME           datetime comment '考试开始时间',
   END_TIME             datetime comment '考试结束时间',
   ANSWER_TIME_LENGTH   numeric(9,0) comment '答题时长',
   SURPLUS_TIME         numeric(38,0) default 0 comment '考试剩余时间，单位为：毫秒',
   TIMES                numeric(38,0) comment '考试次数',
   SCORE                numeric(16,1) comment '自动阅卷分数',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   TOTALSCORE           numeric(16,1) comment '考试总分数',
   DELIVERY_EXAM_TYPE   char(1) comment '交卷方式：A-正常交卷，S-系统强制交卷，J-监考员交卷，D-其他交卷',
   AUSWERTUNG_STATUS    char(1) default 'I' comment '阅卷状态：A-阅卷中，I-未阅卷，S-阅卷成功,D-审核中，P-审核完成',
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_FOLDER                                            */
/*==============================================================*/
create table ATY_FOLDER
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(100) comment '活动文件夹名称',
   TYPE                 varchar(4) default '' comment '活动文件夹类型, T：培训计划， P：项目计划， E：在线学习， I：综合学习， F：面授培训， S：外派学习， C：案例分析， R：认证学习， O：在线测试， V：实操考核， I：线上评估， U：线下评估',
   DESCRIPTION          varchar(1000) comment '活动文件夹描述',
   SITE_ID              bigint   comment '站点ID',
   PARENT_ID            bigint   comment '父文件夹ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   LEVEL_NUMBER         numeric(9,0) default 0 comment '文件夹层级',
   OBJECT_COUNT         bigint   comment '所属的对象数量',
   FOLDER_COUNT         bigint   comment '子文件夹数量',
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_FOLDER_HIERARCHY                                  */
/*==============================================================*/
create table ATY_FOLDER_HIERARCHY
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   HIERARCHY_ID         bigint   not null comment '父文件夹及祖父文件夹ID',
   HIERARCHY_LEVEL      numeric(9,0) not null comment 'Level',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_PERIOD                                            */
/*==============================================================*/
create table ATY_PERIOD
(
   ID                   bigint   not null auto_increment,
   FLAG_TYPE            varchar(200) default '' comment '标记：如：E：表示在线学习开放时间，S：表示资源预订时间，X：表示在线考试开放时间',
   FLAG_ID              bigint   comment '标记ID，当FLAG_TYPE=E时，FLAG_ID表示在线学习表的ID，当FLAG_TYPE=S时， FLAG_ID表示资源预订表的ID',
   PERIOD_TYPE          char(1) default '' comment '时间类别， N：每天， W: 每周，D：每月， S：特定',
   START_TIME           datetime comment '开始时间',
   END_TIME             datetime comment '结束时间',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   AVAILABLE_DAYS       varchar(200) comment '时间标记，当PERIOD_TYPE=D时period_time应该为1，2，3，4，5.....31中的一组值， 当PERIOD_TYPE=W时period_time应该为Monday，Tuesday ，Wednesday ，Thursday ，Friday ，Saturday ，Saturday 当PERIOD_TYPE=N时period_time应该为null， 当PERIOD_TYPE=S时period_time应该为 ',
   START_DATE           datetime comment '表示活动打开的时间段（如2-12日到2-31日在这个时间段中活动是打开的），默认start_date和end_date都为空表示活动始终打开',
   END_DATE             datetime comment '表示活动关闭的时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_RECOMMEND_OBJECT                                  */
/*==============================================================*/
create table ATY_RECOMMEND_OBJECT
(
   ID                   bigint   not null auto_increment comment 'ID',
   FLAG_ID              bigint   not null comment '推荐对象ID',
   FLAG_TYPE            varchar(4) not null comment '推荐对象类型',
   SITE_ID              bigint   not null comment '站点ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_TIMING_TASK                                       */
/*==============================================================*/
create table ATY_TIMING_TASK
(
   ID                   bigint   auto_increment comment 'ID',
   FLAG_TYPE            char(1) default '' comment '标记：如：E：FLAG_ID表示在线学习开放时间，S：FLAG_ID表示资源预订时间',
   FLAG_ID              bigint   comment '活动ID或资源ID',
   START_TIME           datetime comment '开始时间',
   END_TIME             datetime comment '结束时间',
   primary key (ID)
);

 

/*==============================================================*/
/* Table: ATY_TRAINING_PLAN                                     */
/*==============================================================*/
create table ATY_TRAINING_PLAN
(
   ID                   bigint   auto_increment,
   FOLDER_ID            bigint   comment '活动文件夹ID',
   NAME                 varchar(100) comment '培训计划名称',
   TYPE                 bigint   comment '培训计划类别， CMN_TYPE表的ID',
   LEARNER_NUMBER       numeric(9,0) comment '培训人数',
   DESCRIPTION          varchar(2000) comment '培训计划描述',
   STATUS               char(1) default 'P' comment '培训计划状态, P: 未发布， C：审核中， R：已发布',
   PROCESS_STATUS       char(1) default 'P' comment '培训计划执行状态, N: 未开始， R：执行中，Y：已结束',
   CHECKER              bigint   comment '培训计划审核人员',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   START_TIME           datetime comment '开始时间',
   ENT_TIME             datetime comment '结束时间',
   primary key (ID)
);
 

/*==============================================================*/
/* Table: ATY_TRAINING_PLAN_ACTIVITY                            */
/*==============================================================*/
create table ATY_TRAINING_PLAN_ACTIVITY
(
   ID                   bigint   auto_increment,
   PROCESS_ID           bigint   comment '项目执行ID',
   ACTIVITY_TYPE        char(1) default '' comment '活动类型',
   ACTIVITY_ID          bigint   comment '活动ID',
   ACTIVITY_NAME        varchar(100) comment '活动名称',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

 

/*==============================================================*/
/* Table: ATY_TRAINING_PLAN_ITEM                                */
/*==============================================================*/
create table ATY_TRAINING_PLAN_ITEM
(
   ID                   bigint   auto_increment,
   TRAINING_PLAN_ID     bigint   comment '培训计划ID',
   NAME                 varchar(100) comment '项目名称',
   TYPE                 bigint   comment '项目类别, CMN_TYPE的ID',
   OBJECT               varchar(100) comment '培训对象',
   RESPONSER            bigint   comment '培训负责人， ORG_USER表的ID',
   LEARNER_NUMBER       numeric(9,0) comment '培训人次',
   OUTLINE              varchar(2000) comment '培训纲要',
   LESSONS              varchar(100) comment '培训课时',
   PREDICT_COST         numeric(16,2) comment '培训预算',
   TIME                 varchar(100) comment '培训时间',
   STATUS               char(1) default 'P' comment '培训计划项目状态， R：执行中， E：结束',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime ,
   primary key (ID)
);

 

/*==============================================================*/
/* Table: ATY_TRAINING_PLAN_ITEM_COST                           */
/*==============================================================*/
create table ATY_TRAINING_PLAN_ITEM_COST
(
   ID                   bigint   auto_increment,
   TRAINING_PLAN_ITEM_ID bigint   comment '培训计划项目ID， ATY_TRAINING_PLAN_ITEM表的ID',
   NAME                 varchar(100) comment '费用名称',
   TYPE                 bigint   comment '费用类别, CMN_TYPE的ID',
   PRICE                numeric(16,2) comment '单价',
   AMOUNT               numeric(9,0) comment '数量',
   TOTAL                numeric(16,2) comment '总额',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime ,
   primary key (ID)
);

 

/*==============================================================*/
/* Table: ATY_TRAINING_PLAN_PROCESS                             */
/*==============================================================*/
create table ATY_TRAINING_PLAN_PROCESS
(
   ID                   bigint not null auto_increment,
   TRAINING_PLAN_ID     bigint   comment '培训计划ID',
   TRAINING_PLAN_ITEM_ID bigint   comment '培训计划ID',
   NAME                 varchar(100) comment '项目名称',
   TYPE                 bigint   comment '项目类别, CMN_TYPE的ID',
   OBJECT               varchar(100) comment '培训对象',
   RESPONSER            bigint   comment '培训负责人， ORG_USER表的ID',
   LEARNER_NUMBER       numeric(9,0) comment '培训人次',
   OUTLINE              varchar(2000) comment '培训纲要',
   LESSONS              varchar(100) comment '培训课时',
   PREDICT_COST         numeric(16,2) comment '培训预算',
   TIME                 varchar(100) comment '培训时间',
   STATUS               char(1) default 'P' comment '培训计划项目状态， R：执行中， E：结束',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

 

/*==============================================================*/
/* Table: ATY_USER_ACTIVITY                                     */
/*==============================================================*/
create table ATY_USER_ACTIVITY
(
   ID                   bigint   not null auto_increment,
   ACTIVITY_ID          bigint   comment '活动ID',
   USER_ID              bigint   comment '学员ID',
   STATUS               varchar(20) default '' comment '学习结果类型, N：未尝试， C：已完成， P：已通过，F：未通过',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   TYPE                 char(4),
   PROGRESS_RATE        varchar(20) comment '学习进度',
   TOTAL_TIME           bigint   comment '总学习时间',
   SCORE                numeric(5,1) comment '成绩',
   COMPLETED_DATE       datetime comment '完成时间',
   COMMENTS             varchar(1000),
   primary key (ID)
);

/*==============================================================*/
/* Table: ATY_WOKFLOW_BUSINESS                                  */
/*==============================================================*/
create table ATY_WOKFLOW_BUSINESS
(
   ID                   bigint   auto_increment comment 'ID',
   WORKFLOW_ID          varchar(250) comment '流程实例ID',
   BUSINESS_TYPE        varchar(250) comment '业务类型 如：培训计划等',
   BUSINESS_ID          varchar(250) comment '业务ID',
   primary key (ID)
);

 

/*==============================================================*/
/* Table: ATY_WORKFLOW_APPROVAL                                 */
/*==============================================================*/
create table ATY_WORKFLOW_APPROVAL
(
   ID                   bigint   auto_increment,
   WORKFLOW_ID          varchar(250) comment '流程实例ID',
   TASK_KEY             varchar(250) comment '节点key',
   APPROVAL_TYPE        char(1) default '' comment '审批类型 如：0（同意）1（不同意）',
   APPROVAL_OPINION     varchar(500) comment '审批意见',
   APPROVAL_PEOPLE      varchar(250) comment '审批人',
   APPROVAL_DATETIME    datetime comment '审批时间（年月日时分秒）',
   FILE_PATH            varchar(250) comment '附件路径',
   REMARKS              varchar(500) comment '备注',
   primary key (ID)
);

 

/*==============================================================*/
/* Table: CMN_ATTACHMENT                                        */
/*==============================================================*/
create table CMN_ATTACHMENT
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(100) comment '文件名',
   TYPE                 char(1) default '' comment '文件类型, I: image',
   EXT                  char(10) default '' comment '文件扩展名',
   FILE_SIZE            bigint   comment '文件大小',
   SEGMENT_NO           bigint   comment 'segment no',
   PHYSICS_NAME         varchar(200) comment '存储的物理名称',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   STATUS               char(1) comment 'T:临时文件， A：可用的',
   primary key (ID)
);

/*==============================================================*/
/* Table: CMN_EVALUATION                                        */
/*==============================================================*/
create table CMN_EVALUATION
(
   ID                   bigint   not null auto_increment,
   ACTIVITY_ID          bigint  ,
   ACTIVITY_TYPE        char(8),
   TYPE                 bigint  ,
   GRADE                numeric(1,0),
   DESCRIPTION          varchar(250),
   RECORD_STATUS        char(1),
   UPDATE_COUNT         bigint  ,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: CMN_OBJECT_RELATION                                   */
/*==============================================================*/
create table CMN_OBJECT_RELATION
(
   ID                   bigint   not null auto_increment,
   OBJECT1_TYPE         char(4) default '' comment '对象1的类型',
   OBJECT1_ID           bigint   comment '对象1的ID',
   OBJECT2_TYPE         char(4) default '' comment '对象2的类型',
   OBJECT2_ID           bigint   comment '对象2的ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: CMN_TYPE                                              */
/*==============================================================*/
create table CMN_TYPE
(
   ID                   bigint   not null auto_increment,
   ROOT                 char(1) default '0',
   PARENT_ID            bigint   comment '父类别ID',
   CHILD_LEVEL          numeric(4,0) default 0,
   SITE_ID              bigint   default 0,
   SEQUENCE             bigint  ,
   NAME                 varchar(200) comment '类别名称',
   DESCRIPTION          varchar(2000) comment '类别描述',
   STATUS               char(1) default 'A' comment '类别状态',
   OBJECT_TYPE          char(1) default 'A' comment '对象类别， A： 培训计划类别， B：项目类别,  C：费用类别',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime ,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime ,
   INHERIT_ABLE         char(1) comment '是否可被子站点继承',
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_ATTEMP                                            */
/*==============================================================*/
create table CRS_ATTEMP
(
   ID                   bigint   not null auto_increment,
   USER_ID              bigint   comment '用户ID',
   COURSE_ID            bigint   comment '课程ID',
   SCO_ID               bigint   comment 'SCOID',
   RAW_STATUS           char(1) default '' comment '本次学习状态',
   EXIT_MODE            char(1) default '' comment '停止状态',
   ENTRY_STATUS         char(1) default '' comment '进入状态',
   RAW_SCORE            numeric(5,1) comment '本次成绩',
   SCORE_MAX            numeric(5,1) comment '最高分',
   SCORE_MIN            numeric(5,1) comment '最低分',
   SESSION_TIME         bigint   comment 'SCO会话时间',
   LESSON_LOCATION      varchar(1000) comment 'SCO位置',
   LESSON_MODE          varchar(20) comment '浏览模式',
   SUSPEND_DATA         varchar(1000) comment '停止数据',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_CONTENT_SERVER                                    */
/*==============================================================*/
create table CRS_CONTENT_SERVER
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(100) comment '内容服务器名称',
   ROOT_PATH            varchar(100) comment '内容服务器根路径',
   FTP_SERVER           varchar(100) comment 'FTP服务名',
   FTP_USER_NAME        varchar(100) comment 'FTP用户名',
   FTP_PASSWORD         varchar(100) comment 'FTP密码',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_COURSE_EVALUATION                                 */
/*==============================================================*/
create table CRS_COURSE_EVALUATION
(
   ID                   bigint   not null auto_increment comment '课程评论ID',
   TYPE                 bigint   comment '课程评论类型',
   GRADE                numeric(1,0) comment '等级',
   DESCRIPTION          varchar(250) comment '评论内容',
   RECORD_STATUS        char(1) not null default '' comment '评论状态',
   UPDATE_COUNT         bigint   not null default 0 comment '更新次数',
   CREATOR_ID           bigint   not null comment '创建人',
   CREATE_DATE          datetime not null comment '创建时间',
   UPDATER_ID           bigint   comment '更新人',
   UPDATE_DATE          datetime comment '更新时间',
   COURSE_ID            bigint   comment '被评论的课程',
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_COURSE_INFO                                       */
/*==============================================================*/
create table CRS_COURSE_INFO
(
   ID                   bigint   not null auto_increment comment '课程ID',
   FOLDER_ID            bigint   comment '目录',
   CONTENT_SERVER_ID    bigint   comment '内容服务器',
   LOCATION             varchar(250) comment '课程所在位置',
   TYPE                 char(1) default 'S' comment '课程类型',
   MASTER_ID            bigint   comment '课程主管',
   SLAVE_ID             varchar(300) comment '课程辅导员',
   COURSE_TITLE         varchar(300) comment '课程名称',
   PARTICIPANT          varchar(100) comment '受众对象',
   CONTROL              bigint   comment '导航模式',
   AUTHOR               varchar(100) comment '课程作者',
   KEYWORD              varchar(250) comment '课程关键字',
   COST_TYPE            char(1) default 'P' comment '课程价格类型',
   COST_VALUE           numeric(9,2) comment '课程价格',
   DESCRIPTION          varchar(2000) comment '课程描述信息',
   RECORD_STATUS        char(1) default 'A' comment '课程状态',
   UPDATE_COUNT         bigint   default 0 comment '更新次数',
   CREATOR_ID           bigint   comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   UPDATER_ID           bigint   comment '更新人',
   UPDATE_DATE          datetime comment '更新时间',
   ATTACHMENT_ID        bigint   comment '课程图片存放在CMN_ATTACHMENT表中的ID',
   IMP_PATH             varchar(1000),
   RELEASE_STATUS       char(1),
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_ITEM_INFO                                         */
/*==============================================================*/
create table CRS_ITEM_INFO
(
   ID                   bigint   not null auto_increment comment 'SCOID',
   COURSE_ID            bigint   comment '课程',
   FILEID               bigint   comment '课程文件',
   IDETIFIER            varchar(200) comment 'SCO章节',
   SCO_TYPE             varchar(300) comment 'SCO类型',
   ITEM_TITLE           varchar(300) comment 'SCO名称',
   LAUNCH               varchar(100) comment 'SCO启动路径',
   SCO_RESTRICT         varchar(100) comment 'SCO限制条件',
   PREREQUISITES        varchar(100) comment 'SCO学习的先决条件',
   MASTERY_SCORE        numeric(5,1) comment 'SCO得分',
   MAX_TIME_ALLOWED     timestamp comment 'SCO允许学习的最大时间',
   TIME_LIMIT_ACTION    varchar(100) comment 'SCO时间条件',
   SEQUENCE             bigint   comment 'SCO次序',
   ITEM_PARENT          bigint   comment 'SCO父节点',
   THE_LEVEL            numeric(3,0) comment 'SCO菜单所在等级',
   IDENTIFIER_REF       varchar(200) comment 'SCO与之对应的菜单',
   SCO_IDETIFIER        varchar(200) comment 'SCO在XML中的编号',
   PARENT_IDETIFIER     varchar(200) comment 'SCO在XML中的父编号',
   UUID                 varchar(100) comment 'SCO的UUID',
   PARENT_UUID          varchar(100) comment 'SCO的父UUID',
   ITEM_DESCRIPTION     varchar(250) comment 'SCO的描述信息',
   RECORD_STATUS        char(1) default '' comment 'SCO的状态',
   UPDATE_COUNT         bigint   default 0 comment 'SCO的更新次数',
   CREATOR_ID           bigint   comment 'SCO的创建者',
   CREATE_DATE          datetime comment 'SCO的创建日期',
   UPDATER_ID           bigint   comment 'SCO的更新者',
   UPDATE_DATE          datetime comment 'SCO的更新日期',
   CHILD_LEVEL          numeric(4,0) default -1,
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_PERFORMANCE                                       */
/*==============================================================*/
create table CRS_PERFORMANCE
(
   ID                   bigint   not null auto_increment comment 'ID',
   USER_ID              bigint   comment '用户ID',
   COURSE_ID            bigint   comment '课程ID',
   SCO_TOTAL_COUNT      numeric(9,0) comment 'SCO数量',
   COMPLETED_SCO_COUNT  numeric(9,0) comment '完成的SCO数目 ',
   COMPLETED_PERCENTAGE varchar(10) comment '完成程度',
   STATUS               char(1) default '' comment '状态',
   LESSON_TOTAL_TIME    bigint   comment '学习总时间',
   COMPLETED_DATE       datetime comment '完成时间',
   COMPLETED_TOTAL_TIME bigint   comment '完成时长',
   SCORE                numeric(5,1) comment '成绩',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: CRS_SCO_PERFORMANCE                                   */
/*==============================================================*/
create table CRS_SCO_PERFORMANCE
(
   ID                   bigint   not null auto_increment comment 'ID',
   USER_ID              bigint   comment '用户ID',
   COURSE_ID            bigint   comment '课程ID',
   SCO_ID               bigint   comment 'SCOID',
   STATUS               char(1) default '' comment 'SCO学习状态',
   COMPLETED_DATE       datetime comment 'SCO完成时间',
   COMPLETED_TOTAL_TIME bigint   comment 'SCO完成时长',
   PREREQUISITES        varchar(255) comment '保留',
   EXIT_MODE            char(1) default '' comment '停止状态',
   ENTRY_STATUS         char(1) default '' comment '进入状态',
   SCORE                numeric(5,1) comment '成绩',
   SCORE_MAX            numeric(5,1) comment '保留',
   SCORE_MIN            numeric(5,1) comment '保留',
   CREDIT               char(1) comment '是否得分',
   TOTAL_TIME           bigint   comment '学习总时长',
   LESSON_LOCATION      varchar(1000) comment '课程位置',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_EXAMINEE_ANSWER                                   */
/*==============================================================*/
create table EXM_EXAMINEE_ANSWER
(
   ID                   bigint   not null auto_increment,
   EXAMINEE_QUESTION_ID bigint   comment '考生试题ID',
   QUESTION_ID          bigint   comment '试题ID',
   ANSWER_ID            bigint   comment '答案ID',
   ITEM_SEQ             bigint   comment '试题答案选项顺序',
   CONTENT              varchar(2000) comment '试题答案内容',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_EXAMINEE_QUESTION                                 */
/*==============================================================*/
create table EXM_EXAMINEE_QUESTION
(
   ID                   bigint   not null auto_increment comment '分数ID',
   EXAM_PAPER_ID        bigint   comment '试卷ID， EXM_EXAM_PAPER表的ID',
   USER_ID              bigint   comment '考生ID， ORG_USER表的ID',
   QUESTION_ID          bigint   comment '试题ID， EXM_QUESTION表的ID',
   QUESTION_SEQ         numeric(16,0) comment '试题顺序',
   DEGREE               numeric(4,0) comment '试题难度',
   DESERVED_SCORE       numeric(16,1) comment '试题应得分数， 保留一位小数',
   EXAMINEE_ANSWER      varchar(200) comment '答案',
   EXAMINEE_ANSWER1     varchar(200) comment '答案1',
   EXAMINEE_ANSWER2     varchar(200) comment '答案2',
   EXAMINEE_ANSWER3     varchar(200) comment '答案3',
   EXAMINEE_ANSWER4     varchar(200) comment '答案4',
   REVIEWED             char(1) default '0' comment '复查标识符',
   EXAM_NUMBER          numeric(38,0) comment '考试次数',
   SCORE                numeric(16,1) comment '试题分数',
   CORRECT_ANSWERS      varchar(100) comment '正确答案ID集',
   VIEW_PERSON          bigint   comment '阅卷人， ORG_USER表的ID',
   VIEW_SCORE           numeric(16,1) comment '阅卷得分',
   APPROVE_PERSON       bigint   comment '审核人， ORG_USER表的ID',
   APPROVE_IDEAS        varchar(200) comment '审核人意见',
   CHECK_PERSON         bigint   comment '复核人， ORG_USER表的ID',
   CHECK_IDEAS          varchar(200) comment '复核人意见',
   STATUS               char(1) default '' comment '阅卷状态',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint  ,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   EXAMINATION_ID       bigint  ,
   PARENT_ID            bigint  ,
   RULE_ID              bigint  ,
   APPROVE_SCORE        numeric(16,0),
   QUESTION_TYPE        char(1) comment '试题类型',
   TEST_GROUP_ID        bigint  ,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_EXAMINEE_SCORE                                    */
/*==============================================================*/
create table EXM_EXAMINEE_SCORE
(
   ID                   bigint   not null auto_increment comment '分数ID',
   EXAM_PAPER_ID        bigint   comment '试卷ID， EXM_EXAM_PAPER表的ID',
   USER_ID              bigint   comment '考生ID， ORG_USER表的ID',
   QUESTION_ID          bigint   comment '试题ID， EXM_QUESTION表的ID',
   ANSWER_ID            bigint   comment '答题ID， EXM_QUESTION_ANSWERS表的ID',
   SCORE                numeric(16,1) comment '试题应得分数， 保留一位小数',
   VIEW_PERSON          bigint   comment '阅卷人， ORG_USER表的ID',
   VIEW_SCORE           numeric(16,1) comment '阅卷得分',
   APPROVE_PERSON       bigint   comment '审核人， ORG_USER表的ID',
   APPROVE_IDEAS        varchar(200) comment '审核人意见',
   CHECK_PERSON         bigint   comment '复核人， ORG_USER表的ID',
   CHECK_IDEAS          varchar(200) comment '复核人意见',
   STATUS               char(1) default '' comment '阅卷状态',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint  ,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_EXAM_PAPER                                        */
/*==============================================================*/
create table EXM_EXAM_PAPER
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '资源文件夹ID',
   NAME                 varchar(200) comment '试卷名称',
   TYPE                 char(1) default 'F' comment '出题类型， F:固定出题， R：随机出题',
   READING_TYPE         char(1) default 'A' comment '阅卷方式， M：人工阅卷， A：自动阅卷',
   TOTAL_SCORE          numeric(9,0) comment '试卷总分',
   DEGREE               numeric(4,0) comment '试卷难度',
   PUBLISH_BY           varchar(500) default '' comment '发布单位',
   README               varchar(1000) default '' comment '考试说明',
   STATUS               char(1) default 'P' comment '试卷状态， P：未发布， C: 审核中， R：已发布',
   REMARKS              varchar(1000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   EXTRACTING_QUESTION_WAY char(1) comment '抽题方式  ，S(static): 静态抽题，D(dynamic): 动态抽题',
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_EXAM_PAPER_TEST_GROUP                             */
/*==============================================================*/
create table EXM_EXAM_PAPER_TEST_GROUP
(
   ID                   bigint   not null auto_increment,
   EXAM_PAPER_ID        bigint   comment '试卷ID',
   TEST_GROUP_ID        bigint   comment '测试区ID',
   GROUP_SEQ            numeric(4,0) comment '测试区顺序',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_GENERATING_PAPER_RULE                             */
/*==============================================================*/
create table EXM_GENERATING_PAPER_RULE
(
   ID                   bigint   not null auto_increment,
   EXAM_PAPER_ID        bigint   not null comment '试卷ID',
   TEST_GROUP_ID        bigint   not null comment '测试区ID',
   QUESTION_TYPE        char(1) comment '试题类型',
   QUANTITY_QUESTION    numeric(38,0) comment '题库的题目总量',
   AMOUNT_QUESTION      numeric(38,0) comment '考核题量',
   EVERY_QUESTION_SCORE numeric(16,1) comment '每题分数',
   PART_CORRECT_SCORE   numeric(16,1) comment '部分正确得分',
   WRONG_SCORE          numeric(16,1) comment '答错得分',
   NOT_SCORE            numeric(16,1) comment '不答得分',
   DEGREE               numeric(4,0) comment '难度系数',
   KNOWLEDGE_ID         varchar(500) comment '知识点ID',
   COURSE_ID            varchar(500) comment '课程ID',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_GENERATING_PAPER_SCOPE                            */
/*==============================================================*/
create table EXM_GENERATING_PAPER_SCOPE
(
   ID                   bigint   not null auto_increment,
   EXAM_PAPER_ID        bigint   not null comment '试卷ID',
   QUESTION_FOLDER_ID   bigint   not null comment '题库ID',
   TEST_GROUP_ID        bigint   not null comment '测试区ID',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_KNOWLEDGE                                         */
/*==============================================================*/
create table EXM_KNOWLEDGE
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '资源文件夹ID',
   NAME                 varchar(100) default '' comment '知识名称',
   REMARK               varchar(1000) default '' comment '知识点说明',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint   default 0,
   CREATE_DATE          datetime  ,
   UPDATER_ID           bigint   default 0,
   UPDATE_DATE          datetime  ,
   KNOWLEDGE_NAME       varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_QUESTION                                          */
/*==============================================================*/
create table EXM_QUESTION
(
   ID                   bigint   not null auto_increment comment '试题ID',
   FOLDER_ID            bigint   comment '资源文件夹ID',
   TYPE                 char(1) default '' comment '试题类型, R：单选题， C：多选题， T：填空题， A：问答题， B: 判断题，Z：组合题，Y：语音题',
   DEGREE               numeric(4,0) comment '试题难度',
   SCORE                numeric(16,1) comment '试题分数',
   COURSE_ID            varchar(100) comment '对应的教材',
   CONTENT              varchar(2500) comment '试题内容',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   KNOWLEDGE_ID         varchar(500),
   PARENT_ID            bigint   comment '试题的父级ID',
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_QUESTION_ANSWER                                   */
/*==============================================================*/
create table EXM_QUESTION_ANSWER
(
   ID                   bigint   not null auto_increment,
   QUESTION_ID          bigint   comment '试题ID',
   TYPE                 char(1) default '' comment '试题答案类型，R:单选， C：多选， T：填空， A：多行， B: 判断',
   ANSWER_INDEX         bigint   comment '表示试题的第几个题问',
   ITEM_SEQ             bigint   comment '试题答案选项顺序',
   ITEM_CONTENT         varchar(2000) comment '试题答案选项内容',
   CORRECT              char(1) default '' comment '是否是正确答案',
   SCORE                numeric(16,1) comment '答对得分',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   ITEM_CONTENT2        varchar(2000) comment '试题答案选项内容的扩充，当答案内容过长时，用该字段存储数据',
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_QUESTION_KNOWLEDGE                                */
/*==============================================================*/
create table EXM_QUESTION_KNOWLEDGE
(
   ID                   bigint   not null auto_increment,
   QUESTION_ID          bigint   not null comment '试题ID',
   KNOWLEDGE_ID         bigint   not null comment '知识点ID',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   KNOWLEDGE_NAME       varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_QUESTION_TEST_GROUP                               */
/*==============================================================*/
create table EXM_QUESTION_TEST_GROUP
(
   ID                   bigint   not null auto_increment,
   EXAM_PAPER_ID        bigint   comment '试卷ID， EXM_EXAM_PAPER表的ID',
   TEST_GROUP_ID        bigint   comment '测试区ID, EXM_TEST_GROUP表的ID',
   QUESTION_ID          bigint   comment '试题ID，EXM_QUESTION表的ID',
   TYPE                 char(1) default '' comment '试题类型',
   DEGREE               numeric(4,0) comment '试题难度',
   SCORE                numeric(16,1) comment '试题分数',
   SEQUENCE             numeric(9,0) comment '试题序号',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: EXM_TEST_GROUP                                        */
/*==============================================================*/
create table EXM_TEST_GROUP
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(100) default '' comment '测试区名称',
   EXAM_PAPER_ID        bigint   comment '试卷ID',
   GROUP_SEQ            numeric(4,0) comment '测试区顺序',
   QUESTION_TYPE        char(1) default '' comment '试题类型， R:单选题， C：多选题， T：填空题， A：简答题， B: 判断题',
   READING_TYPE         char(1) default 'F' comment '阅卷方式',
   STATUS               char(1) default 'P' comment '测试区状态， P：未发布， R：已发布',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   SCORE                numeric(16,1) comment '分数',
   QUESTION_NUMBER      numeric(38,0) comment '试题数',
   GENERATOR_PAPER_PATTERN char(1) comment '组卷方式， A: 自动组卷，M: 手工组卷',
   EXTRACTING_QUESTION_WAY char(1),
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_ORGANIZATION                                      */
/*==============================================================*/
create table ORG_ORGANIZATION
(
   ID                   bigint   not null auto_increment,
   PARENT_ID            bigint   comment '父组织ID',
   NAME                 varchar(200) default '' comment '组织名称',
   SHORT_NAME           varchar(20) comment '组织简称',
   DESCRIPTION          varchar(255) default '' comment '组织描述',
   SITE_ID              bigint   comment '所属站点ID',
   MANAGER_ID           bigint   comment '部门经理',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   LEVEL_NUMBER         numeric(9,0) default 0 comment '组织的层级',
   ORGANIZATION_COUNT   bigint  ,
   OBJECT_COUNT         bigint  ,
   TYPE                 char(4),
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_ORGANIZATION_HIERARCHY                            */
/*==============================================================*/
create table ORG_ORGANIZATION_HIERARCHY
(
   ID                   bigint   not null auto_increment,
   ORGANIZATION_ID      bigint   comment '组织ID',
   HIERARCHY_ID         bigint   not null comment '祖父组织ID',
   HIERARCHY_LEVEL      numeric(9,0) not null comment '祖父组织的Level',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_SITE                                              */
/*==============================================================*/
create table ORG_SITE
(
   ID                   bigint   not null auto_increment,
   PARENT_ID            bigint   comment '父站点ID',
   NAME                 varchar(200) default '' comment '站点名称',
   SHORT_NAME           varchar(20) comment '站点短名称',
   DESCRIPTION          varchar(255) default '' comment '站点描述',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   LEVEL_NUMBER         numeric(9,0) comment '站点层级',
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_SITE_HIERARCHY                                    */
/*==============================================================*/
create table ORG_SITE_HIERARCHY
(
   ID                   bigint   not null auto_increment,
   SITE_ID              bigint   comment '站点ID',
   HIERARCHY_ID         bigint   not null comment '祖父站点ID',
   HIERARCHY_LEVEL      numeric(9,0) not null comment '祖父站点的Level',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_USER                                              */
/*==============================================================*/
create table ORG_USER
(
   ID                   bigint   not null auto_increment,
   FULL_NAME            varchar(20) comment '姓名',
   NICK_NAME            varchar(20) comment '昵称',
   LOGIN_NAME           varchar(20) comment '登录名',
   PASSWORD             varchar(20) comment '密码',
   EMAIL                varchar(100) comment '电子邮件',
   SITE_ID              bigint   comment '所属站点ID',
   ORGANIZATION_ID      bigint   comment '所属组织ID',
   MANAGER_ID           bigint   comment '上级ID',
   ADMINISTRATOR        char(1) default '' comment '是否管理员',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   STATUS               char(1) default 'A' comment '使用状态，L：锁定；A：有效',
   VALIDITY_DATE        datetime comment '使用有效期',
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_USER_GROUP                                        */
/*==============================================================*/
create table ORG_USER_GROUP
(
   ID                   bigint   not null auto_increment,
   SITE_ID              bigint   comment '站点ID',
   NAME                 varchar(100) comment '用户组名称',
   DESCRIPTION          varchar(1000) comment '用户组描述',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_USER_GROUP_FILTER                                 */
/*==============================================================*/
create table ORG_USER_GROUP_FILTER
(
   ID                   bigint   not null auto_increment,
   USER_GROUP_ID        bigint   comment '用户组ID',
   GROUP_NUMBER         numeric(9,0) comment '条件区标记',
   GROUP_NAME           varchar(100) comment '条件区名称',
   TYPE                 char(4) default '' comment '条件类型：S：站点， O:组织， U：用户, G：用户组， R：角色， P：用户属性',
   FILTER_NAME          varchar(100) comment '条件名',
   FILTER_OPERATOR      varchar(100) comment '条件过滤操作符',
   FILTER_VALUE         varchar(100) comment '条件过滤值',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_USER_GROUP_USERS                                  */
/*==============================================================*/
create table ORG_USER_GROUP_USERS
(
   ID                   bigint   not null auto_increment,
   USER_GROUP_ID        bigint   comment '用户组ID',
   USER_ID              bigint   comment '用户ID',
   EXCLUDED             char(1) default '' comment '是否排除',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   IS_NEW               char(1),
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_USER_PROPERTIES                                   */
/*==============================================================*/
create table ORG_USER_PROPERTIES
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(20) comment '名称',
   ENTITY_NAME          varchar(20) comment '实体名称',
   PROPERTY_NAME        varchar(20) comment '属性名称',
   SITE_ID              bigint   comment '站点ID',
   DESCRIPTION          varchar(500) comment '属性描述',
   TYPE                 char(1) default '' comment '属性类型, T: 文本框， S： 下拉框， C：多选框， R：单选框， D：时间选择器， U：用户选择器， A：多行文本框',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: ORG_USER_PROPERTY_DATA                                */
/*==============================================================*/
create table ORG_USER_PROPERTY_DATA
(
   ID                   bigint   not null,
   USER_ID              bigint   comment '用户ID',
   PROPERTY_0           varchar(255),
   PROPERTY_1           varchar(255),
   PROPERTY_2           varchar(255),
   PROPERTY_3           varchar(255),
   PROPERTY_4           varchar(255),
   PROPERTY_5           varchar(255),
   PROPERTY_6           varchar(255),
   PROPERTY_7           varchar(255),
   PROPERTY_8           varchar(255),
   PROPERTY_9           varchar(255),
   PROPERTY_10          varchar(255),
   PROPERTY_11          varchar(255),
   PROPERTY_12          varchar(255),
   PROPERTY_13          varchar(255),
   PROPERTY_14          varchar(255),
   PROPERTY_15          varchar(255),
   PROPERTY_16          varchar(255),
   PROPERTY_17          varchar(255),
   PROPERTY_18          varchar(255),
   PROPERTY_19          varchar(255),
   PROPERTY_20          varchar(255),
   PROPERTY_21          varchar(255),
   PROPERTY_22          varchar(255),
   PROPERTY_23          varchar(255),
   PROPERTY_24          varchar(255),
   PROPERTY_25          varchar(255),
   PROPERTY_26          varchar(255),
   PROPERTY_27          varchar(255),
   PROPERTY_28          varchar(255),
   PROPERTY_29          varchar(255),
   PROPERTY_30          varchar(255),
   PROPERTY_31          varchar(255),
   PROPERTY_32          varchar(255),
   PROPERTY_33          varchar(255),
   PROPERTY_34          varchar(255),
   PROPERTY_35          varchar(255),
   PROPERTY_36          varchar(255),
   PROPERTY_37          varchar(255),
   PROPERTY_38          varchar(255),
   PROPERTY_39          varchar(255),
   PROPERTY_40          varchar(255),
   PROPERTY_41          varchar(255),
   PROPERTY_42          varchar(255),
   PROPERTY_43          varchar(255),
   PROPERTY_44          varchar(255),
   PROPERTY_45          varchar(255),
   PROPERTY_46          varchar(255),
   PROPERTY_47          varchar(255),
   PROPERTY_48          varchar(255),
   PROPERTY_49          varchar(255),
   PROPERTY_50          varchar(255),
   PROPERTY_51          varchar(255),
   PROPERTY_52          varchar(255),
   PROPERTY_53          varchar(255),
   PROPERTY_54          varchar(255),
   PROPERTY_55          varchar(255),
   PROPERTY_56          varchar(255),
   PROPERTY_57          varchar(255),
   PROPERTY_58          varchar(255),
   PROPERTY_59          varchar(255),
   PROPERTY_60          varchar(255),
   PROPERTY_61          varchar(255),
   PROPERTY_62          varchar(255),
   PROPERTY_63          varchar(255),
   PROPERTY_64          varchar(255),
   PROPERTY_65          varchar(255),
   PROPERTY_66          varchar(255),
   PROPERTY_67          varchar(255),
   PROPERTY_68          varchar(255),
   PROPERTY_69          varchar(255),
   PROPERTY_70          varchar(255),
   PROPERTY_71          varchar(255),
   PROPERTY_72          varchar(255),
   PROPERTY_73          varchar(255),
   PROPERTY_74          varchar(255),
   PROPERTY_75          varchar(255),
   PROPERTY_76          varchar(255),
   PROPERTY_77          varchar(255),
   PROPERTY_78          varchar(255),
   PROPERTY_79          varchar(255),
   PROPERTY_80          varchar(255),
   PROPERTY_81          varchar(255),
   PROPERTY_82          varchar(255),
   PROPERTY_83          varchar(255),
   PROPERTY_84          varchar(255),
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime 
);

/*==============================================================*/
/* Table: ORG_USER_PROPERTY_OPTION                              */
/*==============================================================*/
create table ORG_USER_PROPERTY_OPTION
(
   ID                   bigint   not null auto_increment,
   PROPERTY_ID          bigint   comment '属性ID',
   NAME                 varchar(20) comment '选项名称',
   DESCRIPTION          varchar(500) comment '选项描述',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: RES_ATTENDANCE                                        */
/*==============================================================*/
create table RES_ATTENDANCE
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   NAME                 varchar(100) comment '签到表名称',
   ACTIVITY_ID          bigint   comment '培训活动ID',
   DESCRIPTION          varchar(1000) comment '签到表描述',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

 

/*==============================================================*/
/* Table: RES_ATTENDANCE_DETAILS                                */
/*==============================================================*/
create table RES_ATTENDANCE_DETAILS
(
   ID                   bigint   not null auto_increment,
   USER_ID              bigint   comment '用户ID',
   ATTENDANCE_PROJECT_ID bigint   comment '签到项目ID',
   ATTENDANCE_TIME      datetime comment '签到时间',
   STATUS               char(1) default '' comment '签到状态， Y：正常， L：迟到， N：未到',
   LATE_TIME            numeric(9,0) comment '迟到时间，单位为分钟',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);
 

/*==============================================================*/
/* Table: RES_ATTENDANCE_PROJECT                                */
/*==============================================================*/
create table RES_ATTENDANCE_PROJECT
(
   ID                   bigint   not null auto_increment,
   ATTENDANCE_ID        bigint   comment '签到表ID',
   ACTIVITY_PROJECT_ID  bigint   comment '培训项目ID',
   RECORD_TIME          datetime comment '签到时间',
   RECORDER             bigint   comment '签到记录的用户ID',
   PROJECT_NAME         varchar(100) comment '培训项目名称',
   DESCRIPTION          varchar(1000) comment '描述',
   LOCATION             varchar(2000) comment '培训地址',
   TRAINING_OBJECT      varchar(1000) comment '培训对象',
   TRAINER_ID           bigint   comment '讲师ID',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);
 

/*==============================================================*/
/* Table: RES_EQUIPMENT                                         */
/*==============================================================*/
create table RES_EQUIPMENT
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   NAME                 varchar(50) comment '器材名称',
   LOCATION             varchar(200) comment '器材地址',
   PRICE                numeric(18,2) default 0 comment '器材购买价格',
   BUY_TIME             datetime comment '器材购买时间',
   STATUS               char(1) default 'A' comment '场地状态， A：可用， I：不可用',
   IMAGE_ID             bigint   comment '图片ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);
 

/*==============================================================*/
/* Table: RES_FOLDER                                            */
/*==============================================================*/
create table RES_FOLDER
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(100) comment '资源文件夹名称',
   TYPE                 char(4) default '' comment '资源文件夹类型, L:场地， E：器材， T：讲师， A：签到表， S：成绩表， D：培训总结， P：题库， S：试卷， C：课程， P：知识点， Q：调查问卷',
   DESCRIPTION          varchar(1000) comment '资源文件夹描述',
   SITE_ID              bigint   comment '站点ID',
   PARENT_ID            bigint   comment '父文件夹ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   LEVEL_NUMBER         numeric(9,0) comment '文件夹所在级别',
   OBJECT_COUNT         bigint   comment '文件夹所属对象的数量',
   FOLDER_COUNT         bigint   comment '子文件夹数量',
   primary key (ID)
);

/*==============================================================*/
/* Table: RES_FOLDER_HIERARCHY                                  */
/*==============================================================*/
create table RES_FOLDER_HIERARCHY
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   HIERARCHY_ID         bigint   not null comment '父文件夹及祖父文件夹ID',
   HIERARCHY_LEVEL      numeric(9,0) not null comment 'Level',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: RES_LEARNER_SCORE                                     */
/*==============================================================*/
create table RES_LEARNER_SCORE
(
   ID                   bigint   not null auto_increment,
   SCORE_SHEET_ID       bigint   comment '成绩表ID',
   USER_ID              bigint   comment '用户ID',
   SCORE1               numeric(16,2) default 0 comment '成绩1',
   SCORE2               numeric(16,2) default 0 comment '成绩2',
   SCORE3               numeric(16,2) default 0 comment '成绩3',
   SCORE4               numeric(16,2) default 0 comment '成绩4',
   SCORE5               numeric(16,2) default 0 comment '成绩5',
   SCORE6               numeric(16,2) default 0 comment '成绩6',
   SCORE7               numeric(16,2) default 0 comment '成绩7',
   SCORE8               numeric(16,2) default 0 comment '成绩8',
   SCORE9               numeric(16,2) default 0 comment '成绩9',
   SCORE10              numeric(16,2) default 0 comment '成绩10',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: RES_LOCATION                                          */
/*==============================================================*/
create table RES_LOCATION
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   NAME                 varchar(50) comment '场地名称',
   LOCATION             varchar(200) comment '场地详细地址',
   STATUS               char(1) default 'A' comment '场地状态， A：可用， I：不可用',
   IMAGE_ID             bigint   comment '图片ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

 
/*==============================================================*/
/* Table: RES_SCORE_RELATION                                    */
/*==============================================================*/
create table RES_SCORE_RELATION
(
   ID                   bigint   not null auto_increment,
   SCORE_SHEET_ID       bigint   comment '成绩表ID',
   LEARNER_SCORE_ID     bigint   comment '学员成绩表ID',
   LEARNER_SCORE_COLUMN varchar(10) comment '学员成绩表字段',
   COLUMN_NAME          varchar(20) comment '成绩名称',
   REMARK               varchar(2000) comment '描述',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   PASS_SCORE           bigint   comment '单科及格分数线',
   SCORE_PERCENTAGE     numeric(3,0) default 0 comment '加权百分比',
   primary key (ID)
);
 

/*==============================================================*/
/* Table: RES_SCORE_SHEET                                       */
/*==============================================================*/
create table RES_SCORE_SHEET
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   NAME                 varchar(100) comment '成绩表名称',
   ACTIVITY_ID          bigint   comment '培训活动ID',
   DESCRIPTION          varchar(1000) comment '成绩表描述',
   REMARK               varchar(2000) comment '备注',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   PASSSCORE            numeric(16,2) default 0 comment '及格分数',
   primary key (ID)
);

 

/*==============================================================*/
/* Table: RES_TRAINER                                           */
/*==============================================================*/
create table RES_TRAINER
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint   comment '文件夹ID',
   USER_ID              bigint   comment '讲师用户ID',
   NAME                 varchar(50) comment '讲师名称',
   AGE                  numeric(4,0) comment '讲师年龄',
   STAR                 numeric(4,0) comment '讲师星级',
   LEVEL_ID             bigint   comment '讲师职称ID',
   COST_TYPE            char(1) default '' comment '讲师费用类型， H：按小时， D：按天，  O: 其它',
   COST                 numeric(18,2) comment '讲师费用',
   TELEPHONE            varchar(50) comment '讲师电话',
   EMAIL                varchar(100) comment '讲师邮箱',
   ADDRESS              varchar(100) comment '讲师地址',
   IMAGE_ID             bigint   comment '图片ID',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   DESCRIPTION          varchar(250) comment '讲师简介',
   primary key (ID)
);

 

/*==============================================================*/
/* Table: RPT_FOLDER                                            */
/*==============================================================*/
create table RPT_FOLDER
(
   ID                   bigint   not null auto_increment,
   NAME                 varchar(100),
   TYPE                 char(4),
   DESCRIPTION          varchar(1000),
   SITE_ID              bigint  ,
   PARENT_ID            bigint  ,
   RECORD_STATUS        char(1),
   UPDATE_COUNT         bigint  ,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   LEVEL_NUMBER         numeric(9,0),
   OBJECT_COUNT         bigint  ,
   FOLDER_COUNT         bigint  ,
   primary key (ID)
);

/*==============================================================*/
/* Table: RPT_FOLDER_HIERARCHY                                  */
/*==============================================================*/
create table RPT_FOLDER_HIERARCHY
(
   ID                   bigint   not null auto_increment,
   FOLDER_ID            bigint  ,
   HIERARCHY_ID         bigint   not null,
   HIERARCHY_LEVEL      numeric(9,0) not null,
   RECORD_STATUS        char(1) not null,
   UPDATE_COUNT         bigint   not null,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_AUTHORITY                                         */
/*==============================================================*/
create table SYS_AUTHORITY
(
   ID                   bigint   not null auto_increment,
   CODE                 varchar(50),
   NAME                 varchar(100),
   primary key (ID)
);

 

/*==============================================================*/
/* Table: SYS_AUTHORITY_REF                                     */
/*==============================================================*/
create table SYS_AUTHORITY_REF
(
   OWNER_ID             bigint   not null auto_increment comment '权限拥有者的ID',
   OWNER_TYPE           char(1) comment '权限拥有者类型：  U-用户 R-角色  O-部门机构  G-工作组',
   AUTHORITY_ID         bigint   comment '权限ID',
   primary key (OWNER_ID)
);

/*==============================================================*/
/* Table: SYS_BIT_MAPPING                                       */
/*==============================================================*/
create table SYS_BIT_MAPPING
(
   MAPPING_TYPE         char(1) not null   comment '映射的类型',
   SERIAL_NUMBER        numeric(8,0) comment '对应Read_permission的序号',
   BIT_VALUE            char(31) comment '二进制值',
   INT_VALUE            numeric(38,0) comment '十进制值',
   OBJECT_ID            bigint   comment '角色、用户组ID' 
);

/*==============================================================*/
/* Table: SYS_BULLETIN                                          */
/*==============================================================*/
create table SYS_BULLETIN
(
   ID                   bigint   not null auto_increment,
   TITLE                varchar(100) comment '公告标题',
   CONTENTS             text comment '公告内容',
   OBJECT_TYPE          char(4) not null default '' comment '公告类型，站点公告、组织公告、角色公告',
   OBJECT_ID            bigint   not null comment '公告类型ID',
   START_TIME           datetime comment '有效开始时间',
   END_TIME             datetime comment '有效结束时间',
   STATUS               char(1) not null default '' comment '状态，发布，未发布',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ENTITY                                            */
/*==============================================================*/
create table SYS_ENTITY
(
   ID                   char(18),
   ENTITY_NAME          char(18),
   TABLE_NAME           char(18)
);

 

/*==============================================================*/
/* Table: SYS_ENTITY_AUTHORITY                                  */
/*==============================================================*/
create table SYS_ENTITY_AUTHORITY
(
   ID                   bigint   not null auto_increment,
   AUTHORITY_NAME       varchar(100) comment '权限名称',
   AUTHORITY_VALUE      numeric(32,0) comment '权限十进制代码 1-读  2-写 4-删除',
   IS_COMMON            char(1) comment '是否公共权限，比如说所有的记录级权限都有读、写、删除，但不一定有发布，报表等权限',
   ENTITY_TYPE          varchar(20) comment '实体的类型',
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ENTITY_AUTHORITY_REF                              */
/*==============================================================*/
create table SYS_ENTITY_AUTHORITY_REF
(
   EA_ID                bigint   not null comment '被引用的权限ID',
   REF_ID               bigint   not null comment '引用权限的对象ID、可以是菜单ID、功能ID',
   REF_TYPE             varchar(20) comment '被引用的类型：menu-菜单、func-功能'
);

/*==============================================================*/
/* Table: SYS_ENTITY_PERMISSION                                 */
/*==============================================================*/
create table SYS_ENTITY_PERMISSION
(
   ENTITY_ID            bigint   comment '实体的ID',
   ENTITY_TYPE          varchar(20) comment '实体类型',
   OWNER_TYPE           char(1) comment '拥有者类型  R-角色  G-用户组  U-用户',
   OWNER_ID             bigint   comment '拥有者ID',
   PERMISSION_VALUE     numeric(38,0) comment '权限值'
);

/*==============================================================*/
/* Table: SYS_ENTITY_READ_PERMISSION                            */
/*==============================================================*/
create table SYS_ENTITY_READ_PERMISSION
(
   ENTITY_ID            bigint  ,
   ENTITY_TYPE          varchar(20),
   OWNER_TYPE           char(1),
   OWNER_0              numeric(38,0),
   USER_ID              bigint  ,
   OWNER_1              numeric(38,0),
   OWNER_2              numeric(38,0),
   OWNER_3              numeric(38,0),
   OWNER_4              numeric(38,0),
   OWNER_5              numeric(38,0),
   OWNER_6              numeric(38,0),
   OWNER_7              numeric(38,0),
   OWNER_8              numeric(38,0),
   OWNER_9              numeric(38,0),
   OWNER_10             numeric(38,0),
   OWNER_11             numeric(38,0),
   OWNER_12             numeric(38,0)
);

/*==============================================================*/
/* Table: SYS_FUNCTION                                          */
/*==============================================================*/
create table SYS_FUNCTION
(
   ID                   bigint  ,
   NAME                 varchar(200) comment '系统功能名称',
   TYPE                 varchar(20) comment '系统功能类型： SYS_MENU-系统功能菜单 ',
   DESCRIPTION          varchar(2000) comment '功能描述',
   PARENT_ID            bigint   comment '父功能ID -1 表示此功能对象为根结点',
   URI                  varchar(200) comment '此功能对应的URI，定义时可以加入下面前缀，不加前缀刚默认为url url:表示此资源为一个url class:表示对应一个自定义的class bean:表示对应一个spring中的bean',
   POSITION             numeric(4,0) comment '功能菜单的显示位置',
   ENABLE               char(1) comment '是否禁用此功能 1-启用 0-禁用',
   IS_LEAF              char(1) comment '是否叶子节点  1-是  0-否',
   primary key (ID)
);
 

/*==============================================================*/
/* Table: SYS_FUNCTION_AUTHORITY                                */
/*==============================================================*/
create table SYS_FUNCTION_AUTHORITY
(
   FUNCTION_ID          bigint   comment '资源ID',
   AUTHORITY_ID         bigint   comment '权限ID',
   MATCH_PATTERN        varchar(1000) comment '匹配模式，设置某个功能URI与受控功能的匹配模式。'
);

/*==============================================================*/
/* Table: SYS_FUNCTION_REF                                      */
/*==============================================================*/
create table SYS_FUNCTION_REF
(
   OWNER_ID             bigint   comment '菜单拥有者ID',
   MENU_ID              bigint   comment '系统菜单ID',
   OWNER_TYPE           char(18) comment '菜单权限的拥有者类型： U-用户  R-角色  O-部门机构   G-工作组'
);

alter table SYS_FUNCTION_REF comment '系统角色菜单关联表';

/*==============================================================*/
/* Table: SYS_MENU                                              */
/*==============================================================*/
create table SYS_MENU
(
   ID                   bigint   not null auto_increment,
   PARENT_ID            bigint   comment '父ID',
   NAME                 varchar(100) comment '菜单名称',
   TYPE                 varchar(30) comment '菜单类型 ',
   URL                  varchar(300) comment '菜单的ＵＲＬ',
   ICON                 varchar(300) comment '菜单图标',
   ICON_TYPE            char(1) comment '菜单图标类型  1-img的图片路径 2-基于div、span标签的class',
   DESCRIPTION          varchar(1000) comment '备注',
   CODE                 varchar(100) comment '菜单代码',
   CSS_CLASS            varchar(50),
   SERIAL_NUMBER        bigint   default 1,
   OPEN_MODE            varchar(20) comment '打开方式',
   AUTH_ID              bigint  ,
   primary key (ID)
);

 

/*==============================================================*/
/* Table: SYS_NOTICE                                            */
/*==============================================================*/
create table SYS_NOTICE
(
   ID                   bigint   not null auto_increment,
   NOTICE_TYPE          varchar(10) comment '通知类型',
   TITLE                varchar(200) comment '标题',
   CONTENT              text comment '内容',
   STATUS               char(1) comment '状态',
   SEND_DATE            datetime comment '发送日期',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   SUMMARY              varchar(500) comment '内容摘要',
   SITE_ID              bigint   comment '站点',
   RECEIVERS            varchar(200) comment '接收人记录',
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_NOTICE_CONFIG                                     */
/*==============================================================*/
create table SYS_NOTICE_CONFIG
(
   ID                   bigint   not null,
   SITE_ID              bigint  ,
   NOTICE_TYPE          varchar(20),
   TITLE                varchar(200),
   CONTENT              text,
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_NOTICE_SETTING                                    */
/*==============================================================*/
create table SYS_NOTICE_SETTING
(
   ID                   bigint   not null auto_increment comment '主键',
   OBJECT_TYPE          char(4) comment '对应模块',
   OBJECT_ID            bigint   comment '对应实例',
   NOTICE_CONFIG_TYPE   varchar(20) comment '通知模板',
   STATUS               char(1) comment '启用状态',
   RECEIVERS            varchar(100) comment '接收对象',
   SEND_TYPE            varchar(10) comment '发送方式',
   SITE_ID              bigint  ,
   OBJECT_EVENT         varchar(20) comment '对应操作',
   RECORD_STATUS        char(1) not null default '',
   UPDATE_COUNT         bigint   not null default 0,
   CREATOR_ID           bigint   not null,
   CREATE_DATE          datetime not null,
   UPDATER_ID           bigint   not null,
   UPDATE_DATE          datetime not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_NOTICE_USERS                                      */
/*==============================================================*/
create table SYS_NOTICE_USERS
(
   ID                   bigint   not null auto_increment comment '主键',
   NOTICE_ID            bigint   comment '通知内容',
   USER_ID              bigint   comment '用户',
   STATUS               char(1) default '0' comment '阅读状态',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_PARAMETER                                         */
/*==============================================================*/
create table SYS_PARAMETER
(
   ID                   bigint   not null auto_increment,
   CODE                 varchar(50) comment '系统参数代码',
   NAME                 varchar(50) comment '系统参数名称',
   VALUE                varchar(200) comment '系统参数的值',
   DEFAULT_VALUE        varchar(200) comment '系统参数默认值',
   TYPE                 char(1) comment '系统参数类型 I(Integer),L(Long),D(Datetime),B(Boolean),C(Collection)',
   DESCRIPTION          varchar(255) comment '系统参数详细描述',
   SCOPE                char(1) comment '系统参数影响的范围, A(应用级), S(站点级)',
   SITE_ID              bigint   comment '系统参数影响的站点',
   RECORD_STATUS        char(1) default '',
   UPDATE_COUNT         bigint   default 0,
   CREATOR_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATER_ID           bigint  ,
   UPDATE_DATE          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Index: SYS_PARAMETER_UK_CODE                                 */
/*==============================================================*/
create unique index SYS_PARAMETER_UK_CODE on SYS_PARAMETER
(
   CODE,
   SITE_ID
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   ID                   bigint   not null auto_increment,
   SITE_ID              bigint   comment '所属站点',
   NAME                 varchar(100) comment '角色名称',
   DESCRIPTION          varchar(500) comment '角色描述',
   RECORD_STATUS        char(1),
   CREATOR_ID           bigint  ,
   UPDATER_ID           bigint  ,
   CREATE_DATE          datetime,
   UPDATE_DATE          datetime,
   UPDATE_COUNT         bigint  ,
   INHERIT_ABLE         char(1) comment '是否能被子站点继承 1:能被继承 0:不能被继承',
   primary key (ID)
);

 

/*==============================================================*/
/* Table: SYS_ROLE_REF                                          */
/*==============================================================*/
create table SYS_ROLE_REF
(
   ID                   bigint   not null auto_increment,
   OWNER_ID             bigint  ,
   ROLE_ID              bigint  ,
   OWNER_TYPE           varchar(500),
   primary key (ID)
);

 