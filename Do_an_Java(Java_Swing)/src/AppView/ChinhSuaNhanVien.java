package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Object.NhanVien;
import QuanLyVanPP.NhanVienControl;

public class ChinhSuaNhanVien extends JFrame {

	private JPanel contentPane1;

	private NhanVien std;
	private NhanVienControl controller;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtFullname;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtGender;
	private JTextField txtPhone;
	private JTextField txtTime;
	private JButton btnNewButton;
	private JTextField txtSalary;

	public ChinhSuaNhanVien() {
		setTitle("Chỉnh Sửa Nhân Viên");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		

		setBounds(100, 100, 426, 300);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{173, 222, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane1.setLayout(gbl_contentPane);
		this.setLocation(400, 200);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NhanVienView frame = new NhanVienView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		contentPane1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Chỉnh Sửa Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtID = new JTextField();
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.gridwidth = 2;
		gbc_txtID.insets = new Insets(0, 0, 5, 5);
		gbc_txtID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtID.gridx = 1;
		gbc_txtID.gridy = 1;
		contentPane1.add(txtID, gbc_txtID);
		txtID.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Họ Tên");
		GridBagConstraints gbc_lblStudentName = new GridBagConstraints();
		gbc_lblStudentName.anchor = GridBagConstraints.EAST;
		gbc_lblStudentName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentName.gridx = 0;
		gbc_lblStudentName.gridy = 2;
		contentPane1.add(lblStudentName, gbc_lblStudentName);
		
		txtFullname = new JTextField();
		GridBagConstraints gbc_txtFullname = new GridBagConstraints();
		gbc_txtFullname.gridwidth = 2;
		gbc_txtFullname.anchor = GridBagConstraints.NORTH;
		gbc_txtFullname.insets = new Insets(0, 0, 5, 5);
		gbc_txtFullname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFullname.gridx = 1;
		gbc_txtFullname.gridy = 2;
		contentPane1.add(txtFullname, gbc_txtFullname);
		txtFullname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tuổi");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtAge = new JTextField();
		GridBagConstraints gbc_txtAge = new GridBagConstraints();
		gbc_txtAge.gridwidth = 2;
		gbc_txtAge.anchor = GridBagConstraints.NORTH;
		gbc_txtAge.insets = new Insets(0, 0, 5, 5);
		gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAge.gridx = 1;
		gbc_txtAge.gridy = 3;
		contentPane1.add(txtAge, gbc_txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Giới Tính");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtGender = new JTextField();
		GridBagConstraints gbc_txtGender = new GridBagConstraints();
		gbc_txtGender.gridwidth = 2;
		gbc_txtGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGender.gridx = 1;
		gbc_txtGender.gridy = 4;
		contentPane1.add(txtGender, gbc_txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Địa Chỉ Liên Lạc");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtAddress = new JTextField();
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.gridwidth = 2;
		gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.gridx = 1;
		gbc_txtAddress.gridy = 5;
		contentPane1.add(txtAddress, gbc_txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện thoại");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.gridwidth = 2;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 6;
		contentPane1.add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);
		std=new NhanVien();
		controller= new NhanVienControl();
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNhanVien();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Lương Tháng");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtSalary = new JTextField();
		txtSalary.setText("");
		GridBagConstraints gbc_txtSalary = new GridBagConstraints();
		gbc_txtSalary.gridwidth = 2;
		gbc_txtSalary.insets = new Insets(0, 0, 5, 5);
		gbc_txtSalary.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSalary.gridx = 1;
		gbc_txtSalary.gridy = 7;
		contentPane1.add(txtSalary, gbc_txtSalary);
		txtSalary.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày Vào Làm");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		contentPane1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtTime = new JTextField();
		GridBagConstraints gbc_txtTime = new GridBagConstraints();
		gbc_txtTime.gridwidth = 2;
		gbc_txtTime.insets = new Insets(0, 0, 5, 5);
		gbc_txtTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTime.gridx = 1;
		gbc_txtTime.gridy = 8;
		contentPane1.add(txtTime, gbc_txtTime);
		txtTime.setColumns(10);
		
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 9;
		contentPane1.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNhanVien();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 9;
		contentPane1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnU = new JButton("Sửa");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateNhanVien();
			}
		});
		GridBagConstraints gbc_btnU = new GridBagConstraints();
		gbc_btnU.insets = new Insets(0, 0, 0, 5);
		gbc_btnU.gridx = 2;
		gbc_btnU.gridy = 9;
		contentPane1.add(btnU, gbc_btnU);
	}
	public void createNhanVien(){
		std.setMaNV(this.txtID.getText());
		std.setName(this.txtFullname.getText());
		std.setAge(this.txtAge.getText());
		std.setGender(this.txtGender.getText());
		std.setAddress(this.txtAddress.getText());
		std.setPhone(this.txtPhone.getText());
		std.setSalary(this.txtSalary.getText());
		std.setTime(this.txtTime.getText());
		int cnt=controller.insertNhanVien(std);
		if(cnt == 1)/*nay*/	
			 JOptionPane.showMessageDialog(null,"Thêm nhân viên thành công!");
		if(cnt==2)/*nay*/	
			 JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");			
	}
	
	public void deleteNhanVien(){
		std.setMaNV(this.txtID.getText());
		int cnt=controller.deleteNhanVien(std);
		if(cnt != 0) {
			 JOptionPane.showMessageDialog(null,"Đã xóa nhân viên khỏi danh sách!");
		 }else {
			 JOptionPane.showMessageDialog(null,"Mã nhân viên sai");
		 }	
	}
	
	public void updateNhanVien(){
		std.setMaNV(this.txtID.getText());
		std.setName(this.txtFullname.getText());
		std.setAge(this.txtAge.getText());
		std.setGender(this.txtGender.getText());
		std.setAddress(this.txtAddress.getText());
		std.setPhone(this.txtPhone.getText());
		std.setSalary(this.txtSalary.getText());
		std.setTime(this.txtTime.getText());
		int cnt=controller.updateNhanVien(std, this.txtID.getText());
		if(cnt == 1) {
			 JOptionPane.showMessageDialog(null, "Đã cập nhật nhân viên!");
		}
		if(cnt==2)
			JOptionPane.showMessageDialog(null, "Yêu cầu đầy đủ các thông tin");
		if(cnt == 0) {
			 JOptionPane.showMessageDialog(null, "Mã Nhân Viên không hợp lệ");
		}
	}
}
