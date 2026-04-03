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

import jar.entity.DonViVanChuyen;
import jar.repository.DonViVanChuyenRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vanchuyen")
public class DonViVanChuyenController {

    @Autowired
    private DonViVanChuyenRepository donViVanChuyenRepository;

    @GetMapping
    public List<DonViVanChuyen> layTatCa() { return donViVanChuyenRepository.findAll(); }

    @PostMapping
    public DonViVanChuyen themMoi(@RequestBody DonViVanChuyen dvvc) { return donViVanChuyenRepository.save(dvvc); }

    @DeleteMapping("/{id}")
    public void xoa(@PathVariable("id") String id) { donViVanChuyenRepository.deleteById(id); }
}