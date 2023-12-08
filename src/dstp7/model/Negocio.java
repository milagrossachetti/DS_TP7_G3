package dstp7.model;

import java.util.Calendar;

public class Negocio {
    private static volatile Negocio instance;
    private final IRegla[] reglas = new IRegla[7];
    private Negocio(){}

    public static Negocio getInstance(){
        if(instance != null )
            return  instance;
        synchronized (Negocio.class){
            if(instance == null)
                instance = new Negocio();
            return instance;
        }
    }

    public void setReglaParaDia(DiaSemana dia, IRegla regla){
        reglas[dia.getValue()] = regla;
    }

    public IRegla getReglaParaDia(Calendar fecha){
        if(fecha == null) throw new RuntimeException("Fecha no puede ser null");
        int dia = fecha.get(Calendar.DAY_OF_WEEK);
        return reglas[dia];
    }
}
