package br.com.medcontrol.repository;


import br.com.medcontrol.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PacienteRepository  extends JpaRepository<PacienteEntity, Long> {



}
