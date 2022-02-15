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

import cn.istarxc.movie.entity.Country;
import cn.istarxc.movie.repository.CountryRepository;
import cn.istarxc.movie.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * countries info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:49
 */
@Service("countryService")
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Override
    public Mono<Country> save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Flux<Country> saveAll(Iterable<Country> countrys) {
        return countryRepository.saveAll(countrys);
    }

    @Override
    public Mono<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return countryRepository.existsById(id);
    }

    @Override
    public Flux<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Flux<Country> findAllById(Iterable<Integer> ids) {
        return countryRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return countryRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return countryRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Country country) {
        return countryRepository.delete(country);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return countryRepository.deleteAllById(ids);
    }
}
