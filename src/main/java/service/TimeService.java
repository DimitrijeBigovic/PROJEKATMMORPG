package service;

import exception.PlayerException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Player;
import model.TimeResponce;
import model.TimeZone;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import rest.IPApi;
import rest.TimeApi;

@ApplicationScoped
public class TimeService {
    @Inject
    playerService playerService;
    @Inject
    @RestClient
    TimeApi timeApi;
    @Inject
    @RestClient
    IPApi ipApi;


    @Transactional
    public TimeZone getTimeByPlayerId(Long playerId) throws PlayerException {
        Player player = playerService.getPlayerById(playerId);
        if (player == null) {
            throw new PlayerException("Player with id: " + playerId + " not found.");
        }

        String ipAddress = ipApi.getIPAddress();
        TimeResponce response = timeApi.getTimeByIP(ipAddress);
        TimeZone zone = new TimeZone();
        zone.setTimeZone(response.getTimeZone());
        zone.setCurrentTime(response.getTime());
        zone.setDate(response.getDate());
        zone.setDayOfWeek(response.getDayOfWeek());
        zone.setDstActive(response.dstActive);
        zone.setPlayer(player);
        player.getTimeZones().add(zone);
        return zone;

    }


}
