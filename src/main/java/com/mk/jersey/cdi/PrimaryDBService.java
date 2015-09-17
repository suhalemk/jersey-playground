package com.mk.jersey.cdi;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

@Service @Named(value = "secondary")
public class PrimaryDBService implements DBService {
    public String serviceCall() {
        return "Primary service";
    }
}