package jar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MATHANG")
public class MatHang {
    
    @Id
    @Column(length = 50)
    private String id; 

    @Column(columnDefinition = "NVARCHAR(255)")
    private String ten;

    private Double giaNhap;
    private Double giaBan;

    // --- MỚI THÊM: CỘT TỒN KHO ---
    @Column(name = "TONKHO")
    private Integer tonKho = 0; 

    // --- GETTER VÀ SETTER ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public Double getGiaNhap() { return giaNhap; }
    public void setGiaNhap(Double giaNhap) { this.giaNhap = giaNhap; }
    public Double getGiaBan() { return giaBan; }
    public void setGiaBan(Double giaBan) { this.giaBan = giaBan; }
    
    // --- MỚI THÊM: GETTER/SETTER CHO TỒN KHO ---
    public Integer getTonKho() { return tonKho; }
    public void setTonKho(Integer tonKho) { this.tonKho = tonKho; }
}