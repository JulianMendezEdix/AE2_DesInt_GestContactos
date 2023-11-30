package principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactManager extends JFrame {

    private static final long serialVersionUID = 1L;
	private JFrame frame;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	setDefaultFont(new Font("Arial", Font.ITALIC, 12));
                ContactManager window = new ContactManager();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    private static void setDefaultFont(Font font) {
        UIManager.put("Button.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
    }

    public ContactManager() {
        initialize();
        
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
        setTitle("MI PRIMERA GUI");
        
        ImageIcon icon = new ImageIcon("ruta/a/tu/icono.png");
        frame.setIconImage(icon.getImage());

        String[] columnNames = {"Nombre", "Teléfono"};
        Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.yellow);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        JButton addButton = createCustomButton("Añadir");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddContactWindow((DefaultTableModel) table.getModel());
            }
        });
        panel.add(addButton);

        JButton editButton = createCustomButton("Editar");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    new EditContactWindow((DefaultTableModel) table.getModel(), selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleccione un contacto para editar");
                }
            }
        });
        panel.add(editButton);

        JButton deleteButton = createCustomButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleccione un contacto para eliminar");
                }
            }
        });
        panel.add(deleteButton);
    }

    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLUE); // Color de fondo
        button.setForeground(Color.WHITE); // Color del texto
        button.setFont(new Font("Times new roman", Font.BOLD, 14)); // Tipo de letra
        button.setBorder(BorderFactory.createRaisedBevelBorder()); // Borde
        return button;
    }
}


