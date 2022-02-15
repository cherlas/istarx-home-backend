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

import cn.istarxc.movie.entity.MovieActor;
import cn.istarxc.movie.repository.MovieActorRepository;
import cn.istarxc.movie.service.MovieActorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between movies and actors service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:52
 */
@Service("movieActorService")
@AllArgsConstructor
public class MovieActorServiceImpl implements MovieActorService {

    private MovieActorRepository movieActorRepository;

    @Override
    public Mono<MovieActor> save(MovieActor movieActor) {
        return movieActorRepository.save(movieActor);
    }

    @Override
    public Flux<MovieActor> saveAll(Iterable<MovieActor> movieActors) {
        return movieActorRepository.saveAll(movieActors);
    }

    @Override
    public Mono<MovieActor> findById(Integer id) {
        return movieActorRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieActorRepository.existsById(id);
    }

    @Override
    public Flux<MovieActor> findAll() {
        return movieActorRepository.findAll();
    }

    @Override
    public Flux<MovieActor> findAllById(Iterable<Integer> ids) {
        return movieActorRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieActorRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieActorRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(MovieActor movieActor) {
        return movieActorRepository.delete(movieActor);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieActorRepository.deleteAllById(ids);
    }
}
