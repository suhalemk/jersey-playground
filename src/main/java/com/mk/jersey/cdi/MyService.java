package com.mk.jersey.cdi;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;


@Resource
public class MyService {

    @Inject @Named("primary")
    DBService as;

    @Inject @Named("secondary")
    DBService bs;

    public String serviceCall() {
        return as.serviceCall() + " : Service calls: " + bs.serviceCall();
    }
}