# JIT Role Provisioning Handler

This repo contains a custom Provisioning Handler to assign roles to users in WSO2 during JIT provisioning.

> This branch contains the implementation for API Manager v3.2.0. You can clone this repo and build the same for other versions with correct dependencies.

## Use Case

This handler can be used to assign roles for federated users who are provisioned from external sources. When the configured external IDP is not sending any Role / Group information in the SAML response or in the OIDC token, we can use this handler to conditionaly assign the required roles to the users to provide access to the Portals.

## Build & Deploy

### Build

Execute the following command to build the project

```sh
mvn clean install
```

### Deploy & Configure

- Copy the built JAR artifact from `/target` directory to `<APIM_HOME>/repository/components/lib` directory
- Edit the `<APIM_HOME>/repository/conf/deployment.toml` and add the following
  
  ```toml
  [authentication.framework.extensions]
  provisioning_handler = "com.sample.handlers.JITRoleProvisioningHandler"
  ```

- Restart the server

## License

[Apache-2.0](LICENSE)
