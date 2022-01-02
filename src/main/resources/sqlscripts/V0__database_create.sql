create database if not exists `istarx-home`;

use `istarx-home`;

CREATE TABLE `t_actor`
(
    `id`           varchar(32) NOT NULL COMMENT '演员id',
    `name`         varchar(50) NOT NULL COMMENT '姓名',
    `sex`          enum ('F','M','U')   DEFAULT NULL COMMENT '性别',
    `brith_day`    date                 DEFAULT NULL COMMENT '出生日期',
    `height`       int                  DEFAULT NULL COMMENT '身高',
    `zodiac`       char(6)              DEFAULT NULL COMMENT '星座',
    `country`      varchar(10)          DEFAULT NULL COMMENT '国家',
    `home_town`    varchar(20)          DEFAULT NULL COMMENT '籍贯',
    `url`          varchar(100)         DEFAULT NULL COMMENT '官方网站',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_actor_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='演员表';

CREATE TABLE `t_alternate_name`
(
    `id`             varchar(32) NOT NULL COMMENT '主键',
    `movie_id`       varchar(32) NOT NULL COMMENT '电影id',
    `alternate_name` varchar(50) NOT NULL COMMENT '又名',
    `created_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_alternate_name_alternate_name_index` (`alternate_name`),
    KEY `t_alternate_name_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影多名称表';

CREATE TABLE `t_country`
(
    `id`           varchar(32) NOT NULL COMMENT '国家id',
    `name`         varchar(20) NOT NULL COMMENT '国家名称',
    `create_time`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_country_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='国家';

CREATE TABLE `t_country`
(
    `id`           varchar(32) NOT NULL COMMENT '国家id',
    `name`         varchar(20) NOT NULL COMMENT '国家名称',
    `create_time`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_country_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='国家';

CREATE TABLE `t_label`
(
    `id`           varchar(32) NOT NULL COMMENT '标签 id',
    `name`         varchar(50) NOT NULL COMMENT '标签名称',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_label_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='标签表';

CREATE TABLE `t_language`
(
    `id`           varchar(32) NOT NULL COMMENT '语言 id',
    `name`         varchar(50) NOT NULL COMMENT '语言名称',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_language_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='语言表';


CREATE TABLE `t_movie`
(
    `id`           varchar(32) NOT NULL COMMENT '电影 ID',
    `name`         varchar(50) NOT NULL COMMENT '电影名称',
    `release_time` date                 DEFAULT NULL COMMENT '上映日期',
    `duration`     int         NOT NULL COMMENT '电影时长',
    `score`        int                  DEFAULT NULL COMMENT '电影评分',
    `view_method`  varchar(20)          DEFAULT NULL COMMENT '观看方式',
    `imdb_id`      varchar(10)          DEFAULT NULL COMMENT 'IMDB ID',
    `category`     int         NOT NULL COMMENT '分类：电影/电视剧/动漫 etc',
    `watch_date`   datetime             DEFAULT NULL COMMENT '观看时间',
    `cinema_id`    varchar(32)          DEFAULT NULL COMMENT '观看电影院 id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    KEY `t_movie_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影表';

CREATE TABLE `t_movie_actor`
(
    `id`       varchar(32) NOT NULL COMMENT '主键 id',
    `movie_id` varchar(32) NOT NULL COMMENT '电影 id',
    `actor_id` varchar(32) NOT NULL COMMENT '演员 id',
    PRIMARY KEY (`id`),
    KEY `t_movie_actor_actor_id_index` (`actor_id`),
    KEY `t_movie_actor_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影演员表';

CREATE TABLE `t_movie_country`
(
    `id`         varchar(32) NOT NULL COMMENT '主键',
    `movie_id`   varchar(32) NOT NULL COMMENT '电影id',
    `country_id` varchar(32) NOT NULL COMMENT '国家id',
    PRIMARY KEY (`country_id`),
    KEY `t_movie_country_country_id_index` (`country_id`),
    KEY `t_movie_country_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影国家';

CREATE TABLE `t_movie_director`
(
    `id`          varchar(32) NOT NULL COMMENT '主键 id',
    `movie_id`    varchar(32) NOT NULL COMMENT '电影 id',
    `director_id` varchar(32) NOT NULL COMMENT '导演 id',
    PRIMARY KEY (`id`),
    KEY `t_movie_director_director_id_index` (`director_id`),
    KEY `t_movie_director_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影导演表';

CREATE TABLE `t_movie_images`
(
    `id`        varchar(32)  NOT NULL,
    `key_id`    varchar(32)  NOT NULL COMMENT '演员/电影/角色/编剧 id等',
    `url`       varchar(100) NOT NULL COMMENT '图片url',
    `file_name` varchar(128) DEFAULT NULL COMMENT '文件名',
    PRIMARY KEY (`id`),
    UNIQUE KEY `t_movie_images_pk` (`key_id`),
    KEY `t_images_key_id_index` (`key_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='缩略图和头像';

CREATE TABLE `t_movie_label`
(
    `id`       varchar(32) NOT NULL COMMENT '主键 id',
    `movie_id` varchar(32) NOT NULL COMMENT '电影 id',
    `label_id` varchar(32) NOT NULL COMMENT '标签 id',
    PRIMARY KEY (`id`),
    KEY `t_movie_label_label_id_index` (`label_id`),
    KEY `t_movie_label_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影标签表';

CREATE TABLE `t_movie_language`
(
    `id`          varchar(32) NOT NULL COMMENT '主键 id',
    `movie_id`    varchar(32) NOT NULL COMMENT '电影 id',
    `language_id` varchar(32) NOT NULL COMMENT '标签 id',
    PRIMARY KEY (`id`),
    KEY `t_movie_language_language_id_index` (`language_id`),
    KEY `t_movie_language_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影语言表';

CREATE TABLE `t_movie_screenwriter`
(
    `id`              varchar(32) NOT NULL COMMENT '主键 id',
    `movie_id`        varchar(32) NOT NULL COMMENT '电影 id',
    `screenwriter_id` varchar(32) NOT NULL COMMENT '编剧 id',
    PRIMARY KEY (`id`),
    KEY `t_movie_screenwriter_id_index` (`screenwriter_id`),
    KEY `t_movie_screenwriter_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影编剧表';

CREATE TABLE `t_role`
(
    `id`           varchar(32) NOT NULL COMMENT '演员id',
    `name`         varchar(50) NOT NULL COMMENT '姓名',
    `movie_id`     varchar(32) NOT NULL COMMENT '电影id',
    `actor_id`     varchar(32) NOT NULL COMMENT '演员id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_role_name_index` (`name`),
    KEY `t_role_movie_id_index` (`movie_id`),
    KEY `t_role_actor_id_index` (`actor_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色表';

CREATE TABLE `t_screenwriter`
(
    `id`           varchar(32) NOT NULL COMMENT '编剧id',
    `name`         varchar(50) NOT NULL COMMENT '姓名',
    `sex`          enum ('F','M','U')   DEFAULT NULL COMMENT '性别',
    `brith_day`    date                 DEFAULT NULL COMMENT '出生日期',
    `height`       int                  DEFAULT NULL COMMENT '身高',
    `zodiac`       char(6)              DEFAULT NULL COMMENT '星座',
    `country`      varchar(10)          DEFAULT NULL COMMENT '国家',
    `home_town`    varchar(20)          DEFAULT NULL COMMENT '籍贯',
    `url`          varchar(100)         DEFAULT NULL COMMENT '官方网站',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `t_screenwriter_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='编剧表';