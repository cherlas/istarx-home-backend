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

import cn.istarxc.movie.entity.Movie;
import cn.istarxc.movie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * movies info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:51
 */
@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    /**
     * Saves a movie and returned the saved instance.
     *
     * @param movie must not be {@literal null}.
     * @return the saved movie.
     */
    @PostMapping("entity")
    Mono<Movie> save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    /**
     * Saves all given movies.
     *
     * @param movies must not be {@literal null}.
     * @return the saved movies.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Movie> saveAll(@RequestBody Iterable<Movie> movies) {
        return movieService.saveAll(movies);
    }

    /**
     * Retrieves an movie by its id.
     *
     * @param id must not be {@literal null}.
     * @return the movie with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Movie> findById(@PathVariable("id") Integer id) {
        return movieService.findById(id);
    }

    /**
     * Returns whether an movie with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an movie with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return movieService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all movies.
     */
    @GetMapping("all")
    Flux<Movie> findAll() {
        return movieService.findAll();
    }

    /**
     * Returns all instances of the type {@code Movie} with the given IDs.
     * <p>
     * If some or all ids are not found, no movies are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found movies. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Movie> findAllById(Iterable<Integer> ids) {
        return movieService.findAllById(ids);
    }

    /**
     * Returns the number of movies available.
     *
     * @return the number of movies.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return movieService.count();
    }

    /**
     * Deletes the movie with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return movieService.deleteById(id);
    }

    /**
     * Deletes a given movie.
     *
     * @param movie must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Movie movie) {
        return movieService.delete(movie);
    }

    /**
     * Deletes all instances of the type {@code Movie} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return movieService.deleteAllById(ids);
    }
}
