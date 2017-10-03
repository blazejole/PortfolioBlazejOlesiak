package pl.blazejolesiak.demo.models.repositories.portfolioRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.blazejolesiak.demo.models.portfolioModel.ProjectModel;
@Repository
public interface IProjectRepository extends CrudRepository<ProjectModel, Integer> {
}
