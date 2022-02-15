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

import cn.istarxc.movie.entity.Director;
import cn.istarxc.movie.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * directors info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:49
 */
@RestController
@RequestMapping("director")
@AllArgsConstructor
public class DirectorController {

    private DirectorService directorService;

    /**
     * Saves a director and returned the saved instance.
     *
     * @param director must not be {@literal null}.
     * @return the saved director.
     */
    @PostMapping("entity")
    Mono<Director> save(@RequestBody Director director) {
        return directorService.save(director);
    }

    /**
     * Saves all given directors.
     *
     * @param directors must not be {@literal null}.
     * @return the saved directors.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Director> saveAll(@RequestBody Iterable<Director> directors) {
        return directorService.saveAll(directors);
    }

    /**
     * Retrieves an director by its id.
     *
     * @param id must not be {@literal null}.
     * @return the director with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Director> findById(@PathVariable("id") Integer id) {
        return directorService.findById(id);
    }

    /**
     * Returns whether an director with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an director with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return directorService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all directors.
     */
    @GetMapping("all")
    Flux<Director> findAll() {
        return directorService.findAll();
    }

    /**
     * Returns all instances of the type {@code Director} with the given IDs.
     * <p>
     * If some or all ids are not found, no directors are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found directors. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Director> findAllById(Iterable<Integer> ids) {
        return directorService.findAllById(ids);
    }

    /**
     * Returns the number of directors available.
     *
     * @return the number of directors.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return directorService.count();
    }

    /**
     * Deletes the director with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return directorService.deleteById(id);
    }

    /**
     * Deletes a given director.
     *
     * @param director must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Director director) {
        return directorService.delete(director);
    }

    /**
     * Deletes all instances of the type {@code Director} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return directorService.deleteAllById(ids);
    }
}
