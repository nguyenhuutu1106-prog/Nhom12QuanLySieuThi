package jar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "don_vi_van_chuyen")
public class DonViVanChuyen {
    
    @Id
    @Column(length = 50)
    private String id; 

    @Column(columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(length = 20)
    private String sdt;

    // Bổ sung cột Địa chỉ ở đây
    @Column(name = "diachi", columnDefinition = "NVARCHAR(255)")
    private String diaChi; 

    // --- GETTER VÀ SETTER ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}