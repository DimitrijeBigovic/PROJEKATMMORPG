package rest;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.swing.*;

@Path("/")
@RegisterRestClient(configKey = "ip-api")
public interface IPApi {
    @GET
  public  String getIPAddress();
}
