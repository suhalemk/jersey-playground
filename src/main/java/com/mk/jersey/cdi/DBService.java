package com.mk.jersey.cdi;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface DBService {
    public String serviceCall();
}