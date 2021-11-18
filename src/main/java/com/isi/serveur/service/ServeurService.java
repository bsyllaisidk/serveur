package com.isi.serveur.service;

import com.isi.serveur.model.Serveur;

import java.io.IOException;
import java.util.Collection;

public interface ServeurService {
    Serveur create(Serveur serveur);
    Serveur ping(String ipAddress) throws IOException;
    Collection<Serveur> lis(int limite);
    Serveur get(Long id);
    Serveur update(Serveur serveur);
    Serveur delete(Long id);
}
