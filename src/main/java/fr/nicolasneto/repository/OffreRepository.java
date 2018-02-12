package fr.nicolasneto.repository;

import fr.nicolasneto.domain.Offre;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Offre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
    @Query("select distinct offre from Offre offre left join fetch offre.competences")
    List<Offre> findAllWithEagerRelationships();

    @Query("select offre from Offre offre left join fetch offre.competences where offre.id =:id")
    Offre findOneWithEagerRelationships(@Param("id") Long id);

}
