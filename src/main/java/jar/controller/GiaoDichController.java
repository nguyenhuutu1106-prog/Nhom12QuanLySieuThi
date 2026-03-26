package jar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.entity.HoaDonNhap;
import jar.entity.HoaDonXuat;
import jar.entity.MatHang;
import jar.repository.HoaDonNhapRepository;
import jar.repository.HoaDonXuatRepository;
import jar.repository.MatHangRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/giaodich")
public class GiaoDichController {

    @Autowired
    private MatHangRepository matHangRepository;
    @Autowired
    private HoaDonXuatRepository hoaDonXuatRepository;
    @Autowired
    private HoaDonNhapRepository hoaDonNhapRepository; // Mới thêm

    // ================= XUẤT HÀNG =================
    @GetMapping("/xuat")
    public List<HoaDonXuat> layLichSuXuat() {
        return hoaDonXuatRepository.findAll();
    }

    @PostMapping("/xuat")
    public HoaDonXuat xuatHang(@RequestBody Map<String, String> payload) {
        String maSP = payload.get("maSP");
        int soLuong = Integer.parseInt(payload.get("soLuong"));
        
        MatHang sp = matHangRepository.findById(maSP).orElseThrow(() -> new RuntimeException("Lỗi SP"));
        int tonKhoHienTai = (sp.getTonKho() == null) ? 0 : sp.getTonKho().intValue();
        
        if (tonKhoHienTai < soLuong) throw new RuntimeException("Kho không đủ hàng!");

        sp.setTonKho(tonKhoHienTai - soLuong);
        matHangRepository.save(sp);

        HoaDonXuat hdx = new HoaDonXuat();
        hdx.setThoiGian(payload.get("thoiGian"));
        hdx.setNhanVien(payload.get("nhanVien"));
        hdx.setTenSanPham(sp.getTen());
        hdx.setGiaBan(sp.getGiaBan());
        hdx.setSoLuong(soLuong);
        hdx.setThanhTien(sp.getGiaBan() * soLuong);
        return hoaDonXuatRepository.save(hdx);
    }

    // ================= NHẬP HÀNG =================
    @GetMapping("/nhap")
    public List<HoaDonNhap> layLichSuNhap() {
        return hoaDonNhapRepository.findAll();
    }

    @PostMapping("/nhap")
    public HoaDonNhap nhapHang(@RequestBody Map<String, String> payload) {
        String maSP = payload.get("maSP");
        int soLuong = Integer.parseInt(payload.get("soLuong"));

        MatHang sp = matHangRepository.findById(maSP).orElseThrow(() -> new RuntimeException("Lỗi SP"));
        int tonKhoHienTai = (sp.getTonKho() == null) ? 0 : sp.getTonKho().intValue();
        
        // 1. Cộng tồn kho
        sp.setTonKho(tonKhoHienTai + soLuong);
        matHangRepository.save(sp);

        // 2. Lưu hóa đơn nhập
        HoaDonNhap hdn = new HoaDonNhap();
        hdn.setThoiGian(payload.get("thoiGian"));
        hdn.setNhanVien(payload.get("nhanVien"));
        hdn.setNhaCungCap(payload.get("nhaCungCap"));
        hdn.setVanChuyen(payload.get("vanChuyen"));
        hdn.setTenSanPham(sp.getTen());
        hdn.setGiaNhap(sp.getGiaNhap());
        hdn.setSoLuong(soLuong);
        hdn.setThanhTien(sp.getGiaNhap() * soLuong);
        return hoaDonNhapRepository.save(hdn);
    }
}