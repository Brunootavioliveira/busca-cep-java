package br.com.bruno;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class BuscaCep {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o CEP para busca: ");
        String cep = leitura.nextLine();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder().create();

            CepOmdb cepConvertido = gson.fromJson(json, CepOmdb.class);

            System.out.println(cepConvertido);

        } catch (IllegalStateException | JsonSyntaxException e) {
            System.out.println("Endereço não encontrado a partir desse CEP");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
