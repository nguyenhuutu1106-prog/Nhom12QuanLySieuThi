package jar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoa_don_xuat")
public class HoaDonXuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Lệnh này giúp ID tự động tăng (1, 2, 3...)
    private Integer id;

    @Column(columnDefinition = "NVARCHAR(50)")
    private String thoiGian;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String nhanVien;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenSanPham;

    private Double giaBan;
    private Integer soLuong;
    private Double thanhTien;

    // --- GETTER & SETTER ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getThoiGian() { return thoiGian; }
    public void setThoiGian(String thoiGian) { this.thoiGian = thoiGian; }
    
    public String getNhanVien() { return nhanVien; }
    public void setNhanVien(String nhanVien) { this.nhanVien = nhanVien; }
    
    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }
    
    public Double getGiaBan() { return giaBan; }
    public void setGiaBan(Double giaBan) { this.giaBan = giaBan; }
    
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    
    public Double getThanhTien() { return thanhTien; }
    public void setThanhTien(Double thanhTien) { this.thanhTien = thanhTien; }
}