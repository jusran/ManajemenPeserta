/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.ws;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.service.ManajemenPesertaService;
import aplikasi.peserta.service.impl.dummy.ManajemenPesertaServiceDummy;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Student-08
 */
@WebService(serviceName = "ManajemenPesertaWS")
public class ManajemenPesertaWS {

    static ManajemenPesertaService service = new ManajemenPesertaServiceDummy();
    
    /** This is a sample web service operation */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findPesertaByNomerPeserta")
    public Peserta findPesertaByNomerPeserta(@WebParam(name = "nomerPeserta") String nomerPeserta) {
        return service.findPesertaByNomerPeserta(nomerPeserta);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "simpan")
    public Peserta simpan(@WebParam(name = "peserta") Peserta p) {
        service.simpan(p);
        return p;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findSemuaPeserta")
    public List findSemuaPeserta(@WebParam(name = "start") Integer start, @WebParam(name = "rows") Integer rows) {
        return service.findSemuaPeserta(start, rows);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "countSemuaPeserta")
    public Long countSemuaPeserta() {
        return service.countSemuaPeserta();
    }
    
}
