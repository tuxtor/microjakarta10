package com.vorozco.microjakarta10.resources;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ArquillianExtension.class)
class RestResourceIT {


    @Test
    @RunAsClient
    public void testURL() throws Exception {
        String result = TestUtil.performCall(new URL("http://localhost:8080/"+ "hello"));
        assertEquals(result, "{\"text\":\"Hola desde Jakarta EE 10\"}", result);
    }
}
