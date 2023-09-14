package br.com.medcontrol.repository;

import br.com.medcontrol.entity.CirurgiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CirurgiaRepository extends JpaRepository<CirurgiaEntity, Long> {
}
