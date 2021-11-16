package com.isi.serveur.service;

import com.isi.serveur.model.Serveur;

import java.util.Collection;

public interface ServeurService {
    Serveur create(Serveur serveur);
    Collection<Serveur> lis(int limite);
    Serveur get(Long id);
    Serveur update(Serveur serveur);
    Serveur delete(Long id);
}
