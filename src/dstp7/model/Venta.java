package dstp7.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Venta {
    private final Calendar fecha;
    private final ArrayList<LineaVenta> detalle;

    public Venta(){
        fecha = Calendar.getInstance();
        detalle = new ArrayList<>();
    }
    public void agregarDetalle(Producto producto, int cantidad) {
        LineaVenta lv = new LineaVenta(producto, cantidad);
        detalle.add(lv);
    }

    public ArrayList<LineaVenta> getDetalle() {
        return detalle;
    }

    public double calcularDescuentos() {
        IRegla regla = Negocio.getInstance().getReglaParaDia(fecha);
        if(regla==null) return 0d;
        return regla.calcularDescuento(this);
    }

    public double calcularTotal() {
        double total = 0d;
        if (detalle.isEmpty()) return total;
        for (LineaVenta lv : detalle) {
            total += lv.subTotal();
        }
        return total;
    }

    public double calcularTotalGeneral() {
        return calcularTotal() - calcularDescuentos();
    }
}
