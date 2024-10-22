import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ApiConsulta {

    private final String API_KEY = "e1d1245e49b4c39842c07639";
    private final String URL_BASE = " https://v6.exchangerate-api.com/v6/";

    public Moneda[] obtenerMonedas() {
        Moneda[] monedas = new Moneda[5];

        try{
            String urlString = URL_BASE + API_KEY + "/latest/USD";
            URL url = new URL(urlString);
            HttpURLConnection con =(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) !=null){
                response.append(inputLine);
            }
            in.close();

            String jsonResponse = response.toString();
            String[] monedasCodigos = {"PEN", "ARS", "BRL", "COP", "VES"};
            for (int i = 0; i < monedasCodigos.length; i++){
                double tasaDeCambio = parseTasaDeCambio(jsonResponse,monedasCodigos[i]);
                monedas[i] = new Moneda(monedasCodigos[i], tasaDeCambio);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return monedas;
    }

    private double parseTasaDeCambio(String jsonResponse, String moneda) {
        String key = "\"" + moneda + "\":";
        int index = jsonResponse.indexOf(key);
        if (index != -1){
            int startIndex = index + key.length();
            int endIndex = jsonResponse.indexOf(",", startIndex);
            String tasaString = jsonResponse.substring(startIndex, endIndex);
            return Double.parseDouble(tasaString);
        }
        return 0;
    }
}
