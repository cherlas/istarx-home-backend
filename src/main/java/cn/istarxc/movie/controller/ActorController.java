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

import cn.istarxc.movie.entity.Actor;
import cn.istarxc.movie.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * actors info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:48
 */
@RestController
@RequestMapping("actor")
@AllArgsConstructor
public class ActorController {

    private ActorService actorService;

    /**
     * Saves a actor and returned the saved instance.
     *
     * @param actor must not be {@literal null}.
     * @return the saved actor.
     */
    @PostMapping("entity")
    Mono<Actor> save(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    /**
     * Saves all given actors.
     *
     * @param actors must not be {@literal null}.
     * @return the saved actors.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Actor> saveAll(@RequestBody Iterable<Actor> actors) {
        return actorService.saveAll(actors);
    }

    /**
     * Retrieves an actor by its id.
     *
     * @param id must not be {@literal null}.
     * @return the actor with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Actor> findById(@PathVariable("id") Integer id) {
        return actorService.findById(id);
    }

    /**
     * Returns whether an actor with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an actor with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return actorService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all actors.
     */
    @GetMapping("all")
    Flux<Actor> findAll() {
        return actorService.findAll();
    }

    /**
     * Returns all instances of the type {@code Actor} with the given IDs.
     * <p>
     * If some or all ids are not found, no actors are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found actors. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Actor> findAllById(Iterable<Integer> ids) {
        return actorService.findAllById(ids);
    }

    /**
     * Returns the number of actors available.
     *
     * @return the number of actors.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return actorService.count();
    }

    /**
     * Deletes the actor with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return actorService.deleteById(id);
    }

    /**
     * Deletes a given actor.
     *
     * @param actor must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Actor actor) {
        return actorService.delete(actor);
    }

    /**
     * Deletes all instances of the type {@code Actor} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return actorService.deleteAllById(ids);
    }
}
