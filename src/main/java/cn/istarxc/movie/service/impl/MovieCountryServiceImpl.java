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

import cn.istarxc.movie.entity.MovieCountry;
import cn.istarxc.movie.repository.MovieCountryRepository;
import cn.istarxc.movie.service.MovieCountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between movie and country service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:52
 */
@Service("movieCountryService")
@AllArgsConstructor
public class MovieCountryServiceImpl implements MovieCountryService {

    private MovieCountryRepository movieCountryRepository;

    @Override
    public Mono<MovieCountry> save(MovieCountry movieCountry) {
        return movieCountryRepository.save(movieCountry);
    }

    @Override
    public Flux<MovieCountry> saveAll(Iterable<MovieCountry> movieCountries) {
        return movieCountryRepository.saveAll(movieCountries);
    }

    @Override
    public Mono<MovieCountry> findById(Integer id) {
        return movieCountryRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return movieCountryRepository.existsById(id);
    }

    @Override
    public Flux<MovieCountry> findAll() {
        return movieCountryRepository.findAll();
    }

    @Override
    public Flux<MovieCountry> findAllById(Iterable<Integer> ids) {
        return movieCountryRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return movieCountryRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return movieCountryRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(MovieCountry movieCountry) {
        return movieCountryRepository.delete(movieCountry);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieCountryRepository.deleteAllById(ids);
    }
}
