package AppView;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Object.Admin;
import QuanLyVanPP.QuanLyAccControl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	
	public FormLogin() {
		setTitle("Login");

		setBounds(100, 100, 412, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("User Name");
			lblNewLabel.setBounds(60, 22, 74, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Pass World");
			lblNewLabel_1.setBounds(60, 60, 74, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			textField.setBounds(144, 19, 158, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 57, 158, 20);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						Admin admin = new Admin();
						admin.setUserName(textField.getText());
						admin.setPassWorld(passwordField.getText());
						
						QuanLyAccControl qlac = new QuanLyAccControl();
						if(qlac.checkpass(admin)==0)
							JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không chính xác, vui lòng kiểm tra lại !!!");
						if(qlac.checkpass(admin)==1) {
							FormMenu frame = new FormMenu();
							frame.setVisible(true);
							setVisible(false);
						}
						if(qlac.checkpass(admin)==2) {
							FormMenuNhanVien frame = new FormMenuNhanVien();
							frame.setVisible(true);
							setVisible(false);
						}
						if(qlac.checkpass(admin)==3)
							JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ user name và pass world");
					}
				});
				okButton.setActionCommand("OK");
				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(400, 300);
	}
	
}
