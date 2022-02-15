/*
 * Copyright 2016-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.istarxc.movie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * movies info Entity
 *
 * @author Cherlas
 * @since 2022-02-07 22:16:49
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "t_movie")
public class Movie implements Persistable<Integer>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * movie id
     */
    @Id
    private Integer id;

    /**
     * movie name
     */
    private String name;

    /**
     * movie introduction
     */
    private String description;

    /**
     * release date
     */
    private Date releaseTime;

    /**
     * movie duration
     */
    private Integer duration;

    /**
     * movie rating
     */
    private Integer score;

    /**
     * how to watch
     */
    private String viewMethod;

    /**
     * imdb id
     */
    private String imdbId;

    /**
     * douban ID
     */
    private String doubanId;

    /**
     * category：movie/TV series/cartoon/documentary etc
     */
    private Integer category;

    /**
     * watch time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime watchDate;

    /**
     * cinema id
     */
    private String cinemaId;

    /**
     * creation time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdTime;

    /**
     * last update time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedTime;

    @Override
    public boolean isNew() {
        return id == null || id <= 0;
    }
}

