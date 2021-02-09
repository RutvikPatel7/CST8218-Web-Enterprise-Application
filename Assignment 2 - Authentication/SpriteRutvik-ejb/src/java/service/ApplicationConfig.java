/*
 *  Name:            Rutvik Patel
 *  Student Number:        040915445
 *  Class Name:     ApplicationConfig
 */
package service;

import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.core.Application;

/**
 *
 * @author Rutvik
 */
@DatabaseIdentityStoreDefinition(
   dataSourceLookup = "${'java:comp/DefaultDataSource'}",
   callerQuery = "#{'select password from app.appuser where email = ?'}",
   groupsQuery = "select groupname from app.appuser where email = ?",
   hashAlgorithm = PasswordHash.class,
   priority = 10
)
@BasicAuthenticationMechanismDefinition
/*@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/index.xhtml",
                errorPage = "/index.xhtml"))
*/
@Named
@ApplicationScoped
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.SpriteFacadeREST.class);
    }
    
}
