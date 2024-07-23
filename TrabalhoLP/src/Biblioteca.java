import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private static List<Livro> livros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Biblioteca::createAndShowMainGUI);
    }

    private static void createAndShowMainGUI() {
        JFrame frame = new JFrame("Sistema de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(5, 1));

        JButton cadastroObrasButton = new JButton("Cadastro de Obras");
        cadastroObrasButton.addActionListener(e -> openCadastroObrasWindow());

        JButton consultaObrasButton = new JButton("Consulta de Títulos Disponíveis");
        consultaObrasButton.addActionListener(e -> openConsultaObrasWindow());

        JButton cadastroUsuariosButton = new JButton("Cadastro de Usuários");
        cadastroUsuariosButton.addActionListener(e -> openCadastroUsuariosWindow());

        JButton consultaUsuariosButton = new JButton("Consulta de Usuários Disponíveis");
        consultaUsuariosButton.addActionListener(e -> openConsultaUsuariosWindow());

        JButton emprestimoButton = new JButton("Realizar Empréstimos");
        emprestimoButton.addActionListener(e -> openEmprestimoWindow());

        JButton consultaEmprestimoButton = new JButton("Consulta de Empréstimos");
        consultaEmprestimoButton.addActionListener(e -> openConsultaEmprestimoWindow());
        
        frame.getContentPane().add(cadastroObrasButton);
        frame.getContentPane().add(consultaObrasButton);
        frame.getContentPane().add(cadastroUsuariosButton);
        frame.getContentPane().add(consultaUsuariosButton);
        frame.getContentPane().add(emprestimoButton);
        frame.getContentPane().add(consultaEmprestimoButton);

        frame.setVisible(true);
    }

    private static void openCadastroObrasWindow() {
        JFrame frame = new JFrame("Cadastro de Obras");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JTextField tituloField = new JTextField();
        JTextField autorField = new JTextField();
        JTextField anoField = new JTextField();
        JTextField tipoField = new JTextField();
        JButton cadastrarButton = new JButton("Cadastrar");

        frame.add(new JLabel("Título:"));
        frame.add(tituloField);
        frame.add(new JLabel("Autor:"));
        frame.add(autorField);
        frame.add(new JLabel("Ano de Publicação:"));
        frame.add(anoField);
        frame.add(new JLabel("Tipo de Obra:"));
        frame.add(tipoField);
        frame.add(new JLabel());
        frame.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String autor = autorField.getText();
            int ano = Integer.parseInt(anoField.getText());
            String tipo = tipoField.getText();

            livros.add(new Livro(titulo, autor, ano, tipo));
            JOptionPane.showMessageDialog(frame, "Livro cadastrado com sucesso!");
            tituloField.setText("");
            autorField.setText("");
            anoField.setText("");
            tipoField.setText("");
        });

        frame.setVisible(true);
    }

    private static void openConsultaObrasWindow() {
        JFrame frame = new JFrame("Consulta de Títulos Disponíveis");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextField consultaTituloField = new JTextField();
        JButton consultarButton = new JButton("Buscar");
        JList<Livro> listaObras = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaObras);

        frame.add(consultaTituloField, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(consultarButton, BorderLayout.SOUTH);

        consultarButton.addActionListener(e -> {
            String consultaTitulo = consultaTituloField.getText().toLowerCase();
            DefaultListModel<Livro> model = new DefaultListModel<>();

            for (Livro livro : livros) {
                if (livro.getTitulo().toLowerCase().contains(consultaTitulo)) {
                    model.addElement(livro);
                }
            }

            listaObras.setModel(model);
        });

        frame.setVisible(true);
    }

    private static void openCadastroUsuariosWindow() {
        JFrame frame = new JFrame("Cadastro de Usuários");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField cursoField = new JTextField();
        JTextField contatoField = new JTextField();
        JButton cadastrarButton = new JButton("Cadastrar");

        frame.add(new JLabel("Nome:"));
        frame.add(nomeField);
        frame.add(new JLabel("CPF:"));
        frame.add(cpfField);
        frame.add(new JLabel("Curso:"));
        frame.add(cursoField);
        frame.add(new JLabel("Contato:"));
        frame.add(contatoField);
        frame.add(new JLabel());
        frame.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String curso = cursoField.getText();
            String contato = contatoField.getText();

            usuarios.add(new Usuario(nome, cpf, curso, contato));
            JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!");
            nomeField.setText("");
            cpfField.setText("");
            cursoField.setText("");
            contatoField.setText("");
        });

        frame.setVisible(true);
    }

    private static void openConsultaUsuariosWindow() {
        JFrame frame = new JFrame("Consulta de Usuários Disponíveis");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextField consultaNomeField = new JTextField();
        JButton consultarButton = new JButton("Buscar");
        JList<Usuario> listaUsuarios = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaUsuarios);

        frame.add(consultaNomeField, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(consultarButton, BorderLayout.SOUTH);

        consultarButton.addActionListener(e -> {
            String consultaNome = consultaNomeField.getText().toLowerCase();
            DefaultListModel<Usuario> model = new DefaultListModel<>();

            for (Usuario usuario : usuarios) {
                if (usuario.getNome().toLowerCase().contains(consultaNome)) {
                    model.addElement(usuario);
                }
            }

            listaUsuarios.setModel(model);
        });

        frame.setVisible(true);
    }

    private static void openEmprestimoWindow() {
        JFrame frame = new JFrame("Realizar Empréstimos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JTextField emprestimoTituloField = new JTextField();
        JTextField emprestimoUsuarioField = new JTextField();
        JTextField dataEmprestimoField = new JTextField();
        JTextField dataDevolucaoField = new JTextField();
        JButton emprestarButton = new JButton("Emprestar");

        frame.add(new JLabel("Título da Obra:"));
        frame.add(emprestimoTituloField);
        frame.add(new JLabel("CPF do Usuário:"));
        frame.add(emprestimoUsuarioField);
        frame.add(new JLabel("Data de Empréstimo:"));
        frame.add(dataEmprestimoField);
        frame.add(new JLabel("Data de Devolução:"));
        frame.add(dataDevolucaoField);
        frame.add(emprestarButton);

        emprestarButton.addActionListener(e -> {
            String titulo = emprestimoTituloField.getText();
            String cpf = emprestimoUsuarioField.getText();
            String dataEmprestimo = dataEmprestimoField.getText();
            String dataDevolucao = dataDevolucaoField.getText();

            Livro livro = livros.stream().filter(o -> o.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
            Usuario usuario = usuarios.stream().filter(u -> u.getCpf().equalsIgnoreCase(cpf)).findFirst().orElse(null);

            if (livro != null && usuario != null) {
                emprestimos.add(new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao));
                JOptionPane.showMessageDialog(frame, "Obra emprestada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(frame, "Obra ou Usuário não encontrado!");
            }
        });

        frame.setVisible(true);
    }

    private static void openConsultaEmprestimoWindow() {
        JFrame frame = new JFrame("Consulta de emprestimos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextField consultaNomeField = new JTextField();
        JButton consultarButton = new JButton("Buscar");
        JList<Emprestimo> listaEmprestimo = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaEmprestimo);

        frame.add(consultaNomeField, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(consultarButton, BorderLayout.SOUTH);

        consultarButton.addActionListener(e -> {
            String consultaNome = consultaNomeField.getText().toLowerCase();
            DefaultListModel<Emprestimo> model = new DefaultListModel<>();

            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getUsuario().getNome().toLowerCase().contains(consultaNome)) {
                    model.addElement(emprestimo);
                }
            }

            listaEmprestimo.setModel(model);
        });

        frame.setVisible(true);
    }

}   