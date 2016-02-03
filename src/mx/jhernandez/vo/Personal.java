package mx.jhernandez.vo;

/**
 *
 * @author Viruz
 */
public class Personal {

    private int nPerCodigo;
    private String cPerNombre;
    private String cPerDirceccion;
    private String cPerCi;
    private String cPerTipoTelefono;
    private String cPerNumTelefono;
    private String cPerEstado;

    public String getcPerDirceccion() {
        return cPerDirceccion;
    }

    public void setcPerDirceccion(String cPerDirceccion) {
        this.cPerDirceccion = cPerDirceccion;
    }

    public String getcPerNombre() {
        return cPerNombre;
    }

    public void setcPerNombre(String cPerNombre) {
        this.cPerNombre = cPerNombre;
    }

    public String getcPerCi() {
        return cPerCi;
    }

    public void setcPerCi(String cPerCi) {
        this.cPerCi = cPerCi;
    }

    public String getcPerNumTelefono() {
        return cPerNumTelefono;
    }

    public void setcPerNumTelefono(String cPerNumTelefono) {
        this.cPerNumTelefono = cPerNumTelefono;
    }

    public String getcPerTipoTelefono() {
        return cPerTipoTelefono;
    }

    public void setcPerTipoTelefono(String cPerTipoTelefono) {
        this.cPerTipoTelefono = cPerTipoTelefono;
    }

    public int getnPerCodigo() {
        return nPerCodigo;
    }

    public void setnPerCodigo(int nPerCodigo) {
        this.nPerCodigo = nPerCodigo;
    }

    public String getcPerEstado() {
        return cPerEstado;
    }

    public void setcPerEstado(String cPerEstado) {
        this.cPerEstado = cPerEstado;
    }
}
