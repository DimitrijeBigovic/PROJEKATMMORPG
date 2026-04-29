package service;


import exception.PlayerException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.CurrencyResponce;
import model.Player;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import rest.CurrencyConvertrAPI;

@ApplicationScoped
public class CurrencyConvertService {
    @Inject
    @RestClient
    CurrencyConvertrAPI currencyConvertrAPI;

    @Inject
    playerService playerService;


    @Transactional
    public CurrencyResponce convert(String from, String to, Long playerId, double value) throws PlayerException {

        Player player = playerService.getPlayerById(playerId);
        if (player == null) {
            throw new PlayerException("Player not" + playerId + " found");
        }

        CurrencyResponce responce = currencyConvertrAPI.getCurrency(from, to);
        CurrencyResponce zone = new CurrencyResponce();
        zone.setRate(responce.getRate());
        zone.setValue(value);
        zone.setConvertedValue(value*responce.getRate());
        zone.setFromValue(responce.getFromValue());
        zone.setToValue(responce.getToValue());
        zone.setDate(responce.getDate());
        zone.setSource(responce.getSource());
        zone.setPlayer(player);
        player.getCurrencies().add(zone);



        return zone;


    }

}
