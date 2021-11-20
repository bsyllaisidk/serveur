package com.isi.serveur.resource;

import com.isi.serveur.model.Response;
import com.isi.serveur.service.implementation.ServeurServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDate.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/serveur")
@RequiredArgsConstructor
public class ServeurResource {
    private final ServeurServiceImpl serveurService;
    public ResponseEntity<Response> getServeurs(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                       // .data(Map.of("servers", serveurService.list(30)))
                        .message("Serveurs ")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
}
