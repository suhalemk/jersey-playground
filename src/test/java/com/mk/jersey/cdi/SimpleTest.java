package com.mk.jersey.cdi;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static junit.framework.Assert.assertEquals;

/**
 * Created by malangkhader1 on 9/15/15.
 */
public class SimpleTest extends JerseyTest {

//    @Path("hello")
//    public static class HelloResource {
//        @GET
//        public String getHello() {
//            return "Hello World!";
//        }
//    }

    @Override
    protected Application configure() {
        return new MyApplication(); //ResourceConfig(MyResource.class);
    }

    @Test
    public void test() {
//        final String hello = target("hello").request().get(String.class);
//        assertEquals("Hello World!", hello);
        final String hello = target("myresource/another").request().get(String.class);
        assertEquals("Another Got it!", hello);
    }
}
