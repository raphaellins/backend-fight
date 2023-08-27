package com.api.backendfight.repositories;

import com.api.backendfight.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
   @Query(
       nativeQuery = true,
       value = "SELECT DISTINCT p.* FROM pessoas p " +
       "LEFT JOIN pessoas_stacks ps ON p.id = ps.pessoa_id " +
       "WHERE p.apelido ILIKE CONCAT('%', :searchTerm, '%') OR " +
       "p.nome ILIKE CONCAT('%', :searchTerm, '%') OR " +
       "ps.stack ILIKE CONCAT('%', :searchTerm, '%') " +
       "LIMIT 50"
   )
   List<Pessoa> findAllBySearchTerm(String searchTerm);
}
