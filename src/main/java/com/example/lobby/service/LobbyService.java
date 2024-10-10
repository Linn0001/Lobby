package com.lobby.service;

import com.lobby.model.Lobby;
import com.lobby.repository.LobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobbyService {

    @Autowired
    private LobbyRepository lobbyRepository;

    public List<Lobby> getAllLobbies() {
        return lobbyRepository.findAll();
    }

    public Lobby createLobby(Lobby lobby) {
        return lobbyRepository.save(lobby);
    }

    public Lobby getLobbyById(Long id) {
        return lobbyRepository.findById(id).orElse(null);
    }
}
