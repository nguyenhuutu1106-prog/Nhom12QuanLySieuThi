package jar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @Column(name = "MANV", length = 20)
    private String id; 

    @Column(name = "TENNV", columnDefinition = "NVARCHAR(100)")
    private String ten;

    @Column(name = "NGAYSINH")
    private String ngaySinh; // Phải viết chữ S hoa

    @Column(name = "CHUCVU", columnDefinition = "NVARCHAR(50)")
    private String chucVu; // Phải viết chữ V hoa

    @Column(name = "SDT", length = 15)
    private String sdt; // Phải viết chữ thường toàn bộ

    @Column(name = "GIOITINH", columnDefinition = "NVARCHAR(10)")
    private String gioiTinh; // Phải viết chữ T hoa

    // --- GETTER & SETTER ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    
    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }
    
    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }
    
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
}