package com.lobby.controller;

import com.lobby.model.Lobby;
import com.lobby.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lobbies")
public class LobbyController {

    @Autowired
    private LobbyService lobbyService;

    @GetMapping
    public List<Lobby> getAllLobbies() {
        return lobbyService.getAllLobbies();
    }

    @PostMapping
    public ResponseEntity<Lobby> createLobby(@RequestBody Lobby lobby) {
        return ResponseEntity.ok(lobbyService.createLobby(lobby));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lobby> getLobbyById(@PathVariable Long id) {
        Lobby lobby = lobbyService.getLobbyById(id);
        if (lobby != null) {
            return ResponseEntity.ok(lobby);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
