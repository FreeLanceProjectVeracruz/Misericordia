package mx.jhernandez.vo;

import java.util.Date;

/**
 *
 * @author Viruz
 */
public class Venta {

    private int nVenCodigo;
    private Cliente cliente;
    private Personal personal;
    private Date cVenFecha;
    private Double nVenMontoTotal;
    private TipoDocumento tipoDocumento;
    private String cVenEstado;
    private String cFormapago;

    public Date getcVenFecha() {
        return cVenFecha;
    }

    public void setcVenFecha(Date cVenFecha) {
        this.cVenFecha = cVenFecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getnVenCodigo() {
        return nVenCodigo;
    }

    public void setnVenCodigo(int nVenCodigo) {
        this.nVenCodigo = nVenCodigo;
    }

    public Double getnVenMontoTotal() {
        return nVenMontoTotal;
    }

    public void setnVenMontoTotal(Double nVenMontoTotal) {
        this.nVenMontoTotal = nVenMontoTotal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getcVenEstado() {
        return cVenEstado;
    }

    public void setcVenEstado(String cVenEstado) {
        this.cVenEstado = cVenEstado;
    }

    public String getcFormapago() {
        return cFormapago;
    }

    public void setcFormapago(String cFormapago) {
        this.cFormapago = cFormapago;
    }
}
