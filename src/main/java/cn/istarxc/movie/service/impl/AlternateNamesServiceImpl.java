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

import cn.istarxc.movie.entity.AlternateNames;
import cn.istarxc.movie.repository.AlternateNamesRepository;
import cn.istarxc.movie.service.AlternateNamesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * movie alternate names info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:49
 */
@Service("alternateNamesService")
@AllArgsConstructor
public class AlternateNamesServiceImpl implements AlternateNamesService {

    private AlternateNamesRepository alternateNamesRepository;

    @Override
    public Mono<AlternateNames> save(AlternateNames alternateNames) {
        return alternateNamesRepository.save(alternateNames);
    }

    @Override
    public Flux<AlternateNames> saveAll(Iterable<AlternateNames> alternateNames) {
        return alternateNamesRepository.saveAll(alternateNames);
    }

    @Override
    public Mono<AlternateNames> findById(Integer id) {
        return alternateNamesRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return alternateNamesRepository.existsById(id);
    }

    @Override
    public Flux<AlternateNames> findAll() {
        return alternateNamesRepository.findAll();
    }

    @Override
    public Flux<AlternateNames> findAllById(Iterable<Integer> ids) {
        return alternateNamesRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return alternateNamesRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return alternateNamesRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(AlternateNames alternateNames) {
        return alternateNamesRepository.delete(alternateNames);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return alternateNamesRepository.deleteAllById(ids);
    }
}
