package pl.blazejolesiak.demo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.blazejolesiak.demo.models.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<UserModel, Integer> {
List<UserModel> findAll();
Optional<UserModel> findByUsername(String username);
Optional<UserModel> findByEmail(String email);
}
