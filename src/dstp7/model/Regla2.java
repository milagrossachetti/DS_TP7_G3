package dstp7.model;

public class Regla2 implements IRegla {
    /*Martes y miércoles: en compras superiores a $5000 y hasta $10000(inclusive)
     * se aplica un 3% de descuento al total de la venta. En compras superiores a $10000 y hasta $250000 (inclusive), se aplica un 5%.
     * En compras superiores a $25000 corresponde un 6,5%*/
    private static final double porcentajeMenor = 0.03d;
    private static final double porcentajeIntermedio = 0.05d;
    private static final double porcentajeMayor = 0.065d;

    @Override
    public double calcularDescuento(Venta venta) {
        double total = venta.calcularTotal();

        if (total <= 5000) return 0d;

        if (total <= 10000)
            return total * porcentajeMenor;

        if (total <= 25000)
            return total * porcentajeIntermedio;

        return total * porcentajeMayor;
    }
}
