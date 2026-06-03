package service;


import exception.PlayerException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.LocationResponse;
import model.LocationZone;
import model.Player;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import rest.IPApi;
import rest.LocationApi;

@ApplicationScoped
public class LocationService {
    @Inject
    playerService playerService;
    @Inject
    @RestClient
    IPApi ipApi;
    @Inject
    @RestClient
    LocationApi locationApi;

    @Transactional
    public LocationZone getLocationZone(Long playerId) throws PlayerException{
        Player player = playerService.getPlayerById(playerId);
        if (player == null) {
            throw new PlayerException("Player not found");
        }
        String ipAdress = ipApi.getIPAddress();
        LocationResponse responce= locationApi.getLocationByIP(ipAdress);
        LocationZone locationZone = new LocationZone();
        locationZone.setAsValue(responce.getAs());
        locationZone.setCity(responce.getCity());
        locationZone.setCountry(responce.getCountry());
        locationZone.setCountryCode(responce.getCountryCode());
        locationZone.setPlayer(player);
        locationZone.setQuery(responce.getQuery());
        locationZone.setStatus(responce.getStatus());
        locationZone.setTimeZone(responce.getTimeZone());
        player.getLocationZones().add(locationZone);
        return locationZone;


    }

}
