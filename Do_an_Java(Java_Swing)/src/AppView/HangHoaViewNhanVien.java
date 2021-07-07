package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import QuanLyVanPP.HangHoaControl;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HangHoaViewNhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
//table
	private DefaultTableModel tableModel;
	private static HangHoaControl hangHoaControl=null;
	private static ResultSet rs=null;
//table
	public HangHoaViewNhanVien() {
		setTitle("Quản Lý Hàng Hóa");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 799, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
// table		
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
			hienThiHangHoa();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	private void hienThiHangHoa() throws SQLException {
		String tenCot[] = {"Mã Hàng Hóa", "Tên Hàng", "Giá Bán", "Tồn Kho", "Số đã bán"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(tenCot);
		table.setModel(tableModel);
		
		hangHoaControl = new HangHoaControl();
		rs = hangHoaControl.guiThongTinHangHoa();
		
		while(rs.next()) {
			Vector value = new Vector();
			value.add(rs.getString("idHang"));
			value.add(rs.getString("tenHang"));
			value.add(rs.getString("giaBan"));
			value.add(rs.getString("tonKho"));
			value.add(rs.getString("daBan"));
			tableModel.addRow(value);
		}
// table
		JButton btnNewButton = new JButton("Ch\u1EC9nh S\u1EEDa H\u00E0ng H\u00F3a");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChinhSuaHangHoa frame = new ChinhSuaHangHoa();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(602, 35, 154, 49);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD H\u00E0ng H\u00F3a");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(267, 11, 252, 49);
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