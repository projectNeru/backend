CREATE TABLE `gratitude_analysis` (
	`id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`week_start`	DATE	NOT NULL,
	`top_person`	JSON	NOT NULL,
	`top_action`	JSON	NOT NULL
);

CREATE TABLE `emotion_category` (
	`id`	BIGINT	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `emotion_analysis` (
	`id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`week_start`	DATE	NOT NULL,
	`radar`	TEXT	NULL,
	`top_detail`	JSON	NULL,
	`top_keywords`	JSON	NULL,
	`wordcloud`	JSON	NULL
);

CREATE TABLE `gratitude` (
	`id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`date`	DATE	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`thankful_1`	TEXT	NOT NULL,
	`thankful_2`	TEXT	NOT NULL,
	`thankful_3`	TEXT	NOT NULL,
	`good_1`	TEXT	NOT NULL,
	`good_2`	TEXT	NOT NULL,
	`good_3`	TEXT	NOT NULL,
	`ai_reply`	BOOLEAN	NOT NULL	DEFAULT false,
	`update_at`	DATETIME	NULL
);

CREATE TABLE `emotion_detail` (
	`id`	BIGINT	NOT NULL,
	`category_id`	VARCHAR(255)	NOT NULL,
	`name`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `user` (
	`id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`kakao_id`	BIGINT	NOT NULL	COMMENT 'UNIQUE',
	`nickname`	VARCHAR(50)	NOT NULL,
	`profile_image`	VARCHAR(255)	NULL,
	`email`	VARCHAR(100)	NULL	COMMENT 'UNIQUE',
	`status`	ENUM('ACTIVE', 'INACTIVE')	NULL	DEFAULT 'ACTIVE',
	`deleted_at`	TIMESTAMP	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `emotion_keyword_ranking` (
	`id`	BIGINT	NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`week_start`	DATE	NOT NULL,
	`keyword`	VARCHAR(100)	NOT NULL,
	`count`	INT	NOT NULL,
	`rank`	INT	NOT NULL,
	`keyword_type`	ENUM('WORD', 'SITUATION')	NOT NULL
);

CREATE TABLE `ai_reply` (
	`id`	BIGINT	NOT NULL,
	`diary_type`	ENUM('GRATITUDE', 'EMOTION')	NOT NULL,
	`diary_id`	BIGINT	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL
);

CREATE TABLE `session` (
	`id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`user_id`	BIGINT	NOT NULL	COMMENT 'ON DELETE CASCADE',
	`access_token`	VARCHAR(255)	NOT NULL,
	`expires_at`	TIMESTAMP	NOT NULL,
	`created_at`	TIMESTAMP	NULL	DEFAULT DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `emotion` (
	`id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`date`	DATE	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`intensity`	INT	NOT NULL,
	`case`	TEXT	NOT NULL,
	`think`	TEXT	NOT NULL,
	`ai_reply`	BOOLEAN	NOT NULL	DEFAULT false,
	`emotion_category`	VARCHAR(100)	NOT NULL,
	`emotion_detail`	VARCHAR(100)	NOT NULL,
	`updated_at`	DATETIME	NULL
);

CREATE TABLE `gratitude_keyword_ranking` (
	`id`	BIGINT	NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`week_start`	DATE	NOT NULL,
	`keyword`	VARCHAR(100)	NOT NULL,
	`keyword_type`	ENUM('ACTION', 'PERSON')	NOT NULL,
	`rank`	INT	NOT NULL,
	`count`	INT	NOT NULL
);

CREATE TABLE `diary_attendance` (
	`id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`diary_type`	ENUM('EMOTION', 'GRATITUDE')	NOT NULL,
	`year`	INT	NOT NULL,
	`month`	INT	NOT NULL,
	`attended_days`	INT	NOT NULL,
	`total_days`	INT	NOT NULL,
	`attendance_rate`	DECIMAL(5,2)	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL
);

ALTER TABLE `gratitude_analysis` ADD CONSTRAINT `PK_GRATITUDE_ANALYSIS` PRIMARY KEY (
	`id`
);

ALTER TABLE `emotion_category` ADD CONSTRAINT `PK_EMOTION_CATEGORY` PRIMARY KEY (
	`id`
);

ALTER TABLE `emotion_analysis` ADD CONSTRAINT `PK_EMOTION_ANALYSIS` PRIMARY KEY (
	`id`
);

ALTER TABLE `gratitude` ADD CONSTRAINT `PK_GRATITUDE` PRIMARY KEY (
	`id`
);

ALTER TABLE `emotion_detail` ADD CONSTRAINT `PK_EMOTION_DETAIL` PRIMARY KEY (
	`id`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`id`
);

ALTER TABLE `emotion_keyword_ranking` ADD CONSTRAINT `PK_EMOTION_KEYWORD_RANKING` PRIMARY KEY (
	`id`
);

ALTER TABLE `ai_reply` ADD CONSTRAINT `PK_AI_REPLY` PRIMARY KEY (
	`id`
);

ALTER TABLE `session` ADD CONSTRAINT `PK_SESSION` PRIMARY KEY (
	`id`
);

ALTER TABLE `emotion` ADD CONSTRAINT `PK_EMOTION` PRIMARY KEY (
	`id`
);

ALTER TABLE `gratitude_keyword_ranking` ADD CONSTRAINT `PK_GRATITUDE_KEYWORD_RANKING` PRIMARY KEY (
	`id`
);

ALTER TABLE `diary_attendance` ADD CONSTRAINT `PK_DIARY_ATTENDANCE` PRIMARY KEY (
	`id`,
	`user_id`
);

