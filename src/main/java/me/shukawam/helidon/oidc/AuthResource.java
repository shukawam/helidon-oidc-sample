package me.shukawam.helidon.oidc;

import io.helidon.security.SecurityContext;
import io.helidon.security.annotations.Authenticated;
import io.helidon.security.providers.oidc.OidcProvider;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("auth")
public class AuthResource {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated // ... 1
    public JsonObject login(@Context SecurityContext securityContext) { // ... 1
        return JSON.createObjectBuilder()
                .add("message", "Login success!")
                .add("user", securityContext.userName())
                .build();
    }

    @GET
    @Path("logout") // ... 2
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject logout() {
        return JSON.createObjectBuilder()
                .add("message", "Logout Success!")
                .build();
    }
}
