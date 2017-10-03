package pl.blazejolesiak.demo.models.repositories.portfolioRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.blazejolesiak.demo.models.portfolioModel.AboutModel;


import java.util.Optional;

@Repository
public interface IAboutMeRepository extends CrudRepository<AboutModel, Integer> {
    Optional<AboutModel> findAboutModelById(int id);
}
