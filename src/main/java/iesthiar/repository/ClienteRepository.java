package iesthiar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iesthiar.modelo.Coche;

public interface ClienteRepository extends JpaRepository<Coche, Long> {
    
}
