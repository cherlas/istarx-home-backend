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
package cn.istarxc.movie.service.impl;

import cn.istarxc.movie.entity.MovieLabel;
import cn.istarxc.movie.repository.MovieLabelRepository;
import cn.istarxc.movie.service.MovieLabelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between labels and movies service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:54
 */
@Service("movieLabelService")
@AllArgsConstructor
public class MovieLabelServiceImpl implements MovieLabelService {

    private MovieLabelRepository movieLabelRepository;

    @Override
    public Mono<MovieLabel> save(MovieLabel movieLabel) {
        return movieLabelRepository.save(movieLabel);
    }

    @Override
    public Flux<MovieLabel> saveAll(Iterable<MovieLabel> movieLabels) {
        return movieLabelRepository.saveAll(movieLabels);
    }

    @Override
    public Mono<MovieLabel> findById(Integer id) {
        return movieLabelRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieLabelRepository.existsById(id);
    }

    @Override
    public Flux<MovieLabel> findAll() {
        return movieLabelRepository.findAll();
    }

    @Override
    public Flux<MovieLabel> findAllById(Iterable<Integer> ids) {
        return movieLabelRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieLabelRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieLabelRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(MovieLabel movieLabel) {
        return movieLabelRepository.delete(movieLabel);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieLabelRepository.deleteAllById(ids);
    }
}
