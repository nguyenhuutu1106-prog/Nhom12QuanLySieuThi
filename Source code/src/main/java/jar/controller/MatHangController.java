package jar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.entity.MatHang;
import jar.repository.MatHangRepository;

@CrossOrigin(origins = "*") // Dòng chú này cực kỳ quan trọng để cho phép file HTML ở ngoài gọi vào không bị lỗi CORS
@RestController
@RequestMapping("/api/sanpham") // Đây là địa chỉ đường ống
public class MatHangController {

    @Autowired
    private MatHangRepository matHangRepository;

    // 1. API Lấy danh sách tất cả sản phẩm
    @GetMapping
    public List<MatHang> layDanhSach() {
        return matHangRepository.findAll();
    }

    // 2. API Thêm một sản phẩm mới vào CSDL
    @PostMapping
    public MatHang themSanPham(@RequestBody MatHang matHang) {
        return matHangRepository.save(matHang);
    }
    // 3. API Xóa sản phẩm
    @DeleteMapping("/{id}")
    public void xoaSanPham(@PathVariable String id) {
        matHangRepository.deleteById(id);
    }
}