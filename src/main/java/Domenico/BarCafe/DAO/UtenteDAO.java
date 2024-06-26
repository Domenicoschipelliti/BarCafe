package Domenico.BarCafe.DAO;

import Domenico.BarCafe.Enteties.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UtenteDAO extends JpaRepository<Utente, UUID> {
    Optional<Utente> findByEmail(String email);
    Optional<Utente> findByUsername(String username);
    @Query("SELECT u FROM Utente u WHERE u.username LIKE %:username%")
    List<Utente> findByUser(@Param("username")String username);
}
