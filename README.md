# Helidon OIDC Sample

Sample code for Helidon - OIDC Login/Logout (since [2.4.0](https://github.com/oracle/helidon/releases/tag/2.4.0)).

## Build and run

### With JDK 11+

Edit `application.yaml`.

```yaml
# Identity Provider - IDCS
idcs-uri: <your-idcs-tenant-uri>
idcs-client-id: <your-idcs-client-id>
idcs-client-secret: <your-idcs-client-secret>
frontend-uri: <your-front-end>
audience: <your-audience>
```

1. idcs-uri: Base URL of your idcs instance, usually something like `https://idcs-...identity.oraclecloud.com`
2. idcs-client-id: This is obtained from your IDCS application in the IDCS console
3. idcs-client-secret: This is obtained from your IDCS application in the IDCS console
4. frontend-uri: This is the base URL of your application when run, e.g. `http://localhost:8080`
5. audience: This is obtained from your IDCS base url, usually something like `https://idcs-...identity.oraclecloud.com:443`

Build the application.

```bash
mvn package
```

Run the application.

```bash
java -jar target/helidon-oidc-sample.jar
```

### With Docker Compose

Rename `deploy/docker/idcs_variables copy.env` to `deploy/docker/idcs_variables.env`. And edit `idcs_variables.env`.

```env
security.properties.idcs-uri=
security.properties.idcs-client-id=
security.properties.idcs-client-secret=
security.properties.frontend-uri=
security.properties.audience=
```

1. idcs-uri: Base URL of your idcs instance, usually something like `https://idcs-...identity.oraclecloud.com`
2. idcs-client-id: This is obtained from your IDCS application in the IDCS console
3. idcs-client-secret: This is obtained from your IDCS application in the IDCS console
4. frontend-uri: This is the base URL of your application when run, e.g. `http://localhost:8080`
5. audience: This is obtained from your IDCS base url, usually something like `https://idcs-...identity.oraclecloud.com:443`

Run the application.

```bash
cd deploy/docker; docker-compose up -d
```

### With Kubernetes

TODO

## Endpoints

| Endpoint     | Description          |
| ------------ | -------------------- |
| /auth/login  | Endpoint for login.  |
| /oidc/logout | Endpoint for logout. |
