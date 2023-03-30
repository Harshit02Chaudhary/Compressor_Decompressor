import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CompressorDecompressor extends JFrame implements ActionListener{

	JButton compressButton;
	JButton decompressButton;

	CompressorDecompressor(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		compressButton = new JButton("Select File to Compress");
		compressButton.setBounds(20, 100, 200, 30);
		compressButton.addActionListener(this);
		
		decompressButton = new JButton("Select File to Decompress");
		decompressButton.setBounds(20, 150, 200, 30);
		decompressButton.addActionListener(this);
		
		this.add(compressButton);
		this.add(decompressButton);
		this.getContentPane().setBackground(Color.BLACK);
		this.setSize(500, 300);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == compressButton) {
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try {
					Compressor.method(file);
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
		
		if(e.getSource() == decompressButton) {
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try {
					Decompressor.method(file);
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
			
		}
	}

	public static void main(String[] args) {
		
		new CompressorDecompressor();
	}
}
