package jar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tai_khoan") // Đổi tên bảng ở đây
public class TaiKhoan {
    
    @Id
    private String tenDangNhap;

    private String matKhau;

    private String manv;

    private String vaiTro;

    // --- CÁC HÀM GETTER VÀ SETTER (BẠN GIỮ NGUYÊN NHƯ CŨ NHÉ) ---
    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }
    
    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    
    public String getManv() { return manv; }
    public void setManv(String manv) { this.manv = manv; }
    
    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
}