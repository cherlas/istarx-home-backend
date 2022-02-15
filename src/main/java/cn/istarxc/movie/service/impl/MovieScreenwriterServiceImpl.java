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

import cn.istarxc.movie.entity.MovieScreenwriter;
import cn.istarxc.movie.repository.MovieScreenwriterRepository;
import cn.istarxc.movie.service.MovieScreenwriterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between screenwriters and movies service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:55
 */
@Service("movieScreenwriterService")
@AllArgsConstructor
public class MovieScreenwriterServiceImpl implements MovieScreenwriterService {

    private MovieScreenwriterRepository movieScreenwriterRepository;

    @Override
    public Mono<MovieScreenwriter> save(MovieScreenwriter movieScreenwriter) {
        return movieScreenwriterRepository.save(movieScreenwriter);
    }

    @Override
    public Flux<MovieScreenwriter> saveAll(Iterable<MovieScreenwriter> movieScreenwriters) {
        return movieScreenwriterRepository.saveAll(movieScreenwriters);
    }

    @Override
    public Mono<MovieScreenwriter> findById(Integer id) {
        return movieScreenwriterRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieScreenwriterRepository.existsById(id);
    }

    @Override
    public Flux<MovieScreenwriter> findAll() {
        return movieScreenwriterRepository.findAll();
    }

    @Override
    public Flux<MovieScreenwriter> findAllById(Iterable<Integer> ids) {
        return movieScreenwriterRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieScreenwriterRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieScreenwriterRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(MovieScreenwriter movieScreenwriter) {
        return movieScreenwriterRepository.delete(movieScreenwriter);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieScreenwriterRepository.deleteAllById(ids);
    }
}
