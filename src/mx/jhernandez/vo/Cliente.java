package mx.jhernandez.vo;

/**
 *
 * @author Viruz
 */
public class Cliente {

    private int nCliCodigo;
    private String cCliNit;
    private String cCliCi;
    private String cCliNombre;
    private String cCliDireccion;
    private String cCliNumTelefono;
    private String cCliTipoTelefono;
    private String cCliNroFax;
    private String cCliEmail;
    private String cCliOtros;

    public String getcCliCi() {
        return cCliCi;
    }

    public void setcCliCi(String cCliCi) {
        this.cCliCi = cCliCi;
    }

    public String getcCliDireccion() {
        return cCliDireccion;
    }

    public void setcCliDireccion(String cCliDireccion) {
        this.cCliDireccion = cCliDireccion;
    }

    public String getcCliEmail() {
        return cCliEmail;
    }

    public void setcCliEmail(String cCliEmail) {
        this.cCliEmail = cCliEmail;
    }

    public String getcCliNombre() {
        return cCliNombre;
    }

    public void setcCliNombre(String cCliNombre) {
        this.cCliNombre = cCliNombre;
    }

    public String getcCliNumTelefono() {
        return cCliNumTelefono;
    }

    public void setcCliNumTelefono(String cCliNumTelefono) {
        this.cCliNumTelefono = cCliNumTelefono;
    }

    public String getcCliOtros() {
        return cCliOtros;
    }

    public void setcCliOtros(String cCliOtros) {
        this.cCliOtros = cCliOtros;
    }

    public String getcCliTipoTelefono() {
        return cCliTipoTelefono;
    }

    public void setcCliTipoTelefono(String cCliTipoTelefono) {
        this.cCliTipoTelefono = cCliTipoTelefono;
    }

    public int getnCliCodigo() {
        return nCliCodigo;
    }

    public void setnCliCodigo(int nCliCodigo) {
        this.nCliCodigo = nCliCodigo;
    }

    public String getcCliNit() {
        return cCliNit;
    }

    public void setcCliNit(String cCliNit) {
        this.cCliNit = cCliNit;
    }

    public String getcCliNroFax() {
        return cCliNroFax;
    }

    public void setcCliNroFax(String cCliNroFax) {
        this.cCliNroFax = cCliNroFax;
    }
}
