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
package cn.istarxc.movie.controller;

import cn.istarxc.movie.entity.Country;
import cn.istarxc.movie.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * countries info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:49
 */
@RestController
@RequestMapping("country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    /**
     * Saves a country and returned the saved instance.
     *
     * @param country must not be {@literal null}.
     * @return the saved country.
     */
    @PostMapping("entity")
    Mono<Country> save(@RequestBody Country country) {
        return countryService.save(country);
    }

    /**
     * Saves all given countries.
     *
     * @param countries must not be {@literal null}.
     * @return the saved countries.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Country> saveAll(@RequestBody Iterable<Country> countries) {
        return countryService.saveAll(countries);
    }

    /**
     * Retrieves a country by its id.
     *
     * @param id must not be {@literal null}.
     * @return the country with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Country> findById(@PathVariable("id") Integer id) {
        return countryService.findById(id);
    }

    /**
     * Returns whether a country with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if a country with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return countryService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all countries.
     */
    @GetMapping("all")
    Flux<Country> findAll() {
        return countryService.findAll();
    }

    /**
     * Returns all instances of the type {@code Country} with the given IDs.
     * <p>
     * If some or all ids are not found, no countries are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found countries. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Country> findAllById(Iterable<Integer> ids) {
        return countryService.findAllById(ids);
    }

    /**
     * Returns the number of countries available.
     *
     * @return the number of countries.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return countryService.count();
    }

    /**
     * Deletes the country with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return countryService.deleteById(id);
    }

    /**
     * Deletes a given country.
     *
     * @param country must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Country country) {
        return countryService.delete(country);
    }

    /**
     * Deletes all instances of the type {@code Country} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return countryService.deleteAllById(ids);
    }
}
