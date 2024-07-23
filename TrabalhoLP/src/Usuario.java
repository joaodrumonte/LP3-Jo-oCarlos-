public class Usuario {
    private String nome;
    private String cpf;
    private String curso;
    private String contato;

    public Usuario(String nome, String cpf, String curso, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCurso() {
        return curso;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return nome + " - " + cpf + " [" + curso + "] (" + contato + ")";
    }
}