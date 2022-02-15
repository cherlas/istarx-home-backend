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

import cn.istarxc.movie.entity.Movie;
import cn.istarxc.movie.repository.MovieRepository;
import cn.istarxc.movie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * movies info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:51
 */
@Service("movieService")
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public Mono<Movie> save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Flux<Movie> saveAll(Iterable<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    @Override
    public Mono<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieRepository.existsById(id);
    }

    @Override
    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<Movie> findAllById(Iterable<Integer> ids) {
        return movieRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Movie movie) {
        return movieRepository.delete(movie);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieRepository.deleteAllById(ids);
    }
}
