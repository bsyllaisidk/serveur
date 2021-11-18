package com.isi.serveur.service;

import com.isi.serveur.model.Serveur;

import java.util.Collection;

public interface ServeurService {
    Serveur create(Serveur serveur);
    Serveur ping(Serveur ipAddress);
    Collection<Serveur> lis(int limite);
    Serveur get(Long id);
    Serveur update(Serveur serveur);
    Serveur delete(Long id);
}
