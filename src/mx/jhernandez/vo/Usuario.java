package mx.jhernandez.vo;

/**
 *
 * @author Martin
 */
public class Usuario {

    private int nUsuCodigo;
    private String cUsuId;
    private String cUsuClave;
    private Personal personal;
    private String cUsuEstado;

    public String getcUsuClave() {
        return cUsuClave;
    }

    public void setcUsuClave(String cUsuClave) {
        this.cUsuClave = cUsuClave;
    }

    public String getcUsuId() {
        return cUsuId;
    }

    public void setcUsuId(String cUsuId) {
        this.cUsuId = cUsuId;
    }

    public int getnUsuCodigo() {
        return nUsuCodigo;
    }

    public void setnUsuCodigo(int nUsuCodigo) {
        this.nUsuCodigo = nUsuCodigo;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getcUsuEstado() {
        return cUsuEstado;
    }

    public void setcUsuEstado(String cUsuEstado) {
        this.cUsuEstado = cUsuEstado;
    }
}
