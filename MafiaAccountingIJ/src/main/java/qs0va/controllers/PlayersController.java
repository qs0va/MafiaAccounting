package qs0va.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import qs0va.model.Player;
import qs0va.services.PlayersService;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    PlayersService service;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping()
    ResponseEntity<List<Player>> getAll() throws JsonProcessingException {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Player> getById(@PathVariable("id") int id) throws JsonProcessingException {
        try {
            return ResponseEntity.ok(service.getById(id));
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    void put(@RequestBody Player player) {
        service.add(player);
    }
}
