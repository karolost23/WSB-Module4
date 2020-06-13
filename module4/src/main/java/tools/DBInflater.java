package com.example.module4.tools;

import com.example.module4.model.Artist;
import com.example.module4.model.Publisher;
import com.example.module4.model.Song;
import com.example.module4.repositories.ArtistRepository;
import com.example.module4.repositories.PublisherRepository;
import com.example.module4.repositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(SongRepository songRepository, ArtistRepository artistRepository, PublisherRepository publisherRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.publisherRepository = publisherRepository;
    }

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private PublisherRepository publisherRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Artist johnny = new Artist("Johny", "Cash", "cash");
        Publisher columbia = new Publisher("Columbia Records");
        Song aBoyNamedSue = new Song("A Boy Named Sue", "country", "1983129873", "1969", columbia);
        johnny.getSongs().add(aBoyNamedSue);
        aBoyNamedSue.getArtists().add(johnny);
        artistRepository.save(johnny);
        songRepository.save(aBoyNamedSue);

        Artist bob = new Artist("Bob", "Marley", "BoB");
        Publisher island = new Publisher("Island Records");
        Song threeLittleBirds = new Song("Three little birds", "Raegge", "98172391123", "1977", island);
        bob.getSongs().add(threeLittleBirds);
        threeLittleBirds.getArtists().add(bob);
        publisherRepository.save(island);
        artistRepository.save(bob);
        songRepository.save(threeLittleBirds);

        Artist freddie = new Artist("Freddie", "Mercury", "Freddie");
        Publisher emi = new Publisher("EMI");
        Song callingAllGirls = new Song("Calling All Girls", "Many", "09309823091", "1982", emi);
        freddie.getSongs().add(callingAllGirls);
        callingAllGirls.getArtists().add(freddie);
        publisherRepository.save(emi);
        artistRepository.save(freddie);
        songRepository.save(callingAllGirls);
    }

}
