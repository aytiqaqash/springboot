package com.example.springboot.config;

public enum UserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:read"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:read");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
