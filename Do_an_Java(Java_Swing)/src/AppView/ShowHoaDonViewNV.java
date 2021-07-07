package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Object.HoaDon;
import QuanLyVanPP.HoaDonControl;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ShowHoaDonViewNV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private HoaDon hoaDon;
//table
	private DefaultTableModel tableModel;	//bảng sẽ đọc
	private static HoaDonControl hoaDonControl=null; // đọc dl từ
	private static ResultSet rs=null;	//dữ liệu được lưu vào
	int tongTien;
//table
	public ShowHoaDonViewNV(String maHD) {
		
		setTitle("Show Hóa Đơn");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 799, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel = new JLabel("Show Hóa Đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(267, 11, 252, 49);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkMaHDNV frame = new checkMaHDNV();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(31, 35, 113, 49);
		contentPane.add(btnNewButton_1);
		
		this.setResizable(false);
		this.setLocation(200, 100);
		
// table		
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
		String maHoaDon;
		maHoaDon = maHD;
		try { 
			hienThiHoaDon(maHoaDon);
			tongTien = tinhTongTien(maHoaDon);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel("Tổng Đơn:"+String.valueOf(tongTien) +" VND");
		lblNewLabel_1.setBounds(418, 462, 360, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
	}
	
	public String getMaHD(String ma) {
		return ma;
	}
	
	public void hienThiHoaDon(String maHoaDon) throws SQLException {
		String tenCot[] = {"Mã Hóa Đơn", "Tên Khách Hàng khách", "Mã hàng", "Số Lượng", "Tổng Giá"}; // tên các cột hiển thị
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(tenCot);
		table.setModel(tableModel);
		
		hoaDonControl = new HoaDonControl();
		rs = hoaDonControl.guiThongTinHoaDon(maHoaDon); //lấy dl từ gửi thông tin hàng trong hàng control
		if(rs == null) {
			 JOptionPane.showMessageDialog(null,"Yêu Cầu Nhập Lại Mã Hóa Đơn");
		}else {
			while(rs.next()) {
				Vector value = new Vector();	//đọc dữ liệu từng cột
				value.add(rs.getString("maHoaDon"));
				value.add(rs.getString("idKhach"));
				value.add(rs.getString("idHang"));
				value.add(rs.getString("soLuong"));
				value.add(rs.getString("thanhTien"));
				tableModel.addRow(value);	// add vào hiển thị bảng
			}
		}
	}
	
	private int tinhTongTien(String maHoaDon) throws SQLException {
		hoaDonControl = new HoaDonControl();
		if(rs == null)
			return 0;
		rs=hoaDonControl.guiThongTinHoaDon(maHoaDon);
		int tong=0;
		while(rs.next()) {
			tong=tong+rs.getInt("thanhTien");
		}
		return tong;
	}
}

