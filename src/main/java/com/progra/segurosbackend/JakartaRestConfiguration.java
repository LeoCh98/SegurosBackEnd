package com.progra.segurosbackend;

import com.progra.segurosbackend.logic.Poliza;
import com.progra.segurosbackend.logic.User;
import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
@DeclareRoles({"ADM","CLI"})
public class JakartaRestConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        //Se agregan las clases de js
        classes.add(User.class);
        classes.add(Poliza.class);
        return classes;
    }
    
}
