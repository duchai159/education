package com.dhai.education.service.impl;

import com.dhai.education.entity.Role;
import com.dhai.education.repository.RoleRepository;
import com.dhai.education.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role getByName(String name) {
        Role role = roleRepository.findByName(name).orElseThrow(()-> new RuntimeException("Role not found"));
        return role;
    }
}
