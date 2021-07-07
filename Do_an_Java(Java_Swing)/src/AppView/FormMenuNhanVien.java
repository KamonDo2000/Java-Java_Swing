package AppView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMenuNhanVien extends JFrame {

	private JPanel contentPane;
	public FormMenuNhanVien() {
		setTitle("Quản Lý Cửa Hàng Văn Phòng Phẩm");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 565);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("System");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Admin");
		mnNewMenu.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Th\u1EE7 Kho");
		mnNewMenu.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("NhanVien");
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Đăng Xuất");
		mnNewMenu.add(mntmNewMenuItem_9);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormLogin frame = new FormLogin();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Quản Lý Account");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.enable(false);
		
		JMenu mnNewMenu_2 = new JMenu("Infor Apps");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Help");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("");
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("");
		menuBar.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("");
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("");
		menuBar.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 784, 477);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Qu\u1EA3n L\u00FD H\u00E0ng H\u00F3a");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HangHoaViewNhanVien frame = new HangHoaViewNhanVien();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 108, 239, 76);
		panel.add(btnNewButton);
		JButton btnQunLNhn = new JButton("Qu\u1EA3n L\u00FD Nh\u00E2n Vi\u00EAn");
		btnQunLNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NhanVienView frame = new NhanVienView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnQunLNhn.setEnabled(false);
		btnQunLNhn.setBounds(307, 108, 191, 76);
		panel.add(btnQunLNhn);
		
		JButton btnQunLNhn_1 = new JButton("Quản Lý Khách Hàng Thân Thiết");
		btnQunLNhn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KhachHangViewNV frame = new KhachHangViewNV();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnQunLNhn_1.setBounds(538, 108, 236, 76);
		panel.add(btnQunLNhn_1);
		
		JButton btnThmHan = new JButton("Th\u00EAm H\u00F3a \u0110\u01A1n");
		btnThmHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoaDonViewNV frame = new HoaDonViewNV();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnThmHan.setBounds(124, 269, 245, 76);
		panel.add(btnThmHan);
		
		JButton btnRaHan = new JButton("Ra H\u00F3a \u0110\u01A1n");
		btnRaHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkMaHDNV frame = new checkMaHDNV();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnRaHan.setBounds(427, 269, 245, 76);
		panel.add(btnRaHan);
		
		JButton btnNewButton_1 = new JButton("Đăng Xuất");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormLogin frame = new FormLogin();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(595, 443, 134, 23);
		panel.add(btnNewButton_1);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(200, 100);
	}
}
