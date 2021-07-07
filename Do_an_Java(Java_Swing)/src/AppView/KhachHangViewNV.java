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

import QuanLyVanPP.KhachHangControl;

public class KhachHangViewNV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	
	private DefaultTableModel tableModel;
	private static KhachHangControl khachHangControl=null;
	private static ResultSet rs=null;

	public KhachHangViewNV() {
		setTitle("Quản Lý Khách Hàng");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 799, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 91, 770, 420);
		contentPane.add(scrollPane_1);		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		scrollPane_1.setViewportView(table);
		
		try {
			hienThiKhachHang();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	private void hienThiKhachHang() throws SQLException {
		String tenCot[] = {"Mã Khách Hàng", "Tên Khách Hàng", "Tuổi", "Giới", "Địa Chỉ", "Số Điện Thoại"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(tenCot);
		table.setModel(tableModel);
		
		khachHangControl = new KhachHangControl();
		rs = khachHangControl.guiThongTinKhachHang();
		
		while(rs.next()) {
			Vector value = new Vector();
			value.add(rs.getString("MaKH"));
			value.add(rs.getString("Name"));
			value.add(rs.getString("Age"));
			value.add(rs.getString("Gender"));
			value.add(rs.getString("Address"));
			value.add(rs.getString("Phone"));
			tableModel.addRow(value);
		}
//
		JButton btnNewButton = new JButton("Chỉnh Sửa Khách Hàng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChinhSuaKhachHangNV frame = new ChinhSuaKhachHangNV();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(583, 31, 195, 49);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Quản Lý Khách Hàng Thân Thiết");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(154, 11, 419, 49);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormMenuNhanVien frame = new FormMenuNhanVien();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(31, 35, 113, 49);
		contentPane.add(btnNewButton_1);
		
		this.setResizable(false);
		this.setLocation(200, 100);
	}

}
