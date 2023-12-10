package dstp7.model;
import java.util.ArrayList;
public class Regla4 implements IRegla{
    /*Viernes, sábado y domingo: solo en compras superiores a $15000,
    se aplica un 10% de descuento a todos los productos con más de tres unidades*/
        private static final double porcentaje = 0.1d;
        @Override
        public double calcularDescuento(Venta venta){
            if (venta.calcularTotal() < 15000) return 0;

            double descuento = 0;
            ArrayList<ProductoDescuento> productos = new ArrayList<>();
            for (LineaVenta detalle : venta.getDetalle()) {
                boolean existe = false;
                for (ProductoDescuento productoDescuento : productos) {
                    if (productoDescuento.tieneProducto(detalle.getProducto())) {
                        existe = true;
                        productoDescuento.sumarCantidad(detalle.getCantidad());
                        break;
                    }
                }
                if (!existe) {
                    productos.add(new ProductoDescuento(detalle.getProducto(), detalle.getCantidad()));
                }
            }
            for(ProductoDescuento productoDescuento : productos){
                if (productoDescuento.tieneCantidadMayorA(3))
                    descuento += productoDescuento.getPrecio() * productoDescuento.getCantidad() *  porcentaje;
            }
            return descuento;
        }
    }
