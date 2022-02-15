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
package cn.istarxc.movie.service;

import cn.istarxc.movie.entity.MovieCountry;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * relationship between movie and country service interface
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:52
 */
public interface MovieCountryService {

    /**
     * Saves a given movieCountry. Use the returned instance for further operations as the save operation might have changed the
     * movieCountry instance completely.
     *
     * @param movieCountry must not be {@literal null}.
     * @return {@link Mono} emitting the saved movieCountry.
     * @throws IllegalArgumentException in case the given {@literal movieCountry} is {@literal null}.
     */
    Mono<MovieCountry> save(MovieCountry movieCountry);

    /**
     * Saves all given movieCountrys.
     *
     * @param movieCountrys must not be {@literal null}.
     * @return {@link Flux} emitting the saved movieCountrys.
     * @throws IllegalArgumentException in case the given {@link Iterable movieCountrys} or one of its movieCountrys is
     *                                  {@literal null}.
     */
    Flux<MovieCountry> saveAll(Iterable<MovieCountry> movieCountrys);

    /**
     * Retrieves an movieCountry by its id.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} emitting the movieCountry with the given id or {@link Mono#empty()} if none found.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    Mono<MovieCountry> findById(Integer id);

    /**
     * Returns whether an movieCountry with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} emitting {@literal true} if an movieCountry with the given id exists, {@literal false} otherwise.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    Mono<Boolean> existsById(Integer id);

    /**
     * Returns all instances of the type.
     *
     * @return {@link Flux} emitting all movieCountrys.
     */
    Flux<MovieCountry> findAll();

    /**
     * Returns all instances of the type {@code MovieCountry} with the given IDs.
     * <p>
     * If some or all ids are not found, no movieCountrys are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return {@link Flux} emitting the found movieCountrys. The size can be equal or less than the number of given
     * {@literal ids}.
     * @throws IllegalArgumentException in case the given {@link Iterable ids} or one of its items is {@literal null}.
     */
    Flux<MovieCountry> findAllById(Iterable<Integer> ids);

    /**
     * Returns the number of movieCountrys available.
     *
     * @return {@link Mono} emitting the number of movieCountrys.
     */
    Mono<Long> count();

    /**
     * Deletes the movieCountry with the given id.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} signaling when operation has completed.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    Mono<Void> deleteById(Integer id);

    /**
     * Deletes a given movieCountry.
     *
     * @param movieCountry must not be {@literal null}.
     * @return {@link Mono} signaling when operation has completed.
     * @throws IllegalArgumentException in case the given movieCountry is {@literal null}.
     */
    Mono<Void> delete(MovieCountry movieCountry);

    /**
     * Deletes all instances of the type {@code MovieCountry} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return {@link Mono} signaling when operation has completed.
     * @throws IllegalArgumentException in case the given {@literal ids} or one of its elements is {@literal null}.
     *                                  {@literal null}.
     */
    Mono<Void> deleteAllById(Iterable<Integer> ids);
}
