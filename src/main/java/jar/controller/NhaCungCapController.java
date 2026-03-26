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

import jar.entity.NhaCungCap;
import jar.repository.NhaCungCapRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/nhacungcap")
public class NhaCungCapController {

    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    @GetMapping
    public List<NhaCungCap> layTatCa() { return nhaCungCapRepository.findAll(); }

    @PostMapping
    public NhaCungCap themMoi(@RequestBody NhaCungCap ncc) { return nhaCungCapRepository.save(ncc); }

    @DeleteMapping("/{id}")
    public void xoa(@PathVariable("id") String id) { nhaCungCapRepository.deleteById(id); }
}