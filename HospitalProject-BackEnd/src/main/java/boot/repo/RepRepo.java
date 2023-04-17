package boot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.Rep;

public interface RepRepo extends JpaRepository<Rep,Long>{

	Optional<Rep> findByEmailAndPassword(String email, String password);
}
