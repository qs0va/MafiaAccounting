package qs0va.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qs0va.my.repos.PlayerRepository;

@RestController
public class FtController {
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/")
    String hello() {
        return playerRepository.pr();
    }
}
