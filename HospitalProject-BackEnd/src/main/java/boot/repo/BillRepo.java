package boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Long>{

}
