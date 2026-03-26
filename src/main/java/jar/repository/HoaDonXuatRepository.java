package jar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.HoaDonXuat;

@Repository
public interface HoaDonXuatRepository extends JpaRepository<HoaDonXuat, Integer> { 
}