package com.wizen.web.portal.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {
    @Override
    public String get() {
        return "Hello JUnit 5";
    }
}