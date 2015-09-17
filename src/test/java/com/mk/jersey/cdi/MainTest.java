
package com.mk.jersey.cdi;

import junit.framework.TestCase;


public class MainTest extends TestCase {

//    private HttpServer httpServer;
//
//    public MainTest(String testName) {
//        super(testName);
//    }
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//
//        //start the Grizzly2 web container
//        httpServer = Main.startServer();
//
//        // create the client
//        Client c = ClientFactor.newClient();//.reate();
//        r = Client.resource(Main.BASE_URI);
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//
//        httpServer.stop();
//    }
//
//    /**
//     * Test to see that the message "Got it!" is sent in the response.
//     */
//    public void testMyResource() {
//        String responseMsg = r.path("myresource").get(String.class);
//        assertEquals("Got it!", responseMsg);
//    }
//
//    /**
//     * Test if a WADL document is available at the relative path
//     * "application.wadl".
//     */
//    public void testApplicationWadl() {
//        String serviceWadl = r.path("application.wadl").
//                accept(MediaTypes.WADL).get(String.class);
//
//        assertTrue(serviceWadl.length() > 0);
//    }
}
