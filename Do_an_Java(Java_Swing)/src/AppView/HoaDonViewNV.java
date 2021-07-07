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

import Object.HangHoa;
import Object.HoaDon;
import QuanLyVanPP.HoaDonControl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

public class HoaDonViewNV extends JFrame implements ActionListener {
	private HoaDonControl controller;
	private HoaDon hoaDon;
	private JPanel contentPane;
	private JTextField txtMaDon;
	private JTextField txtMaKhach;
	private JTextField txtMaHang;
	private JTextField txtSoLuong;

	public HoaDonViewNV() {
		setTitle("Thêm Hóa Đơn");
		this.setResizable(false);
		this.setSize(500,300);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocation(400, 200);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 61, 256, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtMaDon = new JTextField();
		txtMaDon.setColumns(10);
		txtMaDon.setBounds(130, 34, 111, 20);
		panel.add(txtMaDon);
		
		JLabel lblNewLabel = new JLabel("Mã Hóa Đơn");
		lblNewLabel.setBounds(10, 40, 84, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTenHang = new JLabel("Tên Khách Hàng");
		lblTenHang.setBounds(10, 77, 110, 14);
		panel.add(lblTenHang);
		
		txtMaKhach = new JTextField();
		txtMaKhach.setColumns(10);
		txtMaKhach.setBounds(130, 71, 111, 20);
		panel.add(txtMaKhach);
		
		JLabel lblGiaTien = new JLabel("Mã Hàng");
		lblGiaTien.setBounds(10, 108, 84, 14);
		panel.add(lblGiaTien);
		
		txtMaHang = new JTextField();
		txtMaHang.setColumns(10);
		txtMaHang.setBounds(130, 102, 111, 20);
		panel.add(txtMaHang);
		
		JLabel lblTonKho = new JLabel("Số Lượng");
		lblTonKho.setBounds(10, 139, 84, 14);
		panel.add(lblTonKho);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(130, 133, 111, 20);
		panel.add(txtSoLuong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 93, 193, 156);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsert = new JButton("Thêm Hóa Đơn");
		btnInsert.setBounds(10, 25, 165, 23);
		panel_1.add(btnInsert);
		
		JButton btnDelete = new JButton("Xóa theo mã đơn");
		btnDelete.setBounds(10, 69, 165, 23);
		panel_1.add(btnDelete);
		
		JButton btnNewButton = new JButton("CSDL Hóa Đơn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CSDLHoaDonViewNV fame =new CSDLHoaDonViewNV();
				fame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 103, 165, 23);
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setBounds(10, 8, 72, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Thêm Hóa Đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(138, 8, 226, 42);
		contentPane.add(lblNewLabel_1);
		
		controller=new HoaDonControl();
		hoaDon=new HoaDon();
		
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertHoaDon();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteHoaDonByID();
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMenuNhanVien frame = new FormMenuNhanVien();
				frame.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void insertHoaDon() {
		hoaDon.setMaHoaDon(this.txtMaDon.getText());
		hoaDon.setKhach(this.txtMaKhach.getText());
		hoaDon.setHang(this.txtMaHang.getText());
		hoaDon.setSoLuong(this.txtSoLuong.getText());
		int cnt=controller.insertHoaDon(hoaDon, this.txtMaHang.getText());
		if(cnt == 1)
			 JOptionPane.showMessageDialog(null,"Thêm Hóa Đơn Thành Công");
		if(cnt == 3)
			JOptionPane.showMessageDialog(null,"Mã Hàng Hóa Không Tồn Tại!!!");
		 if(cnt==2)	
			 JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");
	}
	
	public void deleteHoaDonByID() {
		int cnt=controller.deleteHoaDon(this.txtMaDon.getText());
		if(cnt != 0) {
			 JOptionPane.showMessageDialog(null,"Xóa Hóa Đơn Thành Công");
		 }else {
			 JOptionPane.showMessageDialog(null,"Mã hóa đơn sai");
		 }
	}
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
