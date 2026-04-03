package jar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.NhaCungCap;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> { 
}