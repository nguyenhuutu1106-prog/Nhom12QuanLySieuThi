package jar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoa_don_nhap")
public class HoaDonNhap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "NVARCHAR(50)")
    private String thoiGian;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String nhanVien;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String nhaCungCap;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String vanChuyen;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenSanPham;

    private Double giaNhap;
    private Integer soLuong;
    private Double thanhTien;

    // --- GETTER & SETTER ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getThoiGian() { return thoiGian; }
    public void setThoiGian(String thoiGian) { this.thoiGian = thoiGian; }
    public String getNhanVien() { return nhanVien; }
    public void setNhanVien(String nhanVien) { this.nhanVien = nhanVien; }
    public String getNhaCungCap() { return nhaCungCap; }
    public void setNhaCungCap(String nhaCungCap) { this.nhaCungCap = nhaCungCap; }
    public String getVanChuyen() { return vanChuyen; }
    public void setVanChuyen(String vanChuyen) { this.vanChuyen = vanChuyen; }
    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }
    public Double getGiaNhap() { return giaNhap; }
    public void setGiaNhap(Double giaNhap) { this.giaNhap = giaNhap; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    public Double getThanhTien() { return thanhTien; }
    public void setThanhTien(Double thanhTien) { this.thanhTien = thanhTien; }
}