/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.app.peserta.client;

import aplikasi.peserta.ws.Peserta;
import java.util.List;

/**
 *
 * @author Student-08
 */
public class DemoTampilkanPeserta {
    public static void main(String[] args) {
        
        try { // Call Web Service Operation
            aplikasi.peserta.ws.ManajemenPesertaWS_Service service = new aplikasi.peserta.ws.ManajemenPesertaWS_Service();
            aplikasi.peserta.ws.ManajemenPesertaWS port = service.getManajemenPesertaWSPort();
            // TODO initialize WS operation arguments here
            java.lang.Integer start = Integer.valueOf(0);
            java.lang.Integer rows = Integer.valueOf(100);
            // TODO process result here
            List<Object> result = port.findSemuaPeserta(start, rows);
            
            System.out.println("Result = "+result);
            for (Object peserta : result) {
                Peserta p = (Peserta) peserta;
//                Peserta p = peserta;
                System.out.println("ID :" + p.getId());
                System.out.println("NoKartu :" + p.getNomerPeserta());
                System.out.println("Nama :" + p.getNama());
                System.out.println("Tanggal Lahir :" + p.getTanggalLahir().toGregorianCalendar().getTime());
            }
            
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

    }
}
