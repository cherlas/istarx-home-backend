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

import cn.istarxc.movie.entity.AlternateNames;
import cn.istarxc.movie.service.AlternateNamesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * movie alternate names info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:48
 */
@RestController
@RequestMapping("alternateNames")
@AllArgsConstructor
public class AlternateNamesController {

    private AlternateNamesService alternateNamesService;

    /**
     * Saves a alternateNames and returned the saved instance.
     *
     * @param alternateNames must not be {@literal null}.
     * @return the saved alternateNames.
     */
    @PostMapping("entity")
    Mono<AlternateNames> save(@RequestBody AlternateNames alternateNames) {
        return alternateNamesService.save(alternateNames);
    }

    /**
     * Saves all given alternateNames.
     *
     * @param alternateNames must not be {@literal null}.
     * @return the saved alternateNames.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<AlternateNames> saveAll(@RequestBody Iterable<AlternateNames> alternateNames) {
        return alternateNamesService.saveAll(alternateNames);
    }

    /**
     * Retrieves an alternateNames by its id.
     *
     * @param id must not be {@literal null}.
     * @return the alternateNames with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<AlternateNames> findById(@PathVariable("id") Integer id) {
        return alternateNamesService.findById(id);
    }

    /**
     * Returns whether an alternateNames with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an alternateNames with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return alternateNamesService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all alternateNames.
     */
    @GetMapping("all")
    Flux<AlternateNames> findAll() {
        return alternateNamesService.findAll();
    }

    /**
     * Returns all instances of the type {@code AlternateNames} with the given IDs.
     * <p>
     * If some or all ids are not found, no alternateNames are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found alternateNames. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<AlternateNames> findAllById(Iterable<Integer> ids) {
        return alternateNamesService.findAllById(ids);
    }

    /**
     * Returns the number of alternateNames available.
     *
     * @return the number of alternateNames.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return alternateNamesService.count();
    }

    /**
     * Deletes the alternateNames with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return alternateNamesService.deleteById(id);
    }

    /**
     * Deletes a given alternateNames.
     *
     * @param alternateNames must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody AlternateNames alternateNames) {
        return alternateNamesService.delete(alternateNames);
    }

    /**
     * Deletes all instances of the type {@code AlternateNames} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return alternateNamesService.deleteAllById(ids);
    }
}
