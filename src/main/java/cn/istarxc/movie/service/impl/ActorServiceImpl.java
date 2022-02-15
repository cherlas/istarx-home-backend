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

import cn.istarxc.movie.entity.Actor;
import cn.istarxc.movie.repository.ActorRepository;
import cn.istarxc.movie.service.ActorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * actors info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:48
 */
@Service("actorService")
@AllArgsConstructor
@Slf4j
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    @Override
    public Mono<Actor> save(Actor actor) {
        log.info("save, input param = {}", actor);
        return actorRepository.save(actor);
    }

    @Override
    public Flux<Actor> saveAll(Iterable<Actor> actors) {
        return actorRepository.saveAll(actors);
    }

    @Override
    public Mono<Actor> findById(Integer id) {
        return actorRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return actorRepository.existsById(id);
    }

    @Override
    public Flux<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Flux<Actor> findAllById(Iterable<Integer> ids) {
        return actorRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return actorRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return actorRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Actor actor) {
        return actorRepository.delete(actor);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return actorRepository.deleteAllById(ids);
    }
}
