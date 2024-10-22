import java.util.Calendar;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){
            System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS");
            System.out.println("TENEMOS LAS SIGUIENTES OPCIONES A CONVERTIR");
            System.out.println(" 1.  Dolar => Sol Peruano");
            System.out.println(" 2.  Sol Peruano => Dolar");
            System.out.println(" 3.  Dolar => Peso Argentino");
            System.out.println(" 4.  Peso Argentino => Dolar");
            System.out.println(" 5.  Dolar => Real Brasileño");
            System.out.println(" 6.  Real Brasileño => Dolar");
            System.out.println(" 7.  Dolar => Peso Colombiano");
            System.out.println(" 8.  Peso Colombiano=> Dolar");
            System.out.println(" 9.  Dolar => Bs Venezolano");
            System.out.println(" 10. Bs Venezolano => Dolar");
            System.out.println(" 11. Salir");
            System.out.println("Por favor elija la opción que desea convertir");

            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 11) {
                continuar = false;
                int hora = java.util.Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (hora < 12){
                    System.out.println("Buenos dias!");
                }else{
                    System.out.println("Buenas tardes!");
                }
                break;
            }
            ApiConsulta apiConsulta = new ApiConsulta();
            Moneda[] monedas = apiConsulta.obtenerMonedas();

            Conversor conversor = new Conversor(monedas);
            conversor.conversion(opcion);

            System.out.println("¿Desea seguir realizando conversiones? (si/no): ");
            String respuesta = scanner.nextLine();
            if(!respuesta.equalsIgnoreCase("si")){
                continuar = false;
                int hora = java.util.Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (hora < 12){
                System.out.println("¡BUENOS DIAS!");
            }else {
                System.out.println("BUENAS TARDES");

            }
        }
        }
        scanner.close();
    }
    }

