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

import cn.istarxc.movie.entity.Label;
import cn.istarxc.movie.repository.LabelRepository;
import cn.istarxc.movie.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * labels info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:50
 */
@Service("labelService")
@AllArgsConstructor
public class LabelServiceImpl implements LabelService {

    private LabelRepository labelRepository;

    @Override
    public Mono<Label> save(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Flux<Label> saveAll(Iterable<Label> labels) {
        return labelRepository.saveAll(labels);
    }

    @Override
    public Mono<Label> findById(Integer id) {
        return labelRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return labelRepository.existsById(id);
    }

    @Override
    public Flux<Label> findAll() {
        return labelRepository.findAll();
    }

    @Override
    public Flux<Label> findAllById(Iterable<Integer> ids) {
        return labelRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return labelRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return labelRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Label label) {
        return labelRepository.delete(label);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return labelRepository.deleteAllById(ids);
    }
}
