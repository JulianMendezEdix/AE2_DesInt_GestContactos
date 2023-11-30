package principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class AddContactWindow {
	
    private JFrame frame;
    private JTextField nameField;
    private JTextField phoneField;
    private DefaultTableModel model;

    public AddContactWindow(DefaultTableModel model) {
        this.model = model;
        initialize();
    }

    private void initialize() {
    	
        frame = new JFrame();
        frame.setBounds(150, 150, 340, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());


        frame.getContentPane().add(new JLabel("Nombre"));
        nameField = new JTextField();
        nameField.setColumns(10);
        frame.getContentPane().add(nameField);

        frame.getContentPane().add(new JLabel("Tel"));
        phoneField = new JTextField();
        phoneField.setColumns(10);
        frame.getContentPane().add(phoneField);
        
        
        
        JLabel messageLabel = new JLabel("Introduzca los detalles del contacto.");
        frame.getContentPane().add(messageLabel);

        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                if (!name.isEmpty() && !phone.isEmpty()) {
                    model.addRow(new Object[]{name, phone});
                    frame.dispose();
                } else {
                    messageLabel.setText("Por favor, complete todos los campos.");
                }
            }
        });
        frame.getContentPane().add(addButton);

        frame.setVisible(true);
    }
}
