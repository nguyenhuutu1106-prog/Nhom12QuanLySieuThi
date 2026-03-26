package jar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.HoaDonNhap;

@Repository
public interface HoaDonNhapRepository extends JpaRepository<HoaDonNhap, Integer> { 
}