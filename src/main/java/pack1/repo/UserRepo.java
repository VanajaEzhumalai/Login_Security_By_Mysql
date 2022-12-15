package pack1.repo;

import org.springframework.data.repository.CrudRepository;

import pack1.entity.User;

public interface UserRepo extends CrudRepository<User,Long> {

}
