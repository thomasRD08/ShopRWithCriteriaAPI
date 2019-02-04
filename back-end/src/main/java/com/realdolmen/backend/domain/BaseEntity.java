package com.realdolmen.backend.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    protected Long id;

    @Version
    protected Long version;
}