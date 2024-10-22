import java.util.Scanner;

public class Conversor {
    private final Moneda[] monedas;

    public Conversor(Moneda[] monedas){
        this.monedas = monedas;
    }

    public void conversion(int opcion){
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuanto dinero tiene en dolares?");
        double cantidad = Double.parseDouble(scanner.nextLine());

        double tasaCambio = 0;

        switch (opcion){
            case 1:
                tasaCambio = monedas[0].getTasaDeCambio();
                break;
            case 2:
                tasaCambio = 1/monedas[0].getTasaDeCambio();
                break;
            case 3:
                tasaCambio = monedas[1].getTasaDeCambio();
                break;
            case 4: // Peso argentino => Dólar
                tasaCambio = 1 / monedas[1].getTasaDeCambio();
                break;
            case 5: // Dólar => Real brasileño
                tasaCambio = monedas[2].getTasaDeCambio();
                break;
            case 6: // Real brasileño => Dólar
                tasaCambio = 1 / monedas[2].getTasaDeCambio();
                break;
            case 7: // Dólar => Peso colombiano
                tasaCambio = monedas[3].getTasaDeCambio();
                break;
            case 8: // Peso colombiano => Dólar
                tasaCambio = 1 / monedas[3].getTasaDeCambio();
                break;
            case 9: // Dólar => Bs venezolano
                tasaCambio = monedas[4].getTasaDeCambio();
                break;
            case 10: // Bs venezolano => Dólar
                tasaCambio = 1 / monedas[4].getTasaDeCambio();
                break;
            default:
                System.out.println("Opción no válida.");
                return;


        }
        double resultado = cantidad * tasaCambio;
        System.out.println("El monto equivalente es: " + resultado + " en la moneda deseada.");

    }
}
