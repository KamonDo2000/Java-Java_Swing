package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import QuanLyVanPP.HoaDonControl;
import QuanLyVanPP.NhanVienControl;

public class NhanVienView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
//
	private DefaultTableModel tableModel;
	private static NhanVienControl nhanVienControl=null;
	private static ResultSet rs=null;
//
	public NhanVienView() {
		setTitle("Quản Lý Nhân Viên");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 799, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 91, 770, 360);
		contentPane.add(scrollPane_1);		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		scrollPane_1.setViewportView(table);
		
		try {
			hienThiNhanVien();
			} catch (Exception e) {
			e.printStackTrace();
			}
		int tongLuong = 0;
		try { 
			
			tongLuong = tinhTongLuong();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel("Tổng Số Tiền Trả Nhân Viên: "+String.valueOf(tongLuong) +" USD");
		lblNewLabel_1.setBounds(8, 462, 471, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		}
	
	private void hienThiNhanVien() throws SQLException {
		String tenCot[] = {"Mã Nhân Viên", "Tên Nhân Viên", "Tuổi", "Địa Chỉ", "Số Điện Thoại", "Lương", "Thời Gian Vào Làm"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(tenCot);
		table.setModel(tableModel);
		
		nhanVienControl = new NhanVienControl();
		rs = nhanVienControl.guiThongTinNhanVien();
		
		while(rs.next()) {
			Vector value = new Vector();
			value.add(rs.getString("MaNV"));
			value.add(rs.getString("Name"));
			value.add(rs.getString("Age"));
			value.add(rs.getString("Address"));
			value.add(rs.getString("Phone"));
			value.add(rs.getString("Salary"));
			value.add(rs.getString("Time"));
			tableModel.addRow(value);
		}
//
		JButton btnNewButton = new JButton("Ch\u1EC9nh S\u1EEDa Nh\u00E2n Vi\u00EAn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChinhSuaNhanVien frame = new ChinhSuaNhanVien();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(561, 35, 195, 49);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD Nh\u00E2n Vi\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(267, 11, 252, 49);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormMenu frame = new FormMenu();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(31, 35, 113, 49);
		contentPane.add(btnNewButton_1);
		
		this.setResizable(false);
		this.setLocation(200, 100);
	}

	private int tinhTongLuong() throws SQLException {
		nhanVienControl = new NhanVienControl();
		if(rs == null)
			return 0;
		rs=nhanVienControl.guiThongTinNhanVien();
		int tong=0;
		while(rs.next()) {
			tong=tong+rs.getInt("Salary");
		}
		return tong;
	}
	
}
