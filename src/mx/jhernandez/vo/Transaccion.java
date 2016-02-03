package mx.jhernandez.vo;

/**
 *
 * @author Viruz
 */
public class Transaccion {

    private int nTraCodigo;
    private Venta venta;
    private Producto producto;
    private Double nTraPrecio;
    private int ntraCantidad;
    private Double nTraPrecioTotal;

    public int getnTraCodigo() {
        return nTraCodigo;
    }

    public void setnTraCodigo(int nTraCodigo) {
        this.nTraCodigo = nTraCodigo;
    }

    public Double getnTraPrecio() {
        return nTraPrecio;
    }

    public void setnTraPrecio(Double nTraPrecio) {
        this.nTraPrecio = nTraPrecio;
    }

    public Double getnTraPrecioTotal() {
        return nTraPrecioTotal;
    }

    public void setnTraPrecioTotal(Double nTraPrecioTotal) {
        this.nTraPrecioTotal = nTraPrecioTotal;
    }

    public int getNtraCantidad() {
        return ntraCantidad;
    }

    public void setNtraCantidad(int ntraCantidad) {
        this.ntraCantidad = ntraCantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
