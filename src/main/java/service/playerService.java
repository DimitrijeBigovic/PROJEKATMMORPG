package service;


import exception.PlayerException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.MultipartBody;
import model.Player;
import model.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Dependent
public class playerService {

    @Inject
    EntityManager em;

    @Transactional
    public Player createPlayer(Player player) throws PlayerException {
        if (player == null) {
            throw new PlayerException("Player is null ");
        }
        if (player.getUsername() == null) {
            throw new PlayerException("Player username is null ");
        }
        return em.merge(player);
    }


    public List<Player> getAllPlayers() {
        return em.createNamedQuery(Player.GET_ALL_PLAYERS, Player.class).getResultList();
    }

    public Player getPlayerById(Long id) {
        return em.find(Player.class, id);
    }

    public List<Player> getAllPlayersByUsername(String username) {
        List<Player> players = em.createNamedQuery(Player.GET_PLAYER_BY_USERNAME, Player.class).setParameter("username", username).getResultList();
        return players;
    }


    @Transactional
    public Player addImageToPlayer2(Long playerId, MultipartBody image) throws PlayerException, IOException {

        Player player = getPlayerById(playerId);
        if (player == null) {
            throw new PlayerException("Player is null ");
        }
        if (image.file == null) {
            throw new PlayerException("File is null ");
        }

        Path destination = Path.of("C:\\Users\\dimit\\OneDrive\\Desktop\\SlikeZAprojekat", image.file.fileName());
        if (!Files.exists(destination)) {
            Files.copy(image.file.uploadedFile(), destination);
        }

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFileName(destination.toString());

        player.getUploadedFiles().add(uploadedFile);
        return em.merge(player);


    }

    public Player getPlayerWithImages(Long playerId) throws PlayerException {
        Player player = getPlayerById(playerId);
        if (player == null) {
            throw new PlayerException("Player is null ");
        }
       List<UploadedFile> uploadedFiles = player.getUploadedFiles();
        if (uploadedFiles.isEmpty()) {
            throw new PlayerException("Player has no uploaded files");
        }
        for (UploadedFile uploadedFile : uploadedFiles) {
            File file = new  File(uploadedFile.getFileName());
            uploadedFile.setFile(file);

        }

        return player;

    }

}
