package pl.blazejolesiak.demo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.blazejolesiak.demo.models.ProjectModel;
@Repository
public interface IProjectRepository extends CrudRepository<ProjectModel, Integer> {
}
