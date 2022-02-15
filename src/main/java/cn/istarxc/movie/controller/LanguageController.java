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

import cn.istarxc.movie.entity.Language;
import cn.istarxc.movie.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * languages info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:50
 */
@RestController
@RequestMapping("language")
@AllArgsConstructor
public class LanguageController {

    private LanguageService languageService;

    /**
     * Saves a language and returned the saved instance.
     *
     * @param language must not be {@literal null}.
     * @return the saved language.
     */
    @PostMapping("entity")
    Mono<Language> save(@RequestBody Language language) {
        return languageService.save(language);
    }

    /**
     * Saves all given languages.
     *
     * @param languages must not be {@literal null}.
     * @return the saved languages.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Language> saveAll(@RequestBody Iterable<Language> languages) {
        return languageService.saveAll(languages);
    }

    /**
     * Retrieves an language by its id.
     *
     * @param id must not be {@literal null}.
     * @return the language with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Language> findById(@PathVariable("id") Integer id) {
        return languageService.findById(id);
    }

    /**
     * Returns whether an language with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if an language with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return languageService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all languages.
     */
    @GetMapping("all")
    Flux<Language> findAll() {
        return languageService.findAll();
    }

    /**
     * Returns all instances of the type {@code Language} with the given IDs.
     * <p>
     * If some or all ids are not found, no languages are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found languages. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Language> findAllById(Iterable<Integer> ids) {
        return languageService.findAllById(ids);
    }

    /**
     * Returns the number of languages available.
     *
     * @return the number of languages.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return languageService.count();
    }

    /**
     * Deletes the language with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return languageService.deleteById(id);
    }

    /**
     * Deletes a given language.
     *
     * @param language must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Language language) {
        return languageService.delete(language);
    }

    /**
     * Deletes all instances of the type {@code Language} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return languageService.deleteAllById(ids);
    }
}
