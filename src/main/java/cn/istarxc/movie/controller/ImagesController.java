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

import cn.istarxc.movie.entity.Images;
import cn.istarxc.movie.service.ImagesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * poster and avatar images controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:49
 */
@RestController
@RequestMapping("images")
@AllArgsConstructor
public class ImagesController {

    private ImagesService imagesService;

    /**
     * Saves an images and returned the saved instance.
     *
     * @param images must not be {@literal null}.
     * @return the saved images.
     */
    @PostMapping("entity")
    Mono<Images> save(@RequestBody Images images) {
        return imagesService.save(images);
    }

    /**
     * Saves all given images.
     *
     * @param images must not be {@literal null}.
     * @return the saved images.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Images> saveAll(@RequestBody Iterable<Images> images) {
        return imagesService.saveAll(images);
    }

    /**
     * Retrieves an images by its id.
     *
     * @param id must not be {@literal null}.
     * @return the images with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Images> findById(@PathVariable("id") Integer id) {
        return imagesService.findById(id);
    }

    /**
     * Returns whether an images with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an images with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return imagesService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all images.
     */
    @GetMapping("all")
    Flux<Images> findAll() {
        return imagesService.findAll();
    }

    /**
     * Returns all instances of the type {@code Images} with the given IDs.
     * <p>
     * If some or all ids are not found, no images are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found images. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Images> findAllById(Iterable<Integer> ids) {
        return imagesService.findAllById(ids);
    }

    /**
     * Returns the number of images available.
     *
     * @return the number of images.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return imagesService.count();
    }

    /**
     * Deletes the images with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return imagesService.deleteById(id);
    }

    /**
     * Deletes a given images.
     *
     * @param images must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Images images) {
        return imagesService.delete(images);
    }

    /**
     * Deletes all instances of the type {@code Images} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return imagesService.deleteAllById(ids);
    }
}
