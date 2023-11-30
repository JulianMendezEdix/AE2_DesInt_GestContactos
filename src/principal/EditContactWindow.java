package principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class EditContactWindow {
    private JFrame frame;
    private JTextField nameField;
    private JTextField phoneField;
    private DefaultTableModel model;
    private int selectedRow;

    public EditContactWindow(DefaultTableModel model, int selectedRow) {
        this.model = model;
        this.selectedRow = selectedRow;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(150, 150, 340, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        frame.getContentPane().add(new JLabel("Nombre"));
        nameField = new JTextField(model.getValueAt(selectedRow, 0).toString(), 10);
        frame.getContentPane().add(nameField);

        frame.getContentPane().add(new JLabel("Tel"));
        phoneField = new JTextField(model.getValueAt(selectedRow, 1).toString(), 10);
        frame.getContentPane().add(phoneField);

        JButton editButton = new JButton("Editar");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setValueAt(nameField.getText(), selectedRow, 0);
                model.setValueAt(phoneField.getText(), selectedRow, 1);
                frame.dispose();
            }
        });
        frame.getContentPane().add(editButton);

        frame.setVisible(true);
    }
}
