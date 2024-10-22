public class Moneda {
    private String codigo;
    private double tasaDeCambio;

    public Moneda(String codigo, double tasaDeCambio){
        this.codigo = codigo;
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getCodigo(){return codigo; }

    public double getTasaDeCambio() {return  tasaDeCambio; }


}
