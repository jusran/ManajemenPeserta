/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.springmvc;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.helper.PesertaConverter;
import aplikasi.peserta.service.ManajemenPesertaService;
import aplikasi.peserta.service.impl.dummy.ManajemenPesertaServiceDummy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    @ResponseStatus(HttpStatus.CREATED)
    public void simpanBulk(@RequestBody List<Map<String, Object>> p, HttpServletRequest req, HttpServletResponse res) {
        for (Map<String, Object> peserta : p) {
            service.simpan(PesertaConverter.fromMap(peserta));
        }
        String reqUrl = req.getContextPath() + "/rest/peserta/";
        res.setHeader("Location", reqUrl);
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
