package com.isi.serveur.service.implementation;

import com.isi.serveur.enumeration.Status;
import com.isi.serveur.model.Serveur;
import com.isi.serveur.repo.ServeurRepo;
import com.isi.serveur.service.ServeurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static com.isi.serveur.enumeration.Status.SERVEUR_DOWN;
import static com.isi.serveur.enumeration.Status.SERVEUR_UP;
import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ServeurServiceImpl implements ServeurService {

    private  final ServeurRepo serveurRepo;

    @Override
    public Serveur create(Serveur serveur) {
        log.info("Enregistrer un nouveau serveur : {}",serveur.getName());
        serveur.setImageUrl(SetServeurImageUrl());
        return serveurRepo.save(serveur);
    }

    @Override
    public Serveur ping(String ipAddress) throws IOException {
        log.info("Pinguer l@ IP : {}",ipAddress);
        Serveur serveur = serveurRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        serveur.setStatus(address.isReachable(1000) ? SERVEUR_UP : SERVEUR_DOWN);
        serveurRepo.save(serveur);
        return serveur;
    }

    @Override
    public Collection<Serveur> list(int limite) {
        log.info("Fetching all serveurs : {}");
        return serveurRepo.findAll(PageRequest.of(0, limite)).toList();

    }

    @Override
    public Serveur get(Long id) {
        log.info("Fetching serveur by Id : {}", id);
        return serveurRepo.findById(id).get();
    }

    @Override
    public Serveur update(Serveur serveur) {
        log.info("Modifier un serveur : {}",serveur.getName());
        return serveurRepo.save(serveur);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Supprimer un serveur a parir de Id: {}",id);
        serveurRepo.deleteById(id);
        return TRUE;
    }
    private String SetServeurImageUrl() {
        String [] imageNames = { "serveur1.png","serveur2.png","serveur3.png","serveur4.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("serveur/image" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
