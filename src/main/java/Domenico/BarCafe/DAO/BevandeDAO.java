package Domenico.BarCafe.DAO;

import Domenico.BarCafe.Enteties.Bevande;
import Domenico.BarCafe.Enteties.Cibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BevandeDAO extends JpaRepository<Bevande, UUID> {
    @Query("SELECT b FROM Bevande b WHERE b.nomeProdotto LIKE %:nomeProdotto%")
    List<Bevande> listBevande(@Param("nomeProdotto") String nomeProdotto);

    @Query("SELECT b FROM Bevande b WHERE  b.costo=costo")
    List<Bevande> BevandeList(@Param("costo")double costo);


}
