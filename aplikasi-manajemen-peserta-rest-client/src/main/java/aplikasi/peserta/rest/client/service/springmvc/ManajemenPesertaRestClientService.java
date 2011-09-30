/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.client.service.springmvc;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.service.ManajemenPesertaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URI;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Student-08
 */
public class ManajemenPesertaRestClientService implements ManajemenPesertaService {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String APP_CONTEXT = "/aplikasi-manajemen-peserta-springmvc-0.1.1-SNAPSHOT";
    private static final String urlPeserta = "http://" + HOST +":"+ PORT + APP_CONTEXT +"/rest/peserta/";
    private static final String urlPesertaById = urlPeserta+"id/{id}";
    private static final String urlPesertaByNoka = urlPeserta+"noka/{noka}";
    private static final String urlPesertaCount = urlPeserta+"count/";
    private RestTemplate restTemplate;
        
    public ManajemenPesertaRestClientService() {
        restTemplate = new RestTemplate(new CommonsClientHttpRequestFactory());
    }

    @Override
    public void simpan(Peserta p) {
        if (p.getId() == null) {
            URI uri = restTemplate.postForLocation(urlPeserta, p);
            System.out.println("Object baru sudah dibuat :" + uri.getUserInfo());
        } else {
            restTemplate.put(urlPesertaById, p, p.getId());
        }
    }

    @Override
    public Peserta findPesertaById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        
        Peserta p = restTemplate.getForObject(urlPesertaById, Peserta.class, params);
        return p;
    }

    @Override
    public Peserta findPesertaByNomerPeserta(String no) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("noka", no);
        
        Peserta p = restTemplate.getForObject(urlPesertaByNoka, Peserta.class, params);
        return p;
    }

    @Override
    public List<Peserta> findSemuaPeserta(Integer start, Integer rows) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long countSemuaPeserta() {
        return restTemplate.getForObject(urlPesertaCount, Long.class);
    }

    @Override
    public List<Peserta> findPesertaByNama(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long countPesertaByNama(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
