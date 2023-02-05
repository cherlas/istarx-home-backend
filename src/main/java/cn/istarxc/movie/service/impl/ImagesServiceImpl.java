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

import cn.istarxc.movie.entity.Images;
import cn.istarxc.movie.repository.ImagesRepository;
import cn.istarxc.movie.service.ImagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * poster and avatar images service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:50
 */
@Service("imagesService")
@AllArgsConstructor
public class ImagesServiceImpl implements ImagesService {

    private ImagesRepository imagesRepository;

    @Override
    public Mono<Images> save(Images images) {
        return imagesRepository.save(images);
    }

    @Override
    public Flux<Images> saveAll(Iterable<Images> images) {
        return imagesRepository.saveAll(images);
    }

    @Override
    public Mono<Images> findById(Integer id) {
        return imagesRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return imagesRepository.existsById(id);
    }

    @Override
    public Flux<Images> findAll() {
        return imagesRepository.findAll();
    }

    @Override
    public Flux<Images> findAllById(Iterable<Integer> ids) {
        return imagesRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return imagesRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return imagesRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Images images) {
        return imagesRepository.delete(images);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return imagesRepository.deleteAllById(ids);
    }
}
