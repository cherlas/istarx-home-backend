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

import cn.istarxc.movie.entity.Role;
import cn.istarxc.movie.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * movie roles info controller
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:55
 */
@RestController
@RequestMapping("role")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    /**
     * Saves a role and returned the saved instance.
     *
     * @param role must not be {@literal null}.
     * @return the saved role.
     */
    @PostMapping("entity")
    Mono<Role> save(@RequestBody Role role) {
        return roleService.save(role);
    }

    /**
     * Saves all given roles.
     *
     * @param roles must not be {@literal null}.
     * @return the saved roles.
     * {@literal null}.
     */
    @PostMapping("all")
    Flux<Role> saveAll(@RequestBody Iterable<Role> roles) {
        return roleService.saveAll(roles);
    }

    /**
     * Retrieves a role by its id.
     *
     * @param id must not be {@literal null}.
     * @return the role with the given id or {@link Mono#empty()} if none found.
     */
    @GetMapping("{id}")
    Mono<Role> findById(@PathVariable("id") Integer id) {
        return roleService.findById(id);
    }

    /**
     * Returns whether a role with the given {@literal id} exists.
     *
     * @param id must not be {@literal null}.
     * @return emitting {@literal true} if a role with the given id exists, {@literal false} otherwise.
     */
    @GetMapping("exists/{id}")
    Mono<Boolean> existsById(@PathVariable("id") Integer id) {
        return roleService.existsById(id);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all roles.
     */
    @GetMapping("all")
    Flux<Role> findAll() {
        return roleService.findAll();
    }

    /**
     * Returns all instances of the type {@code Role} with the given IDs.
     * <p>
     * If some or all ids are not found, no roles are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return the found roles. The size can be equal or less than the number of given
     * {@literal ids}.
     */
    @GetMapping("all/ids")
    Flux<Role> findAllById(Iterable<Integer> ids) {
        return roleService.findAllById(ids);
    }

    /**
     * Returns the number of roles available.
     *
     * @return the number of roles.
     */
    @GetMapping("count")
    Mono<Long> count() {
        return roleService.count();
    }

    /**
     * Deletes the role with the given id.
     *
     * @param id must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("{id}")
    Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return roleService.deleteById(id);
    }

    /**
     * Deletes a given role.
     *
     * @param role must not be {@literal null}.
     * @return signaling when operation has completed.
     */
    @DeleteMapping("entity")
    Mono<Void> delete(@RequestBody Role role) {
        return roleService.delete(role);
    }

    /**
     * Deletes all instances of the type {@code Role} with the given IDs.
     *
     * @param ids must not be {@literal null}.
     * @return signaling when operation has completed. {@literal null}.
     */
    @DeleteMapping("all")
    Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return roleService.deleteAllById(ids);
    }
}
