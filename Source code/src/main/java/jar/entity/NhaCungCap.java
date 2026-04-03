package jar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nha_cung_cap")
public class NhaCungCap {
    
    @Id
    @Column(length = 50)
    private String id; 

    @Column(columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(length = 20)
    private String sdt;

    // Ép cứng tên cột và hỗ trợ tiếng Việt
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