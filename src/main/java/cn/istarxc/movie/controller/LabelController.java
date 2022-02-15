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

import cn.istarxc.movie.entity.Label;
import cn.istarxc.movie.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * labels info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:50
 */
@RestController
@RequestMapping("label")
@AllArgsConstructor
public class LabelController {

    private LabelService labelService;

    /**
     * Saves a label and returned the saved instance.
     *
     * @param label must not be {@literal null}.
     * @return the saved label.
     */
    @PostMapping("entity")
    Mono<Label> save(@RequestBody Label label) {
        return labelService.save(label);
    }

    /**
     * Saves all given labels.
     *
     * @param labels must not be {@literal null}.
     * @return the saved labels.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Label> saveAll(@RequestBody Iterable<Label> labels) {
        return labelService.saveAll(labels);
    }

    /**
     * Retrieves an label by its id.
     *
     * @param id must not be {@literal null}.
     * @return the label with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Label> findById(@PathVariable("id") Integer id) {
        return labelService.findById(id);
    }

    /**
     * Returns whether an label with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an label with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return labelService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all labels.
     */
    @GetMapping("all")
    Flux<Label> findAll() {
        return labelService.findAll();
    }

    /**
     * Returns all instances of the type {@code Label} with the given IDs.
     * <p>
     * If some or all ids are not found, no labels are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found labels. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Label> findAllById(Iterable<Integer> ids) {
        return labelService.findAllById(ids);
    }

    /**
     * Returns the number of labels available.
     *
     * @return the number of labels.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return labelService.count();
    }

    /**
     * Deletes the label with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return labelService.deleteById(id);
    }

    /**
     * Deletes a given label.
     *
     * @param label must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Label label) {
        return labelService.delete(label);
    }

    /**
     * Deletes all instances of the type {@code Label} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return labelService.deleteAllById(ids);
    }
}
