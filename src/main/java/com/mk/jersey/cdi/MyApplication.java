package com.mk.jersey.cdi;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(new MyApplicationBinder());
        //uncomment the following when not using web.xml
        //packages(true, "com.mk.jersey.cdi");
    }

    public class MyApplicationBinder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(MyService.class).to(MyService.class);
            bind(PrimaryDBService.class).to(DBService.class).named("primary");
            bind(SecondaryDBService.class).to(DBService.class).named("secondary");
        }
    }
}


