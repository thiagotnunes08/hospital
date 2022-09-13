package br.com.zup.edu.saintgermain.leito;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.*;

@RestController
public class AtualizaLeitoController {

    private final LeitoRepository repository;

    public AtualizaLeitoController(LeitoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PatchMapping("leitos/{id}")
    public ResponseEntity<?> atualizaReserva(@PathVariable Long id) {

        Leito leito = repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        if (leito.isLivre()){

            leito.reserva();

            repository.save(leito);

            return ResponseEntity.noContent().build();
        }

        throw new ResponseStatusException(UNPROCESSABLE_ENTITY);

    }

}
