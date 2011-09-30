/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.client;

import java.util.Date;
import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.rest.client.service.springmvc.ManajemenPesertaRestClientService;

/**
 *
 * @author Student-08
 */
public class DaftarPesertaDemo {
    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate(new CommonsClientHttpRequestFactory());
//        
//        String url = "http://localhost:8080/aplikasi-manajemen-peserta-springmvc-0.1.1-SNAPSHOT/rest/peserta/id/{id}";
//        Integer id = 0;
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("id", id);
//        
        ManajemenPesertaRestClientService service = new ManajemenPesertaRestClientService();
        
        // simpan
//        Peserta ps = new Peserta();
////        ps.setId(3);
//        ps.setNama("Susi");
//        ps.setNomerPeserta("09010012223");
//        ps.setTanggalLahir(new Date());
//        service.simpan(ps);
        
        // count
        System.out.println("Jumlah rows : " + service.countSemuaPeserta());
        
        // cari
//        Peserta p = service.findPesertaByNomerPeserta("0901000012312");
//        System.out.println("Nama : " + p.getNama());
//        System.out.println("Noka : " + p.getNomerPeserta());
        
//        url = "http://localhost:8080/aplikasi-manajemen-peserta-springmvc-0.1.1-SNAPSHOT/rest/peserta/";
//        List<Peserta> pList = (List<Peserta>) restTemplate.getForObject(url, Peserta.class);
//        for (Peserta peserta : pList) {
//            System.out.println("Nama : " + peserta.getNama());
//        }
        
    }
}
