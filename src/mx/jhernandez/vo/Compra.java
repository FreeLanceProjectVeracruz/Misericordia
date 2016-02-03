package mx.jhernandez.vo;

import java.util.Date;

/**
 *
 * @author Viruz
 */
public class Compra {

    private int nComCodigo;
    private Producto producto;
    private Date cComFecha;
    private Proveedor proveedor;
    private int nComCantidad;
    private double nComPrecio;
    private double nComPrecioTotal;
    private String cComSerie;
    private String cComCodigo;

    public String getcComCodigo() {
        return cComCodigo;
    }

    public void setcComCodigo(String cComCodigo) {
        this.cComCodigo = cComCodigo;
    }

    public Date getcComFecha() {
        return cComFecha;
    }

    public void setcComFecha(Date cComFecha) {
        this.cComFecha = cComFecha;
    }

    public String getcComSerie() {
        return cComSerie;
    }

    public void setcComSerie(String cComSerie) {
        this.cComSerie = cComSerie;
    }

    public int getnComCantidad() {
        return nComCantidad;
    }

    public void setnComCantidad(int nComCantidad) {
        this.nComCantidad = nComCantidad;
    }

    public int getnComCodigo() {
        return nComCodigo;
    }

    public void setnComCodigo(int nComCodigo) {
        this.nComCodigo = nComCodigo;
    }

    public double getnComPrecio() {
        return nComPrecio;
    }

    public void setnComPrecio(double nComPrecio) {
        this.nComPrecio = nComPrecio;
    }

    public double getnComPrecioTotal() {
        return nComPrecioTotal;
    }

    public void setnComPrecioTotal(double nComPrecioTotal) {
        this.nComPrecioTotal = nComPrecioTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
