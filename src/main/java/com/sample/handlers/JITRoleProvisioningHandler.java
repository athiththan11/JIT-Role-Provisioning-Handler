package com.sample.handlers;

import java.util.List;
import java.util.Map;

import org.wso2.carbon.identity.application.authentication.framework.exception.FrameworkException;
import org.wso2.carbon.identity.application.authentication.framework.handler.provisioning.impl.SystemRolesRetainedProvisionHandler;
import org.wso2.carbon.identity.application.authentication.framework.util.FrameworkConstants;

/**
 * The handler extends the implementation of SystemRolesRetainedProvisionHandler
 * which is used to retain the Roles during the provisioning process without
 * removing them.
 * 
 * If you want this handler in lower versions of API Manager (2.x), extend
 * DefaultProvisioningHandler
 */
public class JITRoleProvisioningHandler extends SystemRolesRetainedProvisionHandler {

    @Override
    public void handle(List<String> roles, String subject, Map<String, String> attributes,
            String provisioningUserStoreId, String tenantDomain) throws FrameworkException {

        /**
         * Filter and assign roles based on the IDP configurations. The attributes map
         * contains an entry for the IDP name, that is used for federation.
         * 
         * If you are having multiple federated IDPs, then you can conditionally assign
         * the required roles to the provisioning users.
         */

        // String idp = attributes.get(FrameworkConstants.IDP_ID);
        // if ("ExternalIDP".equals(idp)) {
        // roles.add("Internal/subscriber");
        // roles.add("custom_role");
        // }

        // add the roles
        roles.add("Internal/subscriber");

        super.handle(roles, subject, attributes, provisioningUserStoreId, tenantDomain);
    }
}
