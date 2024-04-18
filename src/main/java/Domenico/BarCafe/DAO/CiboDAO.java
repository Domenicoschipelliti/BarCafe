package Domenico.BarCafe.DAO;

import Domenico.BarCafe.Enteties.Cibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CiboDAO extends JpaRepository<Cibo, UUID> {
   @Query("SELECT c FROM Cibo c WHERE c.nomeProdotto LIKE %:nomeProdotto%")
   List<Cibo> listCibo(@Param("nomeProdotto") String nomeProdotto);

   @Query("SELECT c FROM Cibo c WHERE c.costo=costo")
   List<Cibo> CostoCibo(@Param("costo")double costo);
}
