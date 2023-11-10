package Carros;

import javax.swing.*;
import java.awt.*;

public class Carros extends JDialog {
        // labels
        JLabel lbTitulo, lbNome, lbCelular, lbEmail, lbMarca, lbModelo, lbCor, lbItens;
        // text fields
        JTextField txNome, txCelular, txEmail;
        // radio buttons
        JRadioButton[] b = new JRadioButton[4];
        // button group
        ButtonGroup bg;
        // combo box
        JComboBox<String> cbModelo, cbCor;
        // marcas
        String[] opcoesMarcas = {"Nissan", "BMW", "Jaguar", "Cadillac"};
        // modelos de cada marca
        String[][] opcoes = {{"GT-R", "Micra", "Skyline R34"}, {"X1", "Z4", "M4"}, {"XJ6", "S-Type", "F-Type"}, {"DeVille", "CT4", "Escalade"}};
        // colocar valores dos carros, mesma ordem das opcoes acima
        double[][] precosModelos = {{962315, 3901, 6700000}, {296950, 446568, 663950}, {389610, 149672, 581950}, {255000, 191484, 772000}};
        // valores dos adicionais na ordem de exibicao
        double[] precosAdicionais = {100000, 500, 1000, 400};
        // cores dos carros
        String[] opcoesCor = {"Rosa", "Cinza", "Azul", "Preto"};
        // imagens
        String[][][] imagens = {{ {"./rosanissangtr.jpg", "./rosanissanmicra.jpg","./rosanissanskyline.jpg"}, {"./rosabmwx1.jpg", "./rosabmwz4.jpg", "./rosabmwm4.jpg"}, {"./rosajaguarxj6.jpg", "./rosajaguarstype.jpg", "./rosajaguarftype.jpg"}, {"./rosacadillac1959.jpg", "./rosacadillacct4.jpg", "./rosacadillacescalade.jpg"} }, { {"./cinzanissangtr.jpg", "./cinzanissanmicra.jpg", "./cinzanissanskyline.jpg"}, {"./cinzabmwx1.jpg", "./cinzabmwz4.jpg", "./cinzabmwm4.jpg"}, {"./cinzajaguarxj6.jpg","./cinzajaguarstype.jpg","./cinzajaguarftype.jpg"}, {"./cinzacadillacdeville.jpg","./cinzacadillacct4.jpg","./cinzacadillacescalade.jpg"} }, { {"./azulnissagtr.jpg","./azulnissanmicra.jpg","./azulnissanskyline.jpg"}, {"./azulbmwx1.jpg","./azulbmwz4.jpg","./azulbmwm4.jpg"}, {"./azuljaguarxj6.jpg","./azuljaguarstype.jpg","./azuljaguarftype.jpeg"}, {"./azulcadillacdeville.jpg","./azulcadillacct4.jpg","./azulcadillacescalade.jpg"} }, { {"./pretonissangtr.jpg","./pretonissanmicra.jpg","./pretonissanskyline.jpg"}, {"./pretobmwx1.jpg","./pretobmwz4.jpeg","./pretobmwm4.jpg"}, {"./pretojaguarxj6.jpg", "./pretojaguarstype.jpg", "./pretojaguarftype.jpeg"}, {"./pretocadillacdeville.jpg", "./pretocadillacct4.jpg", "./pretocaadillacescalade.jpeg"} }};
        // indexes para a matriz tridimensional de imagens
        int marcaIndex, modeloIndex, corIndex;
        // check box
        JCheckBox[] c = new JCheckBox[4];
        // botoes
        JButton btVerImg, btOrcamento, btCancelar;
        // cor de fundo
        JLabel background;
        Color bgComponents = new Color(255, 233, 247);
        // moldura para imagem
        JLabel moldura;
        public Carros() {
                // configs
                this.setLayout(null);
                this.setSize(520, 250);
                this.setLocationRelativeTo(null);
                // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setResizable(false);
                this.setTitle("Hello Cars");
                this.setIconImage(new ImageIcon(getClass().getResource("./images/icon.png")).getImage());
                this.setModal(true);

                // titulo
                lbTitulo = new JLabel("Orcamento do seu carro");
                lbTitulo.setBounds(10, 10, 150, 20);
                add(lbTitulo);

                // nome
                lbNome = new JLabel("Nome:");
                lbNome.setBounds(10, 35, 40, 20);
                txNome = new JTextField();
                txNome.setBounds(55, 35, 100, 20);
                add(txNome);
                add(lbNome);

                // celular
                lbCelular = new JLabel("Celular:");
                lbCelular.setBounds(170, 35, 50, 20);
                txCelular = new JTextField();
                txCelular.setBounds(225, 35, 100, 20);
                add(txCelular);
                add(lbCelular);

                // email
                lbEmail = new JLabel("Email:");
                lbEmail.setBounds(350, 35, 50, 20);
                txEmail = new JTextField();
                txEmail.setBounds(395, 35, 100, 20);
                add(txEmail);
                add(lbEmail);

                // marcas
                lbMarca = new JLabel("Marcas:");
                lbMarca.setBounds(10, 60, 50, 20);
                add(lbMarca);
                for (int i = 0; i < b.length; i++) {
                        b[i] = new JRadioButton(opcoesMarcas[i]);
                }
                b[0].setBounds(60, 60, 70, 20);
                b[1].setBounds(130, 60, 60, 20);
                b[2].setBounds(190, 60, 70, 20);
                b[3].setBounds(260, 60, 75, 20);
                bg = new ButtonGroup();
                for (JRadioButton jRadioButton : b) {
                        jRadioButton.setBackground(bgComponents);
                        bg.add(jRadioButton);
                        add(jRadioButton);
                }

                // modelos
                lbModelo = new JLabel("Modelos:");
                lbModelo.setBounds(10, 85, 60, 20);
                add(lbModelo);
                // atualizando modelo ao mudar marca
                for (int i = 0; i < b.length; i++) {
                        int j = i;
                        b[i].addActionListener(e -> {
                                try {
                                        cbModelo.removeAllItems();
                                } catch (Exception ignored) {
                                        cbModelo = new JComboBox<>();
                                }
                                for (int k = 0; k < opcoes[j].length; k++) {
                                      cbModelo.addItem(opcoes[j][k]);
                                }
                                cbModelo.setBounds(70, 85, 90, 20);
                                cbModelo.setBackground(Color.WHITE);
                                add(cbModelo);
                                add(background);
                                revalidate();
                                repaint();
                        });
                }

                // cores
                lbCor = new JLabel("Cores:");
                lbCor.setBounds(10, 110, 60, 20);
                add(lbCor);
                cbCor = new JComboBox<>(opcoesCor);
                cbCor.setBounds(70, 110, 90, 20);
                cbCor.setBackground(Color.WHITE);
                add(cbCor);

                // fazendo imagem do carro aparecer ao clicar no botao
                btVerImg = new JButton("Ver imagem");
                btVerImg.setBounds(10, 136, 110, 18);
                add(btVerImg);

                btVerImg.addActionListener(e -> {
                        // pegando index da marca
                        for (int i = 0; i < opcoesMarcas.length; i++) {
                                if (b[i].isSelected()) {
                                        marcaIndex = i;
                                }
                        }
                        // pegando index do modelo
                        if (cbModelo != null) {
                                for (int j = 0; j < opcoes[marcaIndex].length; j++) {
                                        if (cbModelo.getSelectedItem() == opcoes[marcaIndex][j]) {
                                                modeloIndex = j;
                                        }
                                }
                        }
                        // pegando index da cor
                        for (int k = 0; k < opcoesCor.length; k++) {
                                if (cbCor.getSelectedItem() == opcoesCor[k]) {
                                        corIndex = k;
                                }
                        }
                        // tentando atualizar imagem
                        ImageIcon img;
                        try {
                                remove(moldura);
                                img = new ImageIcon(getClass().getResource("./images/" + imagens[corIndex][marcaIndex][modeloIndex]));
                        } catch (Exception exception) {
                                // caso nada seja definido seta uma imagem padrao
                                img = new ImageIcon(getClass().getResource("./images/padrao.png"));
                        }
                        moldura = new JLabel("", img, JLabel.CENTER);
                        moldura.setBounds(330, 65, 160, 80);
                        add(moldura);
                        add(background);
                        repaint();
                        revalidate();
                });

                // adicionais
                lbItens = new JLabel("Itens Adicionais:");
                lbItens.setBounds(10, 155, 120, 20);
                add(lbItens);
                c[0] = new JCheckBox("Personalizado");
                c[1] = new JCheckBox("Chofer");
                c[2] = new JCheckBox("Motorista");
                c[3] = new JCheckBox("Abanador");
                c[0].setBounds(130, 155, 110, 20);
                c[1].setBounds(240, 155, 70, 20);
                c[2].setBounds(310, 155, 90, 20);
                c[3].setBounds(400, 155, 90, 20);
                for (JCheckBox jCheckBox : c) {
                        jCheckBox.setBackground(bgComponents);
                        add(jCheckBox);
                }

                // botoes de envio/cancelamento
                btOrcamento = new JButton("Calcular");
                btOrcamento.setBounds(10, 180, 90, 20);
                btCancelar = new JButton("Cancelar");
                btCancelar.setBounds(110, 180, 90, 20);
                add(btOrcamento);
                add(btCancelar);

                // calculo do orcamento ao clicar em calcular
                btOrcamento.addActionListener(e -> {

                        String nome = txNome.getText();
                        String email = txEmail.getText();
                        String telefone = txCelular.getText();
                        String modeloCarro = (String) cbModelo.getSelectedItem();
                        String cor = (String) cbCor.getSelectedItem();
                        int modelo = 0, marca = 0;
                        double custoAdicional = 0;
                        for (int i = 0; i < b.length; i++) {
                                if (b[i].isSelected()) {
                                        marca = i;
                                }
                        }
                        for (int i = 0; i < opcoes[marca].length; i++) {
                                if (cbModelo.getSelectedItem() == opcoes[marca][i]) {
                                        modelo = i;
                                }
                        }
                        for (int i = 0; i < c.length; i++) {
                                if (c[i].isSelected()) {
                                        custoAdicional += precosAdicionais[i];
                                }
                        }
                        double custo = precosModelos[marca][modelo];
                        double total = custo + custoAdicional;
                        JOptionPane.showMessageDialog(null, "<html><p style='color: #4c338a'>Seus dados</p><p>Nome: <span style='font-weight: 100'>" + nome + "</span></p><p>E-mail: <span style='font-weight: 100'>" + email + "</span></p><p>Telefone: <span style='font-weight: 100'>" + telefone + "</span></p><br><p style='color: #4c338a'>Seu orcamento</p><p>" + modeloCarro + " " + cor + ": <span style='font-weight: 100'>R$ " + custo + "</span></p><p>Adicionais: <span style='font-weight: 100'>R$ " + custoAdicional + "</span></p><p>Total: <span style='font-weight: 100'>R$ " + total + "</span></p></html>", "Valor final", JOptionPane.INFORMATION_MESSAGE);
                });
                // botao para cancelar
                btCancelar.addActionListener(e -> System.exit(0));

                // plano de fundo
                ImageIcon img = new ImageIcon(getClass().getResource("./images/background.png"));
                background = new JLabel("", img, SwingConstants.CENTER);
                background.setBounds(0, 0, 520, 250);
                add(background);
        }
        
}