package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import QuanLyVanPP.CSDLhoaDonControl;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CSDLhoaDonView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
//table
	private DefaultTableModel tableModel;
	private static CSDLhoaDonControl csdlHoaDonControl=null;
	private static ResultSet rs=null;
//table
	public CSDLhoaDonView() {
		setTitle("C\\u1EDF S\\u1EDF D\\u1EEF Li\\u1EC7u H\\u00F3a \\u0110\\u01A1n");
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
		String tenCot[] = {"Mã Hóa Đơn", "Tên Khách Hàng", "Mã Hàng Hóa", "Số Lượng", "Đơn Giá"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(tenCot);
		table.setModel(tableModel);
		
		csdlHoaDonControl = new CSDLhoaDonControl();
		rs = csdlHoaDonControl.guiThongTinHangHoa();
		
		while(rs.next()) {
			Vector value = new Vector();
			value.add(rs.getString("maHoaDon"));
			value.add(rs.getString("idKhach"));
			value.add(rs.getString("idHang"));
			value.add(rs.getString("soLuong"));
			value.add(rs.getString("thanhTien"));
			tableModel.addRow(value);
		}
		
		lblNewLabel = new JLabel("C\u1EDF S\u1EDF D\u1EEF Li\u1EC7u H\u00F3a \u0110\u01A1n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(237, 11, 467, 49);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoaDonView frame = new HoaDonView();
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
