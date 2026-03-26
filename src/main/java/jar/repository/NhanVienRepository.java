package jar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> { }