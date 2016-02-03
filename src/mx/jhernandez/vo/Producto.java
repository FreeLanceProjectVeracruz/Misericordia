package mx.jhernandez.vo;

/**
 *
 * @author Viruz
 */
public class Producto {

    private int nProCodigo;
    private String cProNombre;
    private int nProCantidad;
    private double nPropRecioCompra;
    private double nProPRecioVenta;
    private String nProUtilidad;
    private String cProDescripcion;
    private Categoria categoria;
    private String cProMarca;
    private String cProEstado;
    private String cCodProProv;

    public int getnProCantidad() {
        return nProCantidad;
    }

    public void setnProCantidad(int nProCantidad) {
        this.nProCantidad = nProCantidad;
    }

    public String getcProDescripcion() {
        return cProDescripcion;
    }

    public void setcProDescripcion(String cProDescripcion) {
        this.cProDescripcion = cProDescripcion;
    }

    public String getcProMarca() {
        return cProMarca;
    }

    public void setcProMarca(String cProMarca) {
        this.cProMarca = cProMarca;
    }

    public String getcProNombre() {
        return cProNombre;
    }

    public void setcProNombre(String cProNombre) {
        this.cProNombre = cProNombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getnProCodigo() {
        return nProCodigo;
    }

    public void setnProCodigo(int nProCodigo) {
        this.nProCodigo = nProCodigo;
    }

    public double getnProPRecioVenta() {
        return nProPRecioVenta;
    }

    public void setnProPRecioVenta(double nProPRecioVenta) {
        this.nProPRecioVenta = nProPRecioVenta;
    }

    public String getnProUtilidad() {
        return nProUtilidad;
    }

    public void setnProUtilidad(String nProUtilidad) {
        this.nProUtilidad = nProUtilidad;
    }

    public double getnPropRecioCompra() {
        return nPropRecioCompra;
    }

    public void setnPropRecioCompra(double nPropRecioCompra) {
        this.nPropRecioCompra = nPropRecioCompra;
    }

    public String getcProEstado() {
        return cProEstado;
    }

    public void setcProEstado(String cProEstado) {
        this.cProEstado = cProEstado;
    }

    public String getcCodProProv() {
        return cCodProProv;
    }

    public void setcCodProProv(String cCodProProv) {
        this.cCodProProv = cCodProProv;
    }
}
