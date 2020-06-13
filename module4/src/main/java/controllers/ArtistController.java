package com.example.module4.controllers;

import com.example.module4.repositories.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @RequestMapping("/artists")
    public String getArtists(Model model) {

        model.addAttribute("artists", artistRepository.findAll());

        return "artists";
    }
}
