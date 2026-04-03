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

import jar.entity.NhanVien;
import jar.repository.NhanVienRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping
    public List<NhanVien> layTatCa() { return nhanVienRepository.findAll(); }

    @PostMapping
    public NhanVien themMoi(@RequestBody NhanVien nv) { return nhanVienRepository.save(nv); }

    @DeleteMapping("/{id}")
    public void xoa(@PathVariable("id") String id) { nhanVienRepository.deleteById(id); }
}