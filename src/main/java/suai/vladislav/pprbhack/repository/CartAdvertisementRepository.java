package suai.vladislav.pprbhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suai.vladislav.pprbhack.model.CartAdvertisement;

@Repository
public interface CartAdvertisementRepository extends JpaRepository<CartAdvertisement, Long> {
}
