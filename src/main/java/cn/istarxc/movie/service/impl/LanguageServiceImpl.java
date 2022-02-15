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

import cn.istarxc.movie.entity.Language;
import cn.istarxc.movie.repository.LanguageRepository;
import cn.istarxc.movie.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * languages info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:51
 */
@Service("languageService")
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;

    @Override
    public Mono<Language> save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Flux<Language> saveAll(Iterable<Language> languages) {
        return languageRepository.saveAll(languages);
    }

    @Override
    public Mono<Language> findById(Integer id) {
        return languageRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return languageRepository.existsById(id);
    }

    @Override
    public Flux<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Flux<Language> findAllById(Iterable<Integer> ids) {
        return languageRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return languageRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return languageRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Language language) {
        return languageRepository.delete(language);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return languageRepository.deleteAllById(ids);
    }
}
