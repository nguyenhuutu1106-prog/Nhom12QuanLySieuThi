package jar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jar.entity.MatHang;

@Repository
public interface MatHangRepository extends JpaRepository<MatHang, String> {
    // JpaRepository đã làm sẵn mọi lệnh Thêm, Sửa, Xóa, Lấy danh sách cho chúng ta rồi!
}