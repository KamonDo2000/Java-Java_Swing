package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class checkMaHD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String maHoaDon;
	
	public checkMaHD() {
		setTitle("Ra Hóa Đơn");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		this.setSize(322,250);
		this.setLocation(400, 200);
		
		textField = new JTextField();
		textField.setBounds(52, 119, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ra Hóa Đơn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maHoaDon = textField.getText();
				ShowHoaDonView fame = new ShowHoaDonView(maHoaDon);
				fame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(89, 150, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nhập mã Hóa Đơn");
		lblNewLabel.setBounds(52, 94, 136, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ra Hóa Đơn");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(89, 46, 186, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormMenu fame =new FormMenu();
				fame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 11, 68, 31);
		contentPane.add(btnNewButton_1);
	}
}
