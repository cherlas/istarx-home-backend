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

import cn.istarxc.movie.entity.Screenwriter;
import cn.istarxc.movie.repository.ScreenwriterRepository;
import cn.istarxc.movie.service.ScreenwriterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * screenwriters info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:56
 */
@Service("screenwriterService")
@AllArgsConstructor
public class ScreenwriterServiceImpl implements ScreenwriterService {

    private ScreenwriterRepository screenwriterRepository;

    @Override
    public Mono<Screenwriter> save(Screenwriter screenwriter) {
        return screenwriterRepository.save(screenwriter);
    }

    @Override
    public Flux<Screenwriter> saveAll(Iterable<Screenwriter> screenwriters) {
        return screenwriterRepository.saveAll(screenwriters);
    }

    @Override
    public Mono<Screenwriter> findById(Integer id) {
        return screenwriterRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return screenwriterRepository.existsById(id);
    }

    @Override
    public Flux<Screenwriter> findAll() {
        return screenwriterRepository.findAll();
    }

    @Override
    public Flux<Screenwriter> findAllById(Iterable<Integer> ids) {
        return screenwriterRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return screenwriterRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return screenwriterRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Screenwriter screenwriter) {
        return screenwriterRepository.delete(screenwriter);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return screenwriterRepository.deleteAllById(ids);
    }
}
