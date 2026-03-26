package jar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.DonViVanChuyen;

@Repository
public interface DonViVanChuyenRepository extends JpaRepository<DonViVanChuyen, String> { 
}