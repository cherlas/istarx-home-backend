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

import cn.istarxc.movie.entity.Screenwriter;
import cn.istarxc.movie.service.ScreenwriterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * screenwriters info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:56
 */
@RestController
@RequestMapping("screenwriter")
@AllArgsConstructor
public class ScreenwriterController {

    private ScreenwriterService screenwriterService;

    /**
     * Saves a screenwriter and returned the saved instance.
     *
     * @param screenwriter must not be {@literal null}.
     * @return the saved screenwriter.
     */
    @PostMapping("entity")
    Mono<Screenwriter> save(@RequestBody Screenwriter screenwriter) {
        return screenwriterService.save(screenwriter);
    }

    /**
     * Saves all given screenwriters.
     *
     * @param screenwriters must not be {@literal null}.
     * @return the saved screenwriters.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Screenwriter> saveAll(@RequestBody Iterable<Screenwriter> screenwriters) {
        return screenwriterService.saveAll(screenwriters);
    }

    /**
     * Retrieves a screenwriter by its id.
     *
     * @param id must not be {@literal null}.
     * @return the screenwriter with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Screenwriter> findById(@PathVariable("id") Integer id) {
        return screenwriterService.findById(id);
    }

    /**
     * Returns whether a screenwriter with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if a screenwriter with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return screenwriterService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all screenwriters.
     */
    @GetMapping("all")
    Flux<Screenwriter> findAll() {
        return screenwriterService.findAll();
    }

    /**
     * Returns all instances of the type {@code Screenwriter} with the given IDs.
     * <p>
     * If some or all ids are not found, no screenwriters are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found screenwriters. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Screenwriter> findAllById(Iterable<Integer> ids) {
        return screenwriterService.findAllById(ids);
    }

    /**
     * Returns the number of screenwriters available.
     *
     * @return the number of screenwriters.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return screenwriterService.count();
    }

    /**
     * Deletes the screenwriter with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return screenwriterService.deleteById(id);
    }

    /**
     * Deletes a given screenwriter.
     *
     * @param screenwriter must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Screenwriter screenwriter) {
        return screenwriterService.delete(screenwriter);
    }

    /**
     * Deletes all instances of the type {@code Screenwriter} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return screenwriterService.deleteAllById(ids);
    }
}
