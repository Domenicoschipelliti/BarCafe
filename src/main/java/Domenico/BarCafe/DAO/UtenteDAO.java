package Domenico.BarCafe.DAO;

import Domenico.BarCafe.Enteties.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UtenteDAO extends JpaRepository<Utente, UUID> {
}
