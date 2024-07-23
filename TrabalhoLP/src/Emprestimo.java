public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(Livro obra, Usuario usuario, String dataEmprestimo2, String dataDevolucao2) {
        this.livro = obra;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo2;
        this.dataDevolucao = dataDevolucao2;
    }

    public Livro getObra() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public String toString() {
        return livro.getTipo() + " : " + livro.getTitulo() + " pego por " + usuario.getNome()+" do CPF " + usuario.getCpf() + " de " + dataEmprestimo + " até " + dataDevolucao;
    }
}