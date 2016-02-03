package mx.jhernandez.vo;

/**
 *
 * @author Viruz
 */
public class Proveedor {

    private int nProvCodigo;
    private int nPRovNit;
    private String cProvNombre;
    private String cProvDireccion;
    private String cProvNroFax;
    private String cProvPaginaWeb;
    private String cProvEmail;
    private String cProvTipoTelefono;
    private String cProvNumTelefono;
    private String cProvEstado;
    private String cProvObservacion;

    public String getcProvDireccion() {
        return cProvDireccion;
    }

    public void setcProvDireccion(String cProvDireccion) {
        this.cProvDireccion = cProvDireccion;
    }

    public String getcProvEmail() {
        return cProvEmail;
    }

    public void setcProvEmail(String cProvEmail) {
        this.cProvEmail = cProvEmail;
    }

    public String getcProvNombre() {
        return cProvNombre;
    }

    public void setcProvNombre(String cProvNombre) {
        this.cProvNombre = cProvNombre;
    }

    public String getcProvNroFax() {
        return cProvNroFax;
    }

    public void setcProvNroFax(String cProvNroFax) {
        this.cProvNroFax = cProvNroFax;
    }

    public String getcProvNumTelefono() {
        return cProvNumTelefono;
    }

    public void setcProvNumTelefono(String cProvNumTelefono) {
        this.cProvNumTelefono = cProvNumTelefono;
    }

    public String getcProvPaginaWeb() {
        return cProvPaginaWeb;
    }

    public void setcProvPaginaWeb(String cProvPaginaWeb) {
        this.cProvPaginaWeb = cProvPaginaWeb;
    }

    public String getcProvTipoTelefono() {
        return cProvTipoTelefono;
    }

    public void setcProvTipoTelefono(String cProvTipoTelefono) {
        this.cProvTipoTelefono = cProvTipoTelefono;
    }

    public int getnPRovNit() {
        return nPRovNit;
    }

    public void setnPRovNit(int nPRovNit) {
        this.nPRovNit = nPRovNit;
    }

    public int getnProvCodigo() {
        return nProvCodigo;
    }

    public void setnProvCodigo(int nProvCodigo) {
        this.nProvCodigo = nProvCodigo;
    }

    public String getcProvEstado() {
        return cProvEstado;
    }

    public void setcProvEstado(String cProvEstado) {
        this.cProvEstado = cProvEstado;
    }

    public String getcProvObservacion() {
        return cProvObservacion;
    }

    public void setcProvObservacion(String cProvObservacion) {
        this.cProvObservacion = cProvObservacion;
    }
}
