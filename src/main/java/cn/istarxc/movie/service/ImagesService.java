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

import cn.istarxc.movie.entity.Images;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * poster and avatar images service interface
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:50
 */
public interface ImagesService {

    /**
     * Saves a given images. Use the returned instance for further operations as the save operation might have changed the
     * images instance completely.
     *
     * @param images must not be {@literal null}.
     * @return {@link Mono} emitting the saved images.
     * @throws IllegalArgumentException in case the given {@literal images} is {@literal null}.
     */
    Mono<Images> save(Images images);

    /**
     * Saves all given images.
     *
     * @param images must not be {@literal null}.
     * @return {@link Flux} emitting the saved images.
     * @throws IllegalArgumentException in case the given {@link Iterable images} or one of its images is
     *                                  {@literal null}.
     */
    Flux<Images> saveAll(Iterable<Images> images);

    /**
     * Retrieves an images by its id.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} emitting the images with the given id or {@link Mono#empty()} if none found.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    Mono<Images> findById(Integer id);

    /**
     * Returns whether an images with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} emitting {@literal true} if an images with the given id exists, {@literal false} otherwise.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    Mono<Boolean> existsById(Integer id);

    /**
     * Returns all instances of the type.
     *
     * @return {@link Flux} emitting all images.
     */
    Flux<Images> findAll();

    /**
     * Returns all instances of the type {@code Images} with the given IDs.
     * <p>
     * If some or all ids are not found, no images are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return {@link Flux} emitting the found images. The size can be equal or less than the number of given
     * {@literal ids}.
     * @throws IllegalArgumentException in case the given {@link Iterable ids} or one of its items is {@literal null}.
     */
    Flux<Images> findAllById(Iterable<Integer> ids);

    /**
     * Returns the number of images available.
     *
     * @return {@link Mono} emitting the number of images.
     */
    Mono<Long> count();

    /**
     * Deletes the images with the given id.
     *
     * @param id must not be {@literal null}.
     * @return {@link Mono} signaling when operation has completed.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}.
     */
    Mono<Void> deleteById(Integer id);

    /**
     * Deletes a given images.
     *
     * @param images must not be {@literal null}.
     * @return {@link Mono} signaling when operation has completed.
     * @throws IllegalArgumentException in case the given images is {@literal null}.
     */
    Mono<Void> delete(Images images);

    /**
     * Deletes all instances of the type {@code Images} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return {@link Mono} signaling when operation has completed.
     * @throws IllegalArgumentException in case the given {@literal ids} or one of its elements is {@literal null}.
     *                                  {@literal null}.
     */
    Mono<Void> deleteAllById(Iterable<Integer> ids);
}
