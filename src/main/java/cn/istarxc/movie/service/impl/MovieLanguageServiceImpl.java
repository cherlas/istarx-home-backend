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

import cn.istarxc.movie.entity.MovieLanguage;
import cn.istarxc.movie.repository.MovieLanguageRepository;
import cn.istarxc.movie.service.MovieLanguageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between languages and movies service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:55
 */
@Service("movieLanguageService")
@AllArgsConstructor
public class MovieLanguageServiceImpl implements MovieLanguageService {

    private MovieLanguageRepository movieLanguageRepository;

    @Override
    public Mono<MovieLanguage> save(MovieLanguage movieLanguage) {
        return movieLanguageRepository.save(movieLanguage);
    }

    @Override
    public Flux<MovieLanguage> saveAll(Iterable<MovieLanguage> movieLanguages) {
        return movieLanguageRepository.saveAll(movieLanguages);
    }

    @Override
    public Mono<MovieLanguage> findById(Integer id) {
        return movieLanguageRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieLanguageRepository.existsById(id);
    }

    @Override
    public Flux<MovieLanguage> findAll() {
        return movieLanguageRepository.findAll();
    }

    @Override
    public Flux<MovieLanguage> findAllById(Iterable<Integer> ids) {
        return movieLanguageRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieLanguageRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieLanguageRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(MovieLanguage movieLanguage) {
        return movieLanguageRepository.delete(movieLanguage);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieLanguageRepository.deleteAllById(ids);
    }
}
