package jar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    // Hàm này tương đương lệnh SQL: SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?
    Optional<TaiKhoan> findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
}