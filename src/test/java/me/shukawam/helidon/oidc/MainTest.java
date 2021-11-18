
package me.shukawam.helidon.oidc;

import javax.inject.Inject;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.spi.CDI;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Response;

import io.helidon.microprofile.server.Server;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.helidon.microprofile.tests.junit5.HelidonTest;

@HelidonTest
class MainTest {

    @Inject
    private WebTarget target;

    @Test
    void testHelloWorld() {
        try (Response r = target
                .path("metrics")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET metrics status code");
        }

        try (Response r = target
                .path("health")
                .request()
                .get()) {
            Assertions.assertEquals(200, r.getStatus(), "GET health status code");
        }
    }
}
