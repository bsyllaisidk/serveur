package com.isi.serveur.repo;

import com.isi.serveur.model.Serveur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServeurRepo extends JpaRepository<Serveur, Long> {
    Serveur findByIpAddress(String IpAddress);

}