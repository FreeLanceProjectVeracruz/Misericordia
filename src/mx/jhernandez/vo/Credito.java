package mx.jhernandez.vo;

/**
 *
 * @author Viruz
 */
public class Credito {

    private Venta venta;
    private int nCreNroCuotas;
    private Double ncreMontoPorCuota;
    private String cCreEstado;
    private Double nCreMontoDebito;

    public String getcCreEstado() {
        return cCreEstado;
    }

    public void setcCreEstado(String cCreEstado) {
        this.cCreEstado = cCreEstado;
    }

    public Double getnCreMontoDebito() {
        return nCreMontoDebito;
    }

    public void setnCreMontoDebito(Double nCreMontoDebito) {
        this.nCreMontoDebito = nCreMontoDebito;
    }

    public int getnCreNroCuotas() {
        return nCreNroCuotas;
    }

    public void setnCreNroCuotas(int nCreNroCuotas) {
        this.nCreNroCuotas = nCreNroCuotas;
    }

    public Double getNcreMontoPorCuota() {
        return ncreMontoPorCuota;
    }

    public void setNcreMontoPorCuota(Double ncreMontoPorCuota) {
        this.ncreMontoPorCuota = ncreMontoPorCuota;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
