package jar.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.entity.TaiKhoan;
import jar.repository.TaiKhoanRepository;

@CrossOrigin("*") // Cho phép Frontend gọi API mà không bị chặn lỗi CORS
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TaiKhoanRepository taiKhoanRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        // ---- MÁY QUÉT KIỂM TRA LỖI ----
        System.out.println("----------------------------------------");
        System.out.println("Username web gửi xuống: [" + username + "]");
        System.out.println("Password web gửi xuống: [" + password + "]");
        System.out.println("----------------------------------------");

        // Gọi xuống DB để dò tìm tài khoản
        Optional<TaiKhoan> tk = taiKhoanRepo.findByTenDangNhapAndMatKhau(username, password);

        // Nếu tìm thấy (isPresent() == true) -> Thành công
        if (tk.isPresent()) {
            return ResponseEntity.ok(Map.of(
                "success", true, 
                "message", "Đăng nhập thành công!",
                "role", tk.get().getVaiTro(),
                "manv", tk.get().getManv()
            ));
        } else {
            // Nếu không tìm thấy -> Sai tài khoản hoặc mật khẩu
            return ResponseEntity.status(401).body(Map.of(
                "success", false, 
                "message", "Tên đăng nhập hoặc mật khẩu không chính xác!"
            ));
        }
    }
}