public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private String tipo;

    public Livro(String titulo, String autor, int ano, String tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + ano + ") [" + tipo + "]";
    }
}