/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.domain;

import java.util.Date;

/**
 *
 * @author Student-08
 */
public class Peserta {
    private Integer id;
    private String nomerPeserta;
    private String nama;
    private Date tanggalLahir;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nomerPeserta
     */
    public String getNomerPeserta() {
        return nomerPeserta;
    }

    /**
     * @param nomerPeserta the nomerPeserta to set
     */
    public void setNomerPeserta(String nomerPeserta) {
        this.nomerPeserta = nomerPeserta;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the tanggalLahir
     */
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    /**
     * @param tanggalLahir the tanggalLahir to set
     */
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}
