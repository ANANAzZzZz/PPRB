package suai.vladislav.pprbhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suai.vladislav.pprbhack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
