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
import QuanLyVanPP.HangHoaControl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

public class ChinhSuaHangHoa extends JFrame implements ActionListener {
	private HangHoa hh;
	private HangHoaControl controller;

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtGia;
	private JTextField txtTon;
	private JTextField txtBan;

	public ChinhSuaHangHoa() {
		setTitle("Chỉnh Sửa Hàng Hóa");
		this.setResizable(false);
		this.setSize(500,300);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocation(400, 200);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 74, 285, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(118, 17, 141, 20);
		panel.add(txtID);
		
		JLabel lblNewLabel = new JLabel("Mã hàng");
		lblNewLabel.setBounds(29, 17, 79, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTenHang = new JLabel("Tên hàng");
		lblTenHang.setBounds(29, 54, 79, 14);
		panel.add(lblTenHang);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(118, 54, 141, 20);
		panel.add(txtName);
		
		JLabel lblGiaTien = new JLabel("giá tiền");
		lblGiaTien.setBounds(29, 85, 79, 14);
		panel.add(lblGiaTien);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(118, 85, 141, 20);
		panel.add(txtGia);
		
		JLabel lblTonKho = new JLabel("tồn kho");
		lblTonKho.setBounds(29, 116, 79, 14);
		panel.add(lblTonKho);
		
		txtTon = new JTextField();
		txtTon.setColumns(10);
		txtTon.setBounds(118, 116, 141, 20);
		panel.add(txtTon);
		
		JLabel lblDaBan = new JLabel("Số lượng đã bán");
		lblDaBan.setBounds(10, 147, 98, 14);
		panel.add(lblDaBan);
		
		txtBan = new JTextField();
		txtBan.setColumns(10);
		txtBan.setBounds(118, 147, 141, 20);
		panel.add(txtBan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(305, 109, 181, 153);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsert = new JButton("Thêm hàng");
		btnInsert.setBounds(10, 25, 161, 23);
		panel_1.add(btnInsert);
		
		JButton btnDelete = new JButton("Xóa theo mã hàng");
		btnDelete.setBounds(10, 69, 161, 23);
		panel_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("Sửa theo mã hàng");
		btnUpdate.setBounds(10, 114, 161, 23);
		panel_1.add(btnUpdate);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setBounds(10, 8, 72, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1EC9nh S\u1EEDa H\u00E0ng H\u00F3a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(138, 8, 226, 42);
		contentPane.add(lblNewLabel_1);
		
		controller=new HangHoaControl();
		hh=new HangHoa();
		
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertHangHoa();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteHangHoaByID();
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateHangHoaByID();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HangHoaView frame = new HangHoaView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void insertHangHoa() {
		hh.setIdHang(this.txtID.getText());
		hh.setTenHang(this.txtName.getText());
		hh.setGiaBan(this.txtGia.getText());
		hh.setTonKho(this.txtTon.getText());
		hh.setDaBan(this.txtBan.getText());
		int cnt=controller.insertHangHoa(hh);
		 if(cnt == 1)/*nay*/	
			 JOptionPane.showMessageDialog(null,"Thêm mặc hàng thành công!");
		 if(cnt==2)/*nay*/	
			 JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");
	}
	
	public void deleteHangHoaByID() {
		int cnt=controller.deleteHangHoa(this.txtID.getText());
		if(cnt != 0) {
			 JOptionPane.showMessageDialog(null,"Đã xóa mặc hàng khỏi danh sách!");
		 }else {
			 JOptionPane.showMessageDialog(null,"Mã mặc hàng sai");
		 }
	}
	
	public void updateHangHoaByID() {
		int cnt;
			hh.setIdHang(this.txtID.getText());
			hh.setTenHang(this.txtName.getText());
			hh.setGiaBan(this.txtGia.getText());
			hh.setTonKho(this.txtTon.getText());
			hh.setDaBan(this.txtBan.getText());	
			
			cnt=controller.updateHangHoa(hh, this.txtID.getText());
			if(cnt == 1) {
				 JOptionPane.showMessageDialog(null, "Mặc hàng đã được cập nhật!");
			}
			if(cnt==2)
				JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");
			if(cnt == 0) {
				 JOptionPane.showMessageDialog(null, "Mã Sản phẩm không đúng");
			}
	}
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
