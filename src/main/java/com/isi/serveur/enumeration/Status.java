package com.isi.serveur.enumeration;

public enum Status {
    SERVEUR_UP("SERVEUR_UP"),
    SERVEUR_DOWN("SERVEUR_DOWN");
    private final String status;
    Status (String status){
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
}
