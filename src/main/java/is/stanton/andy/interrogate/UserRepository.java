package is.stanton.andy.interrogate;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByOrderByNameAsc();
}
