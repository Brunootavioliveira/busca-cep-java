package br.com.bruno;

public record CepOmdb (String cep, String logradouro, String bairro, String localidade, String uf, String estado)
{
    @Override
    public String toString() {
        return "Cep: " + cep + "\n" +
                "Logradora: " + logradouro + "\n" +
                "Bairro: " + bairro +
                "\nLocalidade: " + localidade +
                "\nUF: " + uf +
                "\nEstado: " + estado;
    }
}
