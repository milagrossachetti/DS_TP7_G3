package dstp7.model;
public class Rubro {
  public Rubro(){}

  public Rubro(int codigo, String descripcion){
     this.codigo = codigo;
     this.descripcion = descripcion;
  }
  private int codigo;
  private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object object){
        Rubro rubro = (Rubro) object;
        return codigo == rubro.codigo && descripcion == rubro.descripcion;
    }
}
