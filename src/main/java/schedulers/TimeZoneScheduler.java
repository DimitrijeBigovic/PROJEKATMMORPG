package schedulers;


import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.TimeResponce;
import model.TimeZone;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import rest.IPApi;
import rest.TimeApi;
import service.TimeService;

import java.util.List;


@ApplicationScoped
public class TimeZoneScheduler {
    @Inject
    @RestClient
    TimeApi timeApi;
    @Inject
    @RestClient
    IPApi ipApi;
    @Inject
    EntityManager em;


    @Scheduled(every = "20s")
    @Transactional
    public void refreshTimeZones() {
        List<TimeZone> timeZones = em.createNamedQuery("GetAllTimeZones", TimeZone.class).getResultList();
        if (timeZones.isEmpty()) {
            System.out.println("No time zones were found");
            return;
        }

        String ipAddress = ipApi.getIPAddress();
        TimeResponce responce = timeApi.getTimeByIP(ipAddress);
        for (TimeZone timeZone : timeZones) {
            timeZone.setCurrentTime(responce.getTime());
            timeZone.setTimeZone(responce.getTimeZone());
            timeZone.setSeconds(responce.getSeconds());

        }
        System.out.println("Time Zones su osvjezeni: ");


    }
}
