/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.springmvc;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.service.ManajemenPesertaService;
import aplikasi.peserta.service.impl.dummy.ManajemenPesertaServiceDummy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Student-08
 */
@Controller
@RequestMapping("/peserta")
public class PesertaController {
    static ManajemenPesertaService service = new ManajemenPesertaServiceDummy();
    
    
    public PesertaController() {
        Peserta p = new Peserta();
        p.setNomerPeserta("0901000012312");
        p.setNama("Sapardi");
        p.setTanggalLahir(new Date());
        service.simpan(p);
    }
    
    @RequestMapping(value="/", method= RequestMethod.GET)
    @ResponseBody
    public List<Peserta> semuaPeserta() {
        Integer start = 0;
        Integer rows = 10;
        return service.findSemuaPeserta(start, rows);
    }
    
    @RequestMapping(value="/", method= RequestMethod.POST)
    @ResponseBody
    public Peserta simpan(@RequestBody Peserta p) {
        service.simpan(p);
        return p;
    }
    
    @RequestMapping(value="/multi/", method= RequestMethod.POST)
    @ResponseBody
    public Peserta simpanBanyak(@RequestBody List<Peserta> p) {
        for (Peserta peserta : p) {
            service.simpan(peserta);
        }
//        service.simpan(p);
        return p.get(0);
    }

    @RequestMapping(value="/cari/", method= RequestMethod.GET)
    @ResponseBody
    public List<Peserta> cariPeserta(@RequestParam(required=false) String nama) {
        Integer start = 0;
        Integer rows = 10;
        List<Peserta> semua = service.findSemuaPeserta(start, rows);
        List<Peserta> hasil = new ArrayList<Peserta>();
        
        if (nama != null && !nama.isEmpty()) {
            for (Peserta peserta : semua) {
                if (peserta.getNama().contains(nama)) {
                    hasil.add(peserta);
                }
            }
        } else {
            hasil.addAll(semua);
        }
        return hasil;
    }
    
    @RequestMapping(value="/id/{id}", method= RequestMethod.PUT)
    @ResponseBody
    public Peserta update(@PathVariable Integer id, @RequestBody Peserta p) {
        Peserta px = findPesertaById(id);
        px.setNama(p.getNama());
        px.setNomerPeserta(p.getNomerPeserta());
        px.setTanggalLahir(p.getTanggalLahir());
        return px;
    }
    
    @RequestMapping(value="/id/{id}", method= RequestMethod.GET)
    @ResponseBody
    public Peserta findPesertaById(@PathVariable Integer id) {
        return service.findPesertaById(id);
    }
    
    @RequestMapping(value="/noka/{noka}", method= RequestMethod.GET)
    @ResponseBody
    public Peserta findPesertaByNomorPeserta(@PathVariable String noka) {
        return service.findPesertaByNomerPeserta(noka);
    }
    
    @RequestMapping(value="/count/", method= RequestMethod.GET)
    @ResponseBody
    public Long countSemuaPeserta() {
        return service.countSemuaPeserta();
    }
    
    
}
