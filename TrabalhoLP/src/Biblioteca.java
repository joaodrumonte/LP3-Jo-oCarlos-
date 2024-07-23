import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        ((JPanel) frame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

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

        addStyledButton(frame, cadastroObrasButton);
        addStyledButton(frame, consultaObrasButton);
        addStyledButton(frame, cadastroUsuariosButton);
        addStyledButton(frame, consultaUsuariosButton);
        addStyledButton(frame, emprestimoButton);
        addStyledButton(frame, consultaEmprestimoButton);

        frame.setVisible(true);
    }

    private static void addStyledButton(JFrame frame, JButton button) {
        button.setFocusPainted(false);
        button.setBackground(new Color(0x2E8B57));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        frame.getContentPane().add(button);
    }

    private static void openCadastroObrasWindow() {
        JFrame frame = createStandardFrame("Cadastro de Obras");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField tituloField = new JTextField();
        JTextField autorField = new JTextField();
        JTextField anoField = new JTextField();
        JTextField tipoField = new JTextField();
        JButton cadastrarButton = new JButton("Cadastrar");

        addLabeledField(panel, "Título:", tituloField);
        addLabeledField(panel, "Autor:", autorField);
        addLabeledField(panel, "Ano de Publicação:", anoField);
        addLabeledField(panel, "Tipo de Obra:", tipoField);
        panel.add(new JLabel());
        panel.add(cadastrarButton);

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

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void openConsultaObrasWindow() {
        JFrame frame = createStandardFrame("Consulta de Títulos Disponíveis");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField consultaTituloField = new JTextField();
        JButton consultarButton = new JButton("Buscar");
        JList<Livro> listaObras = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaObras);

        panel.add(consultaTituloField, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(consultarButton, BorderLayout.SOUTH);

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

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void openCadastroUsuariosWindow() {
        JFrame frame = createStandardFrame("Cadastro de Usuários");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField cursoField = new JTextField();
        JTextField contatoField = new JTextField();
        JButton cadastrarButton = new JButton("Cadastrar");

        addLabeledField(panel, "Nome:", nomeField);
        addLabeledField(panel, "CPF:", cpfField);
        addLabeledField(panel, "Curso:", cursoField);
        addLabeledField(panel, "Contato:", contatoField);
        panel.add(new JLabel());
        panel.add(cadastrarButton);

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

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void openConsultaUsuariosWindow() {
        JFrame frame = createStandardFrame("Consulta de Usuários Disponíveis");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField consultaNomeField = new JTextField();
        JButton consultarButton = new JButton("Buscar");
        JList<Usuario> listaUsuarios = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaUsuarios);

        panel.add(consultaNomeField, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(consultarButton, BorderLayout.SOUTH);

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

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void openEmprestimoWindow() {
        JFrame frame = createStandardFrame("Realizar Empréstimos");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField emprestimoTituloField = new JTextField();
        JTextField emprestimoUsuarioField = new JTextField();
        JTextField dataEmprestimoField = new JTextField();
        JTextField dataDevolucaoField = new JTextField();
        JButton emprestarButton = new JButton("Emprestar");

        addLabeledField(panel, "Título da Obra:", emprestimoTituloField);
        addLabeledField(panel, "CPF do Usuário:", emprestimoUsuarioField);
        addLabeledField(panel, "Data de Empréstimo:", dataEmprestimoField);
        addLabeledField(panel, "Data de Devolução:", dataDevolucaoField);
        panel.add(new JLabel());
        panel.add(emprestarButton);

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

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void openConsultaEmprestimoWindow() {
        JFrame frame = createStandardFrame("Consulta de Empréstimos");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField consultaNomeField = new JTextField();
        JButton consultarButton = new JButton("Buscar");
        JList<Emprestimo> listaEmprestimo = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaEmprestimo);

        panel.add(consultaNomeField, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(consultarButton, BorderLayout.SOUTH);

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

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JFrame createStandardFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(Color.WHITE);
        return frame;
    }

    private static void addLabeledField(JPanel panel, String labelText, JTextField textField) {
        panel.add(new JLabel(labelText));
        panel.add(textField);
    }
}
