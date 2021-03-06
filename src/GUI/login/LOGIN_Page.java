package GUI.login;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JButton;
import Bank.ReserveBank;
import Bank.WhenSQLExceptionOccurs;

public class LOGIN_Page extends JFrame implements ActionListener {
	public JButton login, create, show, status, addbal, ok;
	public TextField user;
	public JPasswordField pass;
	public JLabel usr, pss, jl_err;
    public Container c;
    public ReserveBank rb;
	
	public LOGIN_Page(ReserveBank rb) {
	   c = getContentPane(); c.setBackground(Color.black);
	   c.setLayout(null); this.rb = rb;

	   login = new JButton("Login"); login.setBackground(Color.black); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(0, 50, 200, 60); login.setMnemonic('l'); login.setToolTipText("LogIn");                                     
	   create = new JButton("Create Account"); create.setBackground(Color.darkGray); create.setForeground(Color.white); create.setFont(new Font("Helvetica", Font.PLAIN, 15)); create.setBounds(0, 110, 200, 60); create.setMnemonic('c'); create.setToolTipText("Create Account");
	   addbal = new JButton("Add Balance"); addbal.setBackground(Color.darkGray); addbal.setForeground(Color.white); addbal.setFont(new Font("Helvetica", Font.PLAIN, 15)); addbal.setBounds(0, 170, 200, 60); addbal.setMnemonic('b'); addbal.setToolTipText("Add Balance");
 	   show = new JButton("Show Balance"); show.setBackground(Color.darkGray); show.setForeground(Color.white); show.setFont(new Font("Helvetica", Font.PLAIN, 15)); show.setBounds(0, 230, 200, 60); show.setMnemonic('w'); show.setToolTipText("Show Balance");
       status = new JButton("Status"); status.setBackground(Color.darkGray); status.setForeground(Color.white); status.setFont(new Font("Helvetica", Font.PLAIN, 15)); status.setBounds(0, 290, 200, 60); status.setMnemonic('s'); status.setToolTipText("Account Status");
       
       user = new TextField(30); user.setFont(new Font("Helvetica", Font.PLAIN, 16)); user.setBounds(350, 150, 200, 25); user.setBackground(Color.darkGray); user.setForeground(Color.white);
       pass = new JPasswordField(); pass.setFont(new Font("Helvetica", Font.PLAIN, 17)); pass.setBounds(350, 195, 200, 25); pass.setBackground(Color.darkGray);  pass.setForeground(Color.white);
       ok = new JButton("Login"); ok.setBackground(Color.red); ok.setForeground(Color.white); ok.setFont(new Font("Helvetica", Font.PLAIN, 15)); ok.setBounds(350, 250, 100, 30);
       
       usr = new JLabel("Username", JLabel.CENTER); usr.setFont(new Font("Helvetica", Font.BOLD, 16)); usr.setBounds(200, 146, 200, 35); usr.setForeground(Color.cyan); usr.setBackground(Color.darkGray);
       pss = new JLabel("Password", JLabel.CENTER); pss.setFont(new Font("Helvetica", Font.BOLD, 16)); pss.setBounds(200, 191, 200, 35); pss.setBackground(Color.darkGray); pss.setForeground(Color.cyan);
       jl_err = new JLabel("Invalid Username Or Password"); jl_err.setFont(new Font("Helvetica", Font.PLAIN, 13)); jl_err.setBounds(350, 225, 230, 20); jl_err.setBackground(Color.black); jl_err.setForeground(Color.red);
       jl_err.setVisible(false);
      
        addbal.setEnabled(false); 	show.setEnabled(false); status.setEnabled(false);
		c.add(login); c.add(create); c.add(addbal); c.add(show); c.add(status); c.add(user); c.add(pass); c.add(usr); c.add(pss); c.add(ok); c.add(jl_err);
	
	   this.setSize(650, 430); this.setResizable(false); this.setVisible(true);  this.setTitle("Bank LogIn Page");
	   
	    ok.addActionListener(this);
	    create.addActionListener(this);
	    addbal.addActionListener(this);
	    show.addActionListener(this);
	    status.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ok) {rb.authentic(this);}
		if(ae.getSource() == create) {new CREATE_Page(rb); this.dispose();}
		if(ae.getSource() == addbal) {rb.addBalance1(new ADDBALANCE_Page(rb)); this.dispose();}
		if(ae.getSource() == show) {rb.showBalance(new SHOW_Page(rb)); this.dispose();}
		if(ae.getSource() == status) {rb.showDetails(new STATUS_Page(rb)); this.dispose();}
	}
}
