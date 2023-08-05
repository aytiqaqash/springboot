package com.example.springboot.config;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.springboot.config.UserPermissions.*;

public enum UserRoles {
    // Pesmissionları əlavə elədik Admin üçün
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    STUDENT(Sets.newHashSet());

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }
}
