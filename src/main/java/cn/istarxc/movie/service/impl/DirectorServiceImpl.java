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

import cn.istarxc.movie.entity.Director;
import cn.istarxc.movie.repository.DirectorRepository;
import cn.istarxc.movie.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * directors info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:49
 */
@Service("directorService")
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directorRepository;

    @Override
    public Mono<Director> save(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Flux<Director> saveAll(Iterable<Director> directors) {
        return directorRepository.saveAll(directors);
    }

    @Override
    public Mono<Director> findById(Integer id) {
        return directorRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return directorRepository.existsById(id);
    }

    @Override
    public Flux<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    public Flux<Director> findAllById(Iterable<Integer> ids) {
        return directorRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return directorRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return directorRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Director director) {
        return directorRepository.delete(director);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return directorRepository.deleteAllById(ids);
    }
}
