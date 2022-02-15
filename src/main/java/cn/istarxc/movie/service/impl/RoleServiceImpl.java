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
package cn.istarxc.movie.service.impl;

import cn.istarxc.movie.entity.Role;
import cn.istarxc.movie.repository.RoleRepository;
import cn.istarxc.movie.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * movie roles info service implementation
 *
 * @author Cherlas
 * @since 2022-02-07 22:09:56
 */
@Service("roleService")
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public Mono<Role> save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Flux<Role> saveAll(Iterable<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    @Override
    public Mono<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Integer id) {
        return roleRepository.existsById(id);
    }

    @Override
    public Flux<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Flux<Role> findAllById(Iterable<Integer> ids) {
        return roleRepository.findAllById(ids);
    }

    @Override
    public Mono<Long> count() {
        return roleRepository.count();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return roleRepository.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Role role) {
        return roleRepository.delete(role);
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<Integer> ids) {
        return roleRepository.deleteAllById(ids);
    }
}
