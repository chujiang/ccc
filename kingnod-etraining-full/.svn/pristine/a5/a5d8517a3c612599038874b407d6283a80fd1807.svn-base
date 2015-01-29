
CREATE TABLE ATY_ACTIVITY
(
	ACTIVITY_ID          bigint AUTO_INCREMENT,
	TYPE                 char(4) NOT NULL,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	OBJECT_DETAILS       TEXT NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	GRADE                decimal(1) NULL,
	RELEASE_DATE         datetime NULL,
	COMPLETE_NUMBER      bigint NULL,
	ONLINE_NUMBER        bigint NULL,
	RELEASE_STAUTS       char(1) NULL,
	PRIMARY KEY (ACTIVITY_ID,TYPE)
);

CREATE TABLE ATY_ELEARNING
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	COURSE_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	TRAINER              bigint NULL,
	LESSONS              decimal(9) NULL,
	CREDIT               decimal(9) NULL,
	FINISH_TIME          datetime NULL,
	START_ENROLL_TIME    datetime NULL,
	END_ENROLL_TIME      datetime NULL,
	MIN_ENROLL_NUMBER    decimal(9) NULL,
	MAX_ENROLL_NUMBER    decimal(9) NULL,
	ENABLED_WAITING      char(1) NULL,
	ALLOW_LOGOUT         char(1) NULL,
	COURSE_TYPE_ID       bigint NULL,
	RELEASE_STAUTS       char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	RELEASE_DATE         datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_ENROLL_EXAM_WORKER
(
	ID                   bigint AUTO_INCREMENT,
	ACTIVITY_ID          bigint NULL,
	USER_ID              bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	WORK_TYPE            char(1) NULL,
	QUESTION_ID          bigint NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_ENROLL_LEARNER
(
	ID                   bigint AUTO_INCREMENT,
	ACTIVITY_ID          bigint NULL,
	USER_ID              bigint NULL,
	ENROLL_MODE          char(1) NULL,
	STAUTS               char(1) NULL,
	EXCLUDED             char(1) NULL,
	ACTIVITY_TYPE        char(4) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	IS_NEW               char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_ENROLL_LEARNER_FILTER
(
	ID                   bigint AUTO_INCREMENT,
	ACTIVITY_ID          bigint NULL,
	GROUP_NUMBER         decimal(9) NULL,
	GROUP_NAME           varchar(100) NULL,
	TYPE                 char(4) NULL,
	FILTER_NAME          varchar(100) NULL,
	FILTER_OPERATOR      varchar(100) NULL,
	FILTER_VALUE         varchar(100) NULL,
	ENROLL_MODE          char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	ACTIVITY_TYPE        CHAR(4) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_EXAMINATION
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	ATY_PAPER_ID         bigint NULL,
	NAME                 varchar(200) NULL,
	OPEN_TIME            datetime NULL,
	CLOSE_TIME           datetime NULL,
	SCORING_TYPE         char(1) NULL,
	ATY_TIME             decimal(9) NULL,
	ENABLED_CHECH        char(1) NULL,
	ANSWER_ORDER         char(1) NULL,
	DISPLAY_SCORE        char(1) NULL,
	DISPLAY_ORDER        char(1) NULL,
	ANSWER_DISPLAY_ORDER char(1) NULL,
	DISPLAY_ANSWER       char(1) NULL,
	DISPLAY_OBJECTIVE_SCORE char(1) NULL,
	DISPLAY_QUESTION_NUMBER varchar(3) NULL,
	ENABLED_CUT_SCREEN   char(1) NULL,
	CUT_SCREEN_TIMES     decimal(4) NULL,
	ATY_RESTRAINT        char(1) NULL,
	ATY_RESTRAINT_TIMES  decimal(9) NULL,
	REEXAM_TIME_INTERVAL decimal(9) NULL,
	REEXAM_TIMES         decimal(9) NULL,
	REQUIRED_ANSWER_COUNT decimal(9) NULL,
	ENABLED_FEEDBACK     char(1) NULL,
	RESTRICT_IP          char(1) NULL,
	SAVING_IP            char(1) NULL,
	WARNING_TIME         decimal(9) NULL,
	WARNING_TEXT         varchar(500) NULL,
	REMARKS              varchar(1000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PUBLISH_STATUS       char(1) NULL,
	ADVANCE_TIME         decimal(8) NULL,
	OVERDUE_TIME         decimal(8) NULL,
	MARKING_CHECK        char(1) NULL,
	PASS_SCORE           decimal(16,1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_EXAMINEES_HISTORY
(
	ID                   bigint AUTO_INCREMENT,
	USER_ID              bigint NULL,
	ATY_PAPER_ID         bigint NULL,
	EXAMINATION_ID       bigint NULL,
	GENERATED            char(1) NULL,
	STATUS               char(1) NULL,
	START_TIME           datetime NULL,
	END_TIME             datetime NULL,
	ANSWER_TIME_LENGTH   decimal(9) NULL,
	SURPLUS_TIME         decimal(38) NULL,
	TIMES                decimal(38) NULL,
	SCORE                decimal(16,1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	TOTALSCORE           decimal(16,1) NULL,
	DELIVERY_EXAM_TYPE   char(1) NULL,
	AUSWERTUNG_STATUS    char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_FOLDER
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(100) NULL,
	TYPE                 varchar(4) NULL,
	DESCRIPTION          varchar(1000) NULL,
	SITE_ID              bigint NULL,
	PARENT_ID            bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	LEVEL_NUMBER         decimal(9) NULL,
	OBJECT_COUNT         bigint NULL,
	FOLDER_COUNT         bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_FOLDER_HIERARCHY
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NOT NULL,
	HIERARCHY_ID         bigint NOT NULL,
	HIERARCHY_LEVEL      decimal(9) NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_PERIOD
(
	ID                   bigint AUTO_INCREMENT,
	FLAG_TYPE            varchar(200) NULL,
	FLAG_ID              bigint NULL,
	PERIOD_TYPE          char(1) NULL,
	START_TIME           datetime NULL,
	END_TIME             datetime NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	AVAILABLE_DAYS       varchar(200) NULL,
	START_DATE           datetime NULL,
	END_DATE             datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_RECOMMEND_OBJECT
(
	ID                   bigint AUTO_INCREMENT,
	FLAG_ID              bigint NOT NULL,
	FLAG_TYPE            varchar(4) NOT NULL,
	SITE_ID              bigint NOT NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_TIMING_TASK
(
	ID                   bigint AUTO_INCREMENT,
	FLAG_TYPE            char(1) NULL,
	FLAG_ID              bigint NULL,
	START_TIME           datetime NULL,
	END_TIME             datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_TRAINING_PLAN
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	TYPE                 bigint NULL,
	LEARNER_NUMBER       decimal(9) NULL,
	DESCRIPTION          varchar(2000) NULL,
	STATUS               char(1) NULL,
	PROCESS_STATUS       char(1) NULL,
	CHECKER              bigint NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	START_TIME           datetime NULL,
	ENT_TIME             datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_TRAINING_PLAN_ACTIVITY
(
	ID                   bigint AUTO_INCREMENT,
	PROCESS_ID           bigint NULL,
	ACTIVITY_TYPE        char(1) NULL,
	ACTIVITY_ID          bigint NULL,
	ACTIVITY_NAME        varchar(100) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_TRAINING_PLAN_ITEM
(
	ID                   bigint AUTO_INCREMENT,
	TRAINING_PLAN_ID     bigint NULL,
	NAME                 varchar(100) NULL,
	TYPE                 bigint NULL,
	OBJECT               varchar(100) NULL,
	RESPONSER            bigint NULL,
	LEARNER_NUMBER       decimal(9) NULL,
	OUTLINE              varchar(2000) NULL,
	LESSONS              varchar(100) NULL,
	PREDICT_COST         decimal(16,2) NULL,
	TIME                 varchar(100) NULL,
	STATUS               char(1) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_TRAINING_PLAN_ITEM_COST
(
	ID                   bigint AUTO_INCREMENT,
	TRAINING_PLAN_ITEM_ID bigint NULL,
	NAME                 varchar(100) NULL,
	TYPE                 bigint NULL,
	PRICE                decimal(16,2) NULL,
	AMOUNT               decimal(9) NULL,
	TOTAL                decimal(16,2) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_TRAINING_PLAN_PROCESS
(
	ID                   bigint AUTO_INCREMENT,
	TRAINING_PLAN_ID     bigint NULL,
	TRAINING_PLAN_ITEM_ID bigint NULL,
	NAME                 varchar(100) NULL,
	TYPE                 bigint NULL,
	OBJECT               varchar(100) NULL,
	RESPONSER            bigint NULL,
	LEARNER_NUMBER       decimal(9) NULL,
	OUTLINE              varchar(2000) NULL,
	LESSONS              varchar(100) NULL,
	PREDICT_COST         decimal(16,2) NULL,
	TIME                 varchar(100) NULL,
	STATUS               char(1) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_USER_ACTIVITY
(
	ID                   bigint AUTO_INCREMENT,
	ACTIVITY_ID          bigint NULL,
	USER_ID              bigint NULL,
	STATUS               varchar(20) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	TYPE                 char(4) NULL,
	PROGRESS_RATE        varchar(20) NULL,
	TOTAL_TIME           bigint NULL,
	SCORE                decimal(5,1) NULL,
	COMPLETED_DATE       datetime NULL,
	COMMENTS             varchar(1000) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_WOKFLOW_BUSINESS
(
	ID                   bigint AUTO_INCREMENT,
	WORKFLOW_ID          varchar(250) NULL,
	BUSINESS_TYPE        varchar(250) NULL,
	BUSINESS_ID          varchar(250) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ATY_WORKFLOW_APPROVAL
(
	ID                   bigint AUTO_INCREMENT,
	WORKFLOW_ID          varchar(250) NULL,
	TASK_KEY             varchar(250) NULL,
	APPROVAL_TYPE        char(1) NULL,
	APPROVAL_OPINION     varchar(500) NULL,
	APPROVAL_PEOPLE      varchar(250) NULL,
	APPROVAL_DATETIME    datetime NULL,
	FILE_PATH            varchar(250) NULL,
	REMARKS              varchar(500) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CMN_ATTACHMENT
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(100) NULL,
	TYPE                 char(1) NULL,
	EXT                  char(10) NULL,
	FILE_SIZE            bigint NULL,
	SEGMENT_NO           bigint NULL,
	PHYSICS_NAME         varchar(200) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	STATUS               char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CMN_EVALUATION
(
	ID                   bigint AUTO_INCREMENT,
	ACTIVITY_ID          bigint NULL,
	ACTIVITY_TYPE        char(8) NULL,
	TYPE                 bigint NULL,
	GRADE                decimal(1) NULL,
	DESCRIPTION          varchar(250) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CMN_OBJECT_RELATION
(
	ID                   bigint AUTO_INCREMENT,
	OBJECT1_TYPE         char(4) NULL,
	OBJECT1_ID           bigint NULL,
	OBJECT2_TYPE         char(4) NULL,
	OBJECT2_ID           bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CMN_TYPE
(
	ID                   bigint AUTO_INCREMENT,
	ROOT                 char(1) NULL,
	PARENT_ID            bigint NULL,
	CHILD_LEVEL          decimal(4) NULL,
	SITE_ID              bigint NULL,
	SEQUENCE             bigint NULL,
	NAME                 varchar(200) NULL,
	DESCRIPTION          varchar(2000) NULL,
	STATUS               char(1) NULL,
	OBJECT_TYPE          char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	INHERIT_ABLE         char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_ATTEMP
(
	ID                   bigint AUTO_INCREMENT,
	USER_ID              bigint NULL,
	COURSE_ID            bigint NULL,
	SCO_ID               bigint NULL,
	RAW_STATUS           char(1) NULL,
	EXIT_MODE            char(1) NULL,
	ENTRY_STATUS         char(1) NULL,
	RAW_SCORE            decimal(5,1) NULL,
	SCORE_MAX            decimal(5,1) NULL,
	SCORE_MIN            decimal(5,1) NULL,
	SESSION_TIME         bigint NULL,
	LESSON_LOCATION      varchar(1000) NULL,
	LESSON_MODE          varchar(20) NULL,
	SUSPEND_DATA         varchar(1000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_CONTENT_SERVER
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(100) NULL,
	ROOT_PATH            varchar(100) NULL,
	FTP_SERVER           varchar(100) NULL,
	FTP_USER_NAME        varchar(100) NULL,
	FTP_PASSWORD         varchar(100) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_COURSE_EVALUATION
(
	ID                   bigint AUTO_INCREMENT,
	TYPE                 bigint NULL,
	GRADE                decimal(1) NULL,
	DESCRIPTION          varchar(250) NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	COURSE_ID            bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_COURSE_INFO
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	CONTENT_SERVER_ID    bigint NULL,
	LOCATION             varchar(250) NULL,
	TYPE                 char(1) NULL,
	MASTER_ID            bigint NULL,
	SLAVE_ID             varchar(300) NULL,
	COURSE_TITLE         varchar(300) NULL,
	PARTICIPANT          varchar(100) NULL,
	CONTROL              bigint NULL,
	AUTHOR               varchar(100) NULL,
	KEYWORD              varchar(250) NULL,
	COST_TYPE            char(1) NULL,
	COST_VALUE           decimal(9,2) NULL,
	DESCRIPTION          varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	ATTACHMENT_ID        bigint NULL,
	IMP_PATH             varchar(1000) NULL,
	RELEASE_STATUS       char(1) NULL,
	WINDOW_HEIGHT        INTEGER NULL,
	WINDOW_WIDTH         INTEGER NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_ITEM_INFO
(
	ID                   bigint AUTO_INCREMENT,
	COURSE_ID            bigint NULL,
	FILEID               bigint NULL,
	IDETIFIER            varchar(200) NULL,
	SCO_TYPE             varchar(300) NULL,
	ITEM_TITLE           varchar(300) NULL,
	LAUNCH               varchar(500) NULL,
	SCO_RESTRICT         varchar(100) NULL,
	PREREQUISITES        varchar(100) NULL,
	MASTERY_SCORE        decimal(5,1) NULL,
	MAX_TIME_ALLOWED     timestamp NULL,
	TIME_LIMIT_ACTION    varchar(100) NULL,
	SEQUENCE             bigint NULL,
	ITEM_PARENT          bigint NULL,
	THE_LEVEL            decimal(3) NULL,
	IDENTIFIER_REF       varchar(200) NULL,
	SCO_IDETIFIER        varchar(200) NULL,
	PARENT_IDETIFIER     varchar(200) NULL,
	UUID                 varchar(100) NULL,
	PARENT_UUID          varchar(100) NULL,
	ITEM_DESCRIPTION     varchar(250) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	CHILD_LEVEL          decimal(4) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_PERFORMANCE
(
	ID                   bigint AUTO_INCREMENT,
	USER_ID              bigint NULL,
	COURSE_ID            bigint NULL,
	SCO_TOTAL_COUNT      decimal(9) NULL,
	COMPLETED_SCO_COUNT  decimal(9) NULL,
	COMPLETED_PERCENTAGE varchar(10) NULL,
	STATUS               char(1) NULL,
	LESSON_TOTAL_TIME    bigint NULL,
	COMPLETED_DATE       datetime NULL,
	COMPLETED_TOTAL_TIME bigint NULL,
	SCORE                decimal(5,1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE CRS_SCO_PERFORMANCE
(
	ID                   bigint AUTO_INCREMENT,
	USER_ID              bigint NULL,
	COURSE_ID            bigint NULL,
	SCO_ID               bigint NULL,
	STATUS               char(1) NULL,
	COMPLETED_DATE       datetime NULL,
	COMPLETED_TOTAL_TIME bigint NULL,
	PREREQUISITES        varchar(255) NULL,
	EXIT_MODE            char(1) NULL,
	ENTRY_STATUS         char(1) NULL,
	SCORE                decimal(5,1) NULL,
	SCORE_MAX            decimal(5,1) NULL,
	SCORE_MIN            decimal(5,1) NULL,
	CREDIT               char(1) NULL,
	TOTAL_TIME           bigint NULL,
	LESSON_LOCATION      varchar(1000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_EXAM_PAPER
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(200) NULL,
	TYPE                 char(1) NULL,
	READING_TYPE         char(1) NULL,
	TOTAL_SCORE          decimal(9) NULL,
	DEGREE               decimal(4) NULL,
	PUBLISH_BY           varchar(500) NULL,
	README               varchar(1000) NULL,
	STATUS               char(1) NULL,
	REMARKS              varchar(1000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	EXTRACTING_QUESTION_WAY char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_EXAM_PAPER_TEST_GROUP
(
	ID                   bigint AUTO_INCREMENT,
	EXAM_PAPER_ID        bigint NULL,
	TEST_GROUP_ID        bigint NULL,
	GROUP_SEQ            decimal(4) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_EXAMINEE_ANSWER
(
	ID                   bigint AUTO_INCREMENT,
	EXAMINEE_QUESTION_ID bigint NULL,
	QUESTION_ID          bigint NULL,
	ANSWER_ID            bigint NULL,
	ITEM_SEQ             bigint NULL,
	CONTENT              varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_EXAMINEE_QUESTION
(
	ID                   bigint AUTO_INCREMENT,
	EXAM_PAPER_ID        bigint NULL,
	USER_ID              bigint NULL,
	QUESTION_ID          bigint NULL,
	QUESTION_SEQ         decimal(16) NULL,
	DEGREE               decimal(4) NULL,
	DESERVED_SCORE       decimal(16,1) NULL,
	EXAMINEE_ANSWER      varchar(200) NULL,
	EXAMINEE_ANSWER1     varchar(200) NULL,
	EXAMINEE_ANSWER2     varchar(200) NULL,
	EXAMINEE_ANSWER3     varchar(200) NULL,
	EXAMINEE_ANSWER4     varchar(200) NULL,
	REVIEWED             char(1) NULL,
	EXAM_NUMBER          decimal(38) NULL,
	SCORE                decimal(16,1) NULL,
	CORRECT_ANSWERS      varchar(100) NULL,
	VIEW_PERSON          bigint NULL,
	VIEW_SCORE           decimal(16,1) NULL,
	APPROVE_PERSON       bigint NULL,
	APPROVE_IDEAS        varchar(200) NULL,
	CHECK_PERSON         bigint NULL,
	CHECK_IDEAS          varchar(200) NULL,
	STATUS               char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	EXAMINATION_ID       bigint NULL,
	PARENT_ID            bigint NULL,
	RULE_ID              bigint NULL,
	APPROVE_SCORE        decimal(16) NULL,
	QUESTION_TYPE        char(1) NULL,
	TEST_GROUP_ID        bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_EXAMINEE_SCORE
(
	ID                   bigint AUTO_INCREMENT,
	EXAM_PAPER_ID        bigint NULL,
	USER_ID              bigint NULL,
	QUESTION_ID          bigint NULL,
	ANSWER_ID            bigint NULL,
	SCORE                decimal(16,1) NULL,
	VIEW_PERSON          bigint NULL,
	VIEW_SCORE           decimal(16,1) NULL,
	APPROVE_PERSON       bigint NULL,
	APPROVE_IDEAS        varchar(200) NULL,
	CHECK_PERSON         bigint NULL,
	CHECK_IDEAS          varchar(200) NULL,
	STATUS               char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_GENERATING_PAPER_RULE
(
	ID                   bigint AUTO_INCREMENT,
	EXAM_PAPER_ID        bigint NOT NULL,
	TEST_GROUP_ID        bigint NOT NULL,
	QUESTION_TYPE        char(1) NULL,
	QUANTITY_QUESTION    decimal(38) NULL,
	AMOUNT_QUESTION      decimal(38) NULL,
	EVERY_QUESTION_SCORE decimal(16,1) NULL,
	PART_CORRECT_SCORE   decimal(16,1) NULL,
	WRONG_SCORE          decimal(16,1) NULL,
	NOT_SCORE            decimal(16,1) NULL,
	DEGREE               decimal(4) NULL,
	KNOWLEDGE_ID         varchar(500) NULL,
	COURSE_ID            varchar(500) NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_GENERATING_PAPER_SCOPE
(
	ID                   bigint AUTO_INCREMENT,
	EXAM_PAPER_ID        bigint NOT NULL,
	QUESTION_FOLDER_ID   bigint NOT NULL,
	TEST_GROUP_ID        bigint NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_KNOWLEDGE
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	REMARK               varchar(1000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	KNOWLEDGE_NAME       varchar(100) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_QUESTION
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	TYPE                 char(1) NULL,
	DEGREE               decimal(4) NULL,
	SCORE                decimal(16,1) NULL,
	COURSE_ID            varchar(100) NULL,
	CONTENT              varchar(2500) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	KNOWLEDGE_ID         varchar(500) NULL,
	PARENT_ID            bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_QUESTION_ANSWER
(
	ID                   bigint AUTO_INCREMENT,
	QUESTION_ID          bigint NULL,
	TYPE                 char(1) NULL,
	ANSWER_INDEX         bigint NULL,
	ITEM_SEQ             bigint NULL,
	ITEM_CONTENT         varchar(2000) NULL,
	CORRECT              char(1) NULL,
	SCORE                decimal(16,1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	ITEM_CONTENT2        varchar(2000) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_QUESTION_KNOWLEDGE
(
	ID                   bigint AUTO_INCREMENT,
	QUESTION_ID          bigint NOT NULL,
	KNOWLEDGE_ID         bigint NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	KNOWLEDGE_NAME       varchar(100) NULL,
	TYPE                 CHAR(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_QUESTION_TEST_GROUP
(
	ID                   bigint AUTO_INCREMENT,
	EXAM_PAPER_ID        bigint NULL,
	TEST_GROUP_ID        bigint NULL,
	QUESTION_ID          bigint NULL,
	TYPE                 char(1) NULL,
	DEGREE               decimal(4) NULL,
	SCORE                decimal(16,1) NULL,
	SEQUENCE             decimal(9) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE EXM_TEST_GROUP
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(100) NULL,
	EXAM_PAPER_ID        bigint NULL,
	GROUP_SEQ            decimal(4) NULL,
	QUESTION_TYPE        char(1) NULL,
	READING_TYPE         char(1) NULL,
	STATUS               char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	SCORE                decimal(16,1) NULL,
	QUESTION_NUMBER      decimal(38) NULL,
	GENERATOR_PAPER_PATTERN char(1) NULL,
	EXTRACTING_QUESTION_WAY char(1) NULL,
	DESCRIPTION          VARCHAR(500) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_ORGANIZATION
(
	ID                   bigint AUTO_INCREMENT,
	PARENT_ID            bigint NULL,
	NAME                 varchar(200) NULL,
	SHORT_NAME           varchar(20) NULL,
	DESCRIPTION          varchar(255) NULL,
	SITE_ID              bigint NULL,
	MANAGER_ID           bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	LEVEL_NUMBER         decimal(9) NULL,
	ORGANIZATION_COUNT   bigint NULL,
	OBJECT_COUNT         bigint NULL,
	TYPE                 char(4) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_ORGANIZATION_HIERARCHY
(
	ID                   bigint AUTO_INCREMENT,
	ORGANIZATION_ID      bigint NULL,
	HIERARCHY_ID         bigint NOT NULL,
	HIERARCHY_LEVEL      decimal(9) NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_SITE
(
	ID                   bigint AUTO_INCREMENT,
	PARENT_ID            bigint NULL,
	NAME                 varchar(200) NULL,
	SHORT_NAME           varchar(20) NULL,
	DESCRIPTION          varchar(500) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	LEVEL_NUMBER         decimal(9) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_SITE_HIERARCHY
(
	ID                   bigint AUTO_INCREMENT,
	SITE_ID              bigint NULL,
	HIERARCHY_ID         bigint NOT NULL,
	HIERARCHY_LEVEL      decimal(9) NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER
(
	ID                   bigint AUTO_INCREMENT,
	FULL_NAME            varchar(20) NULL,
	NICK_NAME            varchar(20) NULL,
	LOGIN_NAME           varchar(20) NULL,
	PASSWORD             varchar(20) NULL,
	EMAIL                varchar(100) NULL,
	SITE_ID              bigint NULL,
	ORGANIZATION_ID      bigint NULL,
	MANAGER_ID           bigint NULL,
	ADMINISTRATOR        char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	STATUS               char(1) NULL,
	VALIDITY_DATE        datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER_GROUP
(
	ID                   bigint AUTO_INCREMENT,
	SITE_ID              bigint NULL,
	NAME                 varchar(100) NULL,
	DESCRIPTION          varchar(1000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER_GROUP_FILTER
(
	ID                   bigint AUTO_INCREMENT,
	USER_GROUP_ID        bigint NULL,
	GROUP_NUMBER         decimal(9) NULL,
	GROUP_NAME           varchar(100) NULL,
	TYPE                 char(4) NULL,
	FILTER_NAME          varchar(100) NULL,
	FILTER_OPERATOR      varchar(100) NULL,
	FILTER_VALUE         varchar(100) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER_GROUP_USERS
(
	ID                   bigint AUTO_INCREMENT,
	USER_GROUP_ID        bigint NULL,
	USER_ID              bigint NULL,
	EXCLUDED             char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	IS_NEW               char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER_PROPERTIES
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(20) NULL,
	ENTITY_NAME          varchar(20) NULL,
	PROPERTY_NAME        varchar(20) NULL,
	SITE_ID              bigint NULL,
	DESCRIPTION          varchar(500) NULL,
	TYPE                 char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	SEQ                  BIGINT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER_PROPERTY_DATA
(
	ID                   bigint AUTO_INCREMENT,
	USER_ID              bigint NULL,
	PROPERTY_0           varchar(255) NULL,
	PROPERTY_1           varchar(255) NULL,
	PROPERTY_2           varchar(255) NULL,
	PROPERTY_3           varchar(255) NULL,
	PROPERTY_4           varchar(255) NULL,
	PROPERTY_5           varchar(255) NULL,
	PROPERTY_6           varchar(255) NULL,
	PROPERTY_7           varchar(255) NULL,
	PROPERTY_8           varchar(255) NULL,
	PROPERTY_9           varchar(255) NULL,
	PROPERTY_10          varchar(255) NULL,
	PROPERTY_11          varchar(255) NULL,
	PROPERTY_12          varchar(255) NULL,
	PROPERTY_13          varchar(255) NULL,
	PROPERTY_14          varchar(255) NULL,
	PROPERTY_15          varchar(255) NULL,
	PROPERTY_16          varchar(255) NULL,
	PROPERTY_17          varchar(255) NULL,
	PROPERTY_18          varchar(255) NULL,
	PROPERTY_19          varchar(255) NULL,
	PROPERTY_20          varchar(255) NULL,
	PROPERTY_21          varchar(255) NULL,
	PROPERTY_22          varchar(255) NULL,
	PROPERTY_23          varchar(255) NULL,
	PROPERTY_24          varchar(255) NULL,
	PROPERTY_25          varchar(255) NULL,
	PROPERTY_26          varchar(255) NULL,
	PROPERTY_27          varchar(255) NULL,
	PROPERTY_28          varchar(255) NULL,
	PROPERTY_29          varchar(255) NULL,
	PROPERTY_30          varchar(255) NULL,
	PROPERTY_31          varchar(255) NULL,
	PROPERTY_32          varchar(255) NULL,
	PROPERTY_33          varchar(255) NULL,
	PROPERTY_34          varchar(255) NULL,
	PROPERTY_35          varchar(255) NULL,
	PROPERTY_36          varchar(255) NULL,
	PROPERTY_37          varchar(255) NULL,
	PROPERTY_38          varchar(255) NULL,
	PROPERTY_39          varchar(255) NULL,
	PROPERTY_40          varchar(255) NULL,
	PROPERTY_41          varchar(255) NULL,
	PROPERTY_42          varchar(255) NULL,
	PROPERTY_43          varchar(255) NULL,
	PROPERTY_44          varchar(255) NULL,
	PROPERTY_45          varchar(255) NULL,
	PROPERTY_46          varchar(255) NULL,
	PROPERTY_47          varchar(255) NULL,
	PROPERTY_48          varchar(255) NULL,
	PROPERTY_49          varchar(255) NULL,
	PROPERTY_50          varchar(255) NULL,
	PROPERTY_51          varchar(255) NULL,
	PROPERTY_52          varchar(255) NULL,
	PROPERTY_53          varchar(255) NULL,
	PROPERTY_54          varchar(255) NULL,
	PROPERTY_55          varchar(255) NULL,
	PROPERTY_56          varchar(255) NULL,
	PROPERTY_57          varchar(255) NULL,
	PROPERTY_58          varchar(255) NULL,
	PROPERTY_59          varchar(255) NULL,
	PROPERTY_60          varchar(255) NULL,
	PROPERTY_61          varchar(255) NULL,
	PROPERTY_62          varchar(255) NULL,
	PROPERTY_63          varchar(255) NULL,
	PROPERTY_64          varchar(255) NULL,
	PROPERTY_65          varchar(255) NULL,
	PROPERTY_66          varchar(255) NULL,
	PROPERTY_67          varchar(255) NULL,
	PROPERTY_68          varchar(255) NULL,
	PROPERTY_69          varchar(255) NULL,
	PROPERTY_70          varchar(255) NULL,
	PROPERTY_71          varchar(255) NULL,
	PROPERTY_72          varchar(255) NULL,
	PROPERTY_73          varchar(255) NULL,
	PROPERTY_74          varchar(255) NULL,
	PROPERTY_75          varchar(255) NULL,
	PROPERTY_76          varchar(255) NULL,
	PROPERTY_77          varchar(255) NULL,
	PROPERTY_78          varchar(255) NULL,
	PROPERTY_79          varchar(255) NULL,
	PROPERTY_80          varchar(255) NULL,
	PROPERTY_81          varchar(255) NULL,
	PROPERTY_82          varchar(255) NULL,
	PROPERTY_83          varchar(255) NULL,
	PROPERTY_84          varchar(255) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ORG_USER_PROPERTY_OPTION
(
	ID                   bigint AUTO_INCREMENT,
	PROPERTY_ID          bigint NULL,
	NAME                 varchar(20) NULL,
	DESCRIPTION          varchar(500) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_ATTENDANCE
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	ACTIVITY_ID          bigint NULL,
	DESCRIPTION          varchar(1000) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_ATTENDANCE_DETAILS
(
	ID                   bigint AUTO_INCREMENT,
	USER_ID              bigint NULL,
	ATTENDANCE_PROJECT_ID bigint NULL,
	ATTENDANCE_TIME      datetime NULL,
	STATUS               char(1) NULL,
	LATE_TIME            decimal(9) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_ATTENDANCE_PROJECT
(
	ID                   bigint AUTO_INCREMENT,
	ATTENDANCE_ID        bigint NULL,
	ACTIVITY_PROJECT_ID  bigint NULL,
	RECORD_TIME          datetime NULL,
	RECORDER             bigint NULL,
	PROJECT_NAME         varchar(100) NULL,
	DESCRIPTION          varchar(1000) NULL,
	LOCATION             varchar(2000) NULL,
	TRAINING_OBJECT      varchar(1000) NULL,
	TRAINER_ID           bigint NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_EQUIPMENT
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(50) NULL,
	LOCATION             varchar(200) NULL,
	PRICE                decimal(18,2) NULL,
	BUY_TIME             datetime NULL,
	STATUS               char(1) NULL,
	IMAGE_ID             bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_FOLDER
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(100) NULL,
	TYPE                 char(4) NULL,
	DESCRIPTION          varchar(1000) NULL,
	SITE_ID              bigint NULL,
	PARENT_ID            bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	LEVEL_NUMBER         decimal(9) NULL,
	OBJECT_COUNT         bigint NULL,
	FOLDER_COUNT         bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_FOLDER_HIERARCHY
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	HIERARCHY_ID         bigint NOT NULL,
	HIERARCHY_LEVEL      decimal(9) NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_LEARNER_SCORE
(
	ID                   bigint AUTO_INCREMENT,
	SCORE_SHEET_ID       bigint NULL,
	USER_ID              bigint NULL,
	SCORE1               decimal(16,2) NULL,
	SCORE2               decimal(16,2) NULL,
	SCORE3               decimal(16,2) NULL,
	SCORE4               decimal(16,2) NULL,
	SCORE5               decimal(16,2) NULL,
	SCORE6               decimal(16,2) NULL,
	SCORE7               decimal(16,2) NULL,
	SCORE8               decimal(16,2) NULL,
	SCORE9               decimal(16,2) NULL,
	SCORE10              decimal(16,2) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_LOCATION
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(50) NULL,
	LOCATION             varchar(200) NULL,
	STATUS               char(1) NULL,
	IMAGE_ID             bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_SCORE_RELATION
(
	ID                   bigint AUTO_INCREMENT,
	SCORE_SHEET_ID       bigint NULL,
	LEARNER_SCORE_ID     bigint NULL,
	LEARNER_SCORE_COLUMN varchar(10) NULL,
	COLUMN_NAME          varchar(20) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PASS_SCORE           bigint NULL,
	SCORE_PERCENTAGE     decimal(3) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_SCORE_SHEET
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	ACTIVITY_ID          bigint NULL,
	DESCRIPTION          varchar(1000) NULL,
	REMARK               varchar(2000) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PASSSCORE            decimal(16,2) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RES_TRAINER
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	USER_ID              bigint NULL,
	NAME                 varchar(50) NULL,
	AGE                  decimal(4) NULL,
	STAR                 decimal(4) NULL,
	LEVEL_ID             bigint NULL,
	COST_TYPE            char(1) NULL,
	COST                 decimal(18,2) NULL,
	TELEPHONE            varchar(50) NULL,
	EMAIL                varchar(100) NULL,
	ADDRESS              varchar(100) NULL,
	IMAGE_ID             bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	DESCRIPTION          varchar(250) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RPT_FOLDER
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(100) NULL,
	TYPE                 char(4) NULL,
	DESCRIPTION          varchar(1000) NULL,
	SITE_ID              bigint NULL,
	PARENT_ID            bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	LEVEL_NUMBER         decimal(9) NULL,
	OBJECT_COUNT         bigint NULL,
	FOLDER_COUNT         bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE RPT_FOLDER_HIERARCHY
(
	ID                   bigint AUTO_INCREMENT,
	FOLDER_ID            bigint NULL,
	HIERARCHY_ID         bigint NOT NULL,
	HIERARCHY_LEVEL      decimal(9) NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_AUTHORITY
(
	ID                   bigint AUTO_INCREMENT,
	CODE                 varchar(50) NULL,
	NAME                 varchar(100) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_AUTHORITY_REF
(
	OWNER_ID             bigint NOT NULL,
	OWNER_TYPE           char(1) NULL,
	AUTHORITY_ID         bigint NULL
);

CREATE TABLE SYS_BIT_MAPPING
(
	MAPPING_TYPE         char(1) NOT NULL,
	SERIAL_NUMBER        decimal(8) NOT NULL,
	BIT_VALUE            char(31) NULL,
	INT_VALUE            decimal(38) NOT NULL,
	OBJECT_ID            bigint NULL,
	PRIMARY KEY (MAPPING_TYPE,SERIAL_NUMBER,INT_VALUE)
);

CREATE TABLE SYS_BULLETIN
(
	ID                   bigint AUTO_INCREMENT,
	TITLE                varchar(100) NULL,
	CONTENTS             text(65535) NULL,
	OBJECT_TYPE          char(4) NOT NULL,
	OBJECT_ID            bigint NOT NULL,
	START_TIME           datetime NULL,
	END_TIME             datetime NULL,
	STATUS               char(1) NOT NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_ENTITY
(
	ID                   char(18) NULL,
	ENTITY_NAME          char(18) NULL,
	TABLE_NAME           char(18) NULL
);

CREATE TABLE SYS_ENTITY_AUTHORITY
(
	ID                   bigint AUTO_INCREMENT,
	AUTHORITY_NAME       varchar(100) NULL,
	AUTHORITY_VALUE      decimal(32) NULL,
	IS_COMMON            char(1) NULL,
	ENTITY_TYPE          varchar(20) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_ENTITY_AUTHORITY_REF
(
	EA_ID                bigint NOT NULL,
	REF_ID               bigint NOT NULL,
	REF_TYPE             varchar(20) NULL
);

CREATE TABLE SYS_ENTITY_PERMISSION
(
	ENTITY_ID            bigint NOT NULL,
	ENTITY_TYPE          varchar(20) NOT NULL,
	OWNER_TYPE           char(1) NOT NULL,
	OWNER_ID             bigint NOT NULL,
	PERMISSION_VALUE     decimal(38) NULL,
	PRIMARY KEY (ENTITY_ID,ENTITY_TYPE,OWNER_TYPE,OWNER_ID)
);

CREATE TABLE SYS_ENTITY_READ_PERMISSION
(
	ENTITY_ID            bigint NULL,
	ENTITY_TYPE          varchar(20) NULL,
	OWNER_TYPE           char(1) NULL,
	OWNER_0              decimal(38) NULL,
	USER_ID              bigint NULL,
	OWNER_1              decimal(38) NULL,
	OWNER_2              decimal(38) NULL,
	OWNER_3              decimal(38) NULL,
	OWNER_4              decimal(38) NULL,
	OWNER_5              decimal(38) NULL,
	OWNER_6              decimal(38) NULL,
	OWNER_7              decimal(38) NULL,
	OWNER_8              decimal(38) NULL,
	OWNER_9              decimal(38) NULL,
	OWNER_10             decimal(38) NULL,
	OWNER_11             decimal(38) NULL,
	OWNER_12             decimal(38) NULL,
	ID                   BIGINT AUTO_INCREMENT,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_FUNCTION
(
	ID                   bigint AUTO_INCREMENT,
	NAME                 varchar(200) NULL,
	TYPE                 varchar(20) NULL,
	DESCRIPTION          varchar(2000) NULL,
	PARENT_ID            bigint NULL,
	URI                  varchar(200) NULL,
	POSITION             decimal(4) NULL,
	ENABLE               char(1) NULL,
	IS_LEAF              char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_FUNCTION_AUTHORITY
(
	FUNCTION_ID          bigint NULL,
	AUTHORITY_ID         bigint NULL,
	MATCH_PATTERN        varchar(1000) NULL
);

CREATE TABLE SYS_FUNCTION_REF
(
	OWNER_ID             bigint NULL,
	MENU_ID              bigint NULL,
	OWNER_TYPE           char(18) NULL
);

CREATE TABLE SYS_MENU
(
	ID                   bigint AUTO_INCREMENT,
	PARENT_ID            bigint NULL,
	NAME                 varchar(100) NULL,
	TYPE                 varchar(30) NULL,
	URL                  varchar(300) NULL,
	ICON                 varchar(300) NULL,
	ICON_TYPE            char(1) NULL,
	DESCRIPTION          varchar(1000) NULL,
	CODE                 varchar(100) NULL,
	CSS_CLASS            varchar(50) NULL,
	SERIAL_NUMBER        bigint NULL,
	OPEN_MODE            varchar(20) NULL,
	AUTH_ID              bigint NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_NOTICE
(
	ID                   bigint AUTO_INCREMENT,
	NOTICE_TYPE          varchar(10) NULL,
	TITLE                varchar(200) NULL,
	CONTENT              text(65535) NULL,
	STATUS               char(1) NULL,
	SEND_DATE            datetime NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	SUMMARY              varchar(500) NULL,
	SITE_ID              bigint NULL,
	RECEIVERS            varchar(200) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_NOTICE_CONFIG
(
	ID                   bigint AUTO_INCREMENT,
	SITE_ID              bigint NULL,
	NOTICE_TYPE          varchar(20) NULL,
	TITLE                varchar(200) NULL,
	CONTENT              text(65535) NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_NOTICE_SETTING
(
	ID                   bigint AUTO_INCREMENT,
	OBJECT_TYPE          char(4) NULL,
	OBJECT_ID            bigint NULL,
	NOTICE_CONFIG_TYPE   varchar(20) NULL,
	STATUS               char(1) NULL,
	RECEIVERS            varchar(100) NULL,
	SEND_TYPE            varchar(10) NULL,
	SITE_ID              bigint NULL,
	OBJECT_EVENT         varchar(20) NULL,
	RECORD_STATUS        char(1) NOT NULL,
	UPDATE_COUNT         bigint NOT NULL,
	CREATOR_ID           bigint NOT NULL,
	CREATE_DATE          datetime NOT NULL,
	UPDATER_ID           bigint NOT NULL,
	UPDATE_DATE          datetime NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_NOTICE_USERS
(
	ID                   bigint AUTO_INCREMENT,
	NOTICE_ID            bigint NULL,
	USER_ID              bigint NULL,
	STATUS               char(1) NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_PARAMETER
(
	ID                   bigint AUTO_INCREMENT,
	CODE                 varchar(50) NULL,
	NAME                 varchar(50) NULL,
	VALUE                varchar(200) NULL,
	DEFAULT_VALUE        varchar(200) NULL,
	TYPE                 char(1) NULL,
	DESCRIPTION          varchar(255) NULL,
	SCOPE                char(1) NULL,
	SITE_ID              bigint NULL,
	RECORD_STATUS        char(1) NULL,
	UPDATE_COUNT         bigint NULL,
	CREATOR_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATER_ID           bigint NULL,
	UPDATE_DATE          datetime NULL,
	PRIMARY KEY (ID)
);

CREATE UNIQUE INDEX SYS_PARAMETER_UK_CODE ON SYS_PARAMETER
(
	CODE,
	SITE_ID
);

CREATE TABLE SYS_ROLE
(
	ID                   bigint AUTO_INCREMENT,
	SITE_ID              bigint NULL,
	NAME                 varchar(100) NULL,
	DESCRIPTION          varchar(500) NULL,
	RECORD_STATUS        char(1) NULL,
	CREATOR_ID           bigint NULL,
	UPDATER_ID           bigint NULL,
	CREATE_DATE          datetime NULL,
	UPDATE_DATE          datetime NULL,
	UPDATE_COUNT         bigint NULL,
	INHERIT_ABLE         char(1) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SYS_ROLE_REF
(
	ID                   bigint AUTO_INCREMENT,
	OWNER_ID             bigint NULL,
	ROLE_ID              bigint NULL,
	OWNER_TYPE           varchar(500) NULL,
	PRIMARY KEY (ID)
);
