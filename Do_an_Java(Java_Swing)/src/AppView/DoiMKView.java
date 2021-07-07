package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.Admin;
import QuanLyVanPP.DoiMKControl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

public class DoiMKView extends JFrame implements ActionListener {
	private Admin ad;
	private DoiMKControl controller;

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtGia;

	public DoiMKView() {
		setTitle("Quản Lý Tài Khoản");
		this.setResizable(false);
		this.setSize(500,300);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocation(400, 200);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(97, 51, 285, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(118, 17, 141, 20);
		panel.add(txtID);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(29, 17, 79, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTenHang = new JLabel("Pass World");
		lblTenHang.setBounds(29, 54, 79, 14);
		panel.add(lblTenHang);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(118, 54, 141, 20);
		panel.add(txtName);
		
		JLabel lblGiaTien = new JLabel("Account Control");
		lblGiaTien.setBounds(10, 85, 98, 14);
		panel.add(lblGiaTien);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(118, 85, 141, 20);
		panel.add(txtGia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 220, 476, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThmTiKhon = new JButton("Thêm Tài Khoản");
		btnThmTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertMK();
			}
		});
		btnThmTiKhon.setBounds(329, 11, 137, 23);
		panel_1.add(btnThmTiKhon);
		
		JButton btniMtKhu = new JButton("Đổi Mật Khẩu");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateMK();
			}
		});
		btniMtKhu.setBounds(10, 11, 115, 23);
		panel_1.add(btniMtKhu);
		
		JButton btnXaTiKhon = new JButton("Xóa Tài Khoản");
		btnXaTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteMK();
			}
		});
		btnXaTiKhon.setBounds(135, 11, 122, 23);
		panel_1.add(btnXaTiKhon);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setBounds(10, 8, 72, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(138, 8, 226, 42);
		contentPane.add(lblNewLabel_1);
		
		controller=new DoiMKControl();
		ad=new Admin();
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMenu frame = new FormMenu();
				frame.setVisible(true);
				setVisible(false);
			}
		});
	}
	

	public void insertMK() {
		ad.setUserName(this.txtID.getText());
		ad.setPassWorld(this.txtName.getText());
		ad.setUse(this.txtGia.getText());
		int cnt=controller.insertMK(ad);
		 if(cnt == 1)
			 JOptionPane.showMessageDialog(null,"Thêm tài khoản thành công!");
		 if(cnt==2)
			 JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");
		 if(cnt == 3)
			 JOptionPane.showMessageDialog(null,"Phân Quyền 0:Admin || 1:Nhân Viên");
	}
	
	public void deleteMK() {
		int cnt=controller.deleteMK(this.txtID.getText(), this.txtName.getText());
		if(cnt != 0) {
			 JOptionPane.showMessageDialog(null,"Đã xóa tài khoản khỏi danh sách!");
		 }else {
			 JOptionPane.showMessageDialog(null,"Sai tên Đăng nhập hoặc mật khẩu");
		 }
	}
	
	public void updateMK() {
		int cnt;
		ad.setUserName(this.txtID.getText());
		ad.setPassWorld(this.txtName.getText());
		
		cnt=controller.updateMK(ad, this.txtID.getText());
		if(cnt == 1) {
			 JOptionPane.showMessageDialog(null, "Mật Khẩu đã được cập nhật!");
		}
		if(cnt==2)
			JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");
		if(cnt == 0) {
			 JOptionPane.showMessageDialog(null, "Tên Tài Khoản hoặc mật khẩu sai");
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
