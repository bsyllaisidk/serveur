package com.isi.serveur.model;

import com.isi.serveur.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Serveur {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "IpAdress ne peutvpas null ou vide")
    @Column(unique = true)
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;


}
