package dev.java10x.CadastroDeNinjas.repository;

import dev.java10x.CadastroDeNinjas.entity.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
