package br.com.zup.edu.saintgermain.leito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface LeitoRepository extends JpaRepository<Leito,Long> {


    Optional<Leito> findByStatus(StatusOcupacao statusOcupacao);
}
