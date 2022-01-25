create database if not exists `istarx-home`;

use `istarx-home`;

CREATE TABLE IF NOT EXISTS `t_movie`
(
    `id`           varchar(32)  NOT NULL COMMENT 'movie id',
    `name`         varchar(50)  NOT NULL COMMENT 'movie name',
    `description`  varchar(500) NOT NULL COMMENT 'movie introduction',
    `release_time` date                  DEFAULT NULL COMMENT 'release date',
    `duration`     int          NOT NULL COMMENT 'movie duration',
    `score`        int                   DEFAULT NULL COMMENT 'movie rating',
    `view_method`  varchar(20)           DEFAULT NULL COMMENT 'how to watch',
    `imdb_id`      varchar(15)           DEFAULT NULL COMMENT 'imdb id',
    `douban_id`    varchar(15)           DEFAULT NULL COMMENT 'douban ID',
    `category`     int          NOT NULL COMMENT 'category：movie/TV series/cartoon/documentary etc',
    `watch_date`   datetime              DEFAULT NULL COMMENT 'watch time',
    `cinema_id`    varchar(32)           DEFAULT NULL COMMENT 'cinema id',
    `created_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation time',
    `updated_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_movie_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='movies info';

CREATE TABLE IF NOT EXISTS `t_images`
(
    `id`           varchar(32)  NOT NULL,
    `key_id`       varchar(32)  NOT NULL COMMENT 'actor/movie/role/writer id',
    `url`          varchar(100) NOT NULL COMMENT 'image url',
    `file_name`    varchar(128)          DEFAULT NULL COMMENT 'file name',
    `created_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_images_key_id_index` (`key_id`, `url`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='poster and avatar images';

CREATE TABLE IF NOT EXISTS `t_actor`
(
    `id`               varchar(32) NOT NULL COMMENT 'actor id',
    `name`             varchar(50) NOT NULL COMMENT 'name',
    `sex`              enum ('F','M','U')   DEFAULT NULL COMMENT 'sex',
    `brith_day`        date                 DEFAULT NULL COMMENT 'birth day',
    `height`           int                  DEFAULT NULL COMMENT 'height',
    `zodiac`           char(6)              DEFAULT NULL COMMENT 'zodiac',
    `country_id`       varchar(32)          DEFAULT NULL COMMENT 'country id',
    `home_town`        varchar(20)          DEFAULT NULL COMMENT 'home town',
    `official_website` varchar(100)         DEFAULT NULL COMMENT 'official website',
    `created_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_actor_name_index` (`name`),
    KEY `t_actor_country_index` (`country_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='actors info';

CREATE TABLE IF NOT EXISTS `t_movie_actor`
(
    `id`           varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`     varchar(32) NOT NULL COMMENT 'movie id',
    `actor_id`     varchar(32) NOT NULL COMMENT 'actor id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_movie_actor_index` (`movie_id`, `actor_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='relationship between movies and actors';

CREATE TABLE IF NOT EXISTS `t_role`
(
    `id`           varchar(32) NOT NULL COMMENT 'role id',
    `name`         varchar(50) NOT NULL COMMENT 'name',
    `movie_id`     varchar(32) NOT NULL COMMENT 'movie id',
    `actor_id`     varchar(32) NOT NULL COMMENT 'actor id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_role_name_index` (`name`),
    KEY `t_role_movie_id_index` (`movie_id`, `actor_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='movie roles info';

CREATE TABLE IF NOT EXISTS `t_alternate_names`
(
    `id`             varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`       varchar(32) NOT NULL COMMENT 'movie id',
    `alternate_name` varchar(50) NOT NULL COMMENT 'alternate name',
    `created_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_alternate_names_alternate_name_index` (`movie_id`, `alternate_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='movie alternate names info';

CREATE TABLE IF NOT EXISTS `t_country`
(
    `id`           varchar(32) NOT NULL COMMENT 'country id',
    `name`         varchar(20) NOT NULL COMMENT 'country name',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_country_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='countries info';

CREATE TABLE IF NOT EXISTS `t_movie_country`
(
    `id`           varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`     varchar(32) NOT NULL COMMENT 'movie id',
    `country_id`   varchar(32) NOT NULL COMMENT 'country id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`country_id`),
    KEY `t_movie_country_country_id_index` (`movie_id`, `country_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='relationship between movie and country';

CREATE TABLE IF NOT EXISTS `t_director`
(
    `id`               varchar(32) NOT NULL COMMENT 'director id',
    `name`             varchar(50) NOT NULL COMMENT 'name',
    `sex`              enum ('F','M','U')   DEFAULT NULL COMMENT 'sex',
    `brith_day`        date                 DEFAULT NULL COMMENT 'birth day',
    `height`           int                  DEFAULT NULL COMMENT 'height',
    `zodiac`           char(6)              DEFAULT NULL COMMENT 'zodiac',
    `country_id`       varchar(32)          DEFAULT NULL COMMENT 'country id',
    `home_town`        varchar(20)          DEFAULT NULL COMMENT 'home town',
    `official_website` varchar(100)         DEFAULT NULL COMMENT 'official website',
    `created_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_director_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='directors info';

CREATE TABLE IF NOT EXISTS `t_movie_director`
(
    `id`           varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`     varchar(32) NOT NULL COMMENT 'movie id',
    `director_id`  varchar(32) NOT NULL COMMENT 'director id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_movie_director_director_id_index` (`movie_id`, `director_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='relationship between directors and movies';

CREATE TABLE IF NOT EXISTS `t_label`
(
    `id`           varchar(32) NOT NULL COMMENT 'label id',
    `name`         varchar(50) NOT NULL COMMENT 'label name',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_label_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='labels info';

CREATE TABLE IF NOT EXISTS `t_movie_label`
(
    `id`           varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`     varchar(32) NOT NULL COMMENT 'movie id',
    `label_id`     varchar(32) NOT NULL COMMENT 'label id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_movie_label_label_id_index` (`movie_id`, `label_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='relationship between labels and movies';

CREATE TABLE IF NOT EXISTS `t_language`
(
    `id`           varchar(32) NOT NULL COMMENT 'language id',
    `name`         varchar(50) NOT NULL COMMENT 'language name',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_language_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='languages info';

CREATE TABLE IF NOT EXISTS `t_movie_language`
(
    `id`           varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`     varchar(32) NOT NULL COMMENT 'movie id',
    `language_id`  varchar(32) NOT NULL COMMENT 'language id',
    `created_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_movie_language_language_id_index` (`language_id`),
    KEY `t_movie_language_movie_id_index` (`movie_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='relationship between languages and movies';

CREATE TABLE IF NOT EXISTS `t_screenwriter`
(
    `id`               varchar(32) NOT NULL COMMENT 'screenwriter id',
    `name`             varchar(50) NOT NULL COMMENT 'name',
    `sex`              enum ('F','M','U')   DEFAULT NULL COMMENT 'sex',
    `brith_day`        date                 DEFAULT NULL COMMENT 'brith day',
    `height`           int                  DEFAULT NULL COMMENT 'height',
    `zodiac`           char(6)              DEFAULT NULL COMMENT 'zodiac',
    `country_id`       varchar(32)          DEFAULT NULL COMMENT 'country id',
    `home_town`        varchar(20)          DEFAULT NULL COMMENT 'home town',
    `official_website` varchar(100)         DEFAULT NULL COMMENT 'official website',
    `created_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_screenwriter_name_index` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='screenwriters info';

CREATE TABLE IF NOT EXISTS `t_movie_screenwriter`
(
    `id`              varchar(32) NOT NULL COMMENT 'primary id',
    `movie_id`        varchar(32) NOT NULL COMMENT 'movie id',
    `screenwriter_id` varchar(32) NOT NULL COMMENT 'screenwriter id',
    `created_time`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation date',
    `updated_time`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'last update time',
    PRIMARY KEY (`id`),
    KEY `t_movie_screenwriter_id_index` (`movie_id`, `screenwriter_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='relationship between screenwriters and movies';