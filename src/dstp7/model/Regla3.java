package dstp7.model;
import java.util.ArrayList;
public class Regla3 implements IRegla{
    /*Jueves: llevando hasta 5 unidades iguales en Lacteos o Verduras, desde la segunda y hasta la quinta unidad
    se aplica un 30% de descuento a cada una*/
        private static final double porcentaje = 0.3d;
        private final Rubro rubro1;
        private final Rubro rubro2;
        public Regla3(Rubro rubro1, Rubro rubro2){
            this.rubro1 = rubro1;
            this.rubro2 = rubro2;
        }
        @Override
        public double calcularDescuento(Venta venta){
            double descuento = 0;
            ArrayList<ProductoDescuento> productos = new ArrayList<>();
            for (LineaVenta detalle : venta.getDetalle()) {
                if (detalle.tieneRubro(rubro1) || detalle.tieneRubro(rubro2)) {
                    boolean existe = false;
                    for (ProductoDescuento productoDescuento : productos) {
                        if (productoDescuento.tieneProducto(detalle.getProducto())) {
                            existe = true;
                            productoDescuento.sumarCantidad(detalle.getCantidad());
                            break;
                        }
                    }
                    if (existe) {
                        productos.add(new ProductoDescuento(detalle.getProducto(), detalle.getCantidad()));
                    }
                }
            }

            for(ProductoDescuento productoDescuento : productos)
            {
                if(productoDescuento.tieneCantidadEntre(2,5))
                    descuento += productoDescuento.getPrecio() * (productoDescuento.getCantidad() - 1) * porcentaje;
            }
            return descuento;
        }
    }
