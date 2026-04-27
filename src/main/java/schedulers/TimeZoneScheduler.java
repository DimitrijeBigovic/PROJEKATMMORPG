package schedulers;


import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import rest.IPApi;
import rest.TimeApi;
import service.TimeService;

@ApplicationScoped
public class TimeZoneScheduler {
    @Inject
    @RestClient
    TimeApi timeApi;
    @Inject
    @RestClient
    IPApi ipApi;
    @Inject
    TimeService timeService;

@Scheduled(every="20s")
    public void increment(){

}
}
