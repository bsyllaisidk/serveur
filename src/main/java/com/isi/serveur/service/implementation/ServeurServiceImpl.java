package com.isi.serveur.service.implementation;

import com.isi.serveur.enumeration.Status;
import com.isi.serveur.model.Serveur;
import com.isi.serveur.repo.ServeurRepo;
import com.isi.serveur.service.ServeurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static com.isi.serveur.enumeration.Status.SERVEUR_DOWN;
import static com.isi.serveur.enumeration.Status.SERVEUR_UP;

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
    public Collection<Serveur> lis(int limite) {
        log.info("Fetching all serveurs : {}");
        return serveurRepo.findAll(PageRequest.of(0, limite)).toList();
    }

    @Override
    public Serveur get(Long id) {
        return null;
    }

    @Override
    public Serveur update(Serveur serveur) {
        return null;
    }

    @Override
    public Serveur delete(Long id) {
        return null;
    }
    private String SetServeurImageUrl() {
        return null;
    }
}
