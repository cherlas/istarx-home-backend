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

import cn.istarxc.movie.entity.MovieDirector;
import cn.istarxc.movie.repository.MovieDirectorRepository;
import cn.istarxc.movie.service.MovieDirectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between directors and movies service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:53
 */
@Service("movieDirectorService")
@AllArgsConstructor
public class MovieDirectorServiceImpl implements MovieDirectorService {

    private MovieDirectorRepository movieDirectorRepository;

    @Override
    public Mono<MovieDirector> save(MovieDirector movieDirector) {
        return movieDirectorRepository.save(movieDirector);
    }

    @Override
    public Flux<MovieDirector> saveAll(Iterable<MovieDirector> movieDirectors) {
        return movieDirectorRepository.saveAll(movieDirectors);
    }

    @Override
    public Mono<MovieDirector> findById(Integer id) {
        return movieDirectorRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieDirectorRepository.existsById(id);
    }

    @Override
    public Flux<MovieDirector> findAll() {
        return movieDirectorRepository.findAll();
    }

    @Override
    public Flux<MovieDirector> findAllById(Iterable<Integer> ids) {
        return movieDirectorRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieDirectorRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieDirectorRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(MovieDirector movieDirector) {
        return movieDirectorRepository.delete(movieDirector);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieDirectorRepository.deleteAllById(ids);
    }
}
