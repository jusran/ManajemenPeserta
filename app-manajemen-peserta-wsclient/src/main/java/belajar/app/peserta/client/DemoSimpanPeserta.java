/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.app.peserta.client;

import aplikasi.peserta.ws.Peserta;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author Student-08
 */
public class DemoSimpanPeserta {
    public static void main(String[] args) throws DatatypeConfigurationException {
        Peserta p = new Peserta();
        p.setId(3);
        p.setNomerPeserta("3000");
        p.setNama("Sandi");
        p.setTanggalLahir(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(2011, 1, 30)));
        
        try { // Call Web Service Operation
            aplikasi.peserta.ws.ManajemenPesertaWS_Service service = new aplikasi.peserta.ws.ManajemenPesertaWS_Service();
            aplikasi.peserta.ws.ManajemenPesertaWS port = service.getManajemenPesertaWSPort();
            // TODO initialize WS operation arguments here
//            aplikasi.peserta.ws.Peserta peserta = new aplikasi.peserta.ws.Peserta();
            // TODO process result here
            aplikasi.peserta.ws.Peserta result = port.simpan(p);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

    }
}
