package pl.blazejolesiak.demo.models.repositories.portfolioRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.blazejolesiak.demo.models.portfolioModel.TitleModel;

import java.util.Optional;
@Repository
public interface ITitleRepository extends CrudRepository<TitleModel, Integer> {

    Optional<TitleModel> findTitleModelById(int id);
}
