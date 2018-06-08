package siguri2 ;
import java.util.Random;//importimi i klases random
import java.math.BigInteger;//importimi i klases BIgIntger
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.math.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class siguri extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JTextField txtQ;
	private static JTextField txtN;
	private static JTextField txtPhi;
	private static JTextField txtE;
	private static JTextField txtP;
	private static JTextField txtD;
    BigInteger e;
    BigInteger phi;
    BigInteger d;
	/**
	 * Launch the application.
	 * @return 
	 * @return 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			 siguri frame = new siguri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	private static boolean isPrime(BigInteger numri) {
	    for (BigInteger i = BigInteger.valueOf(2); i.compareTo(numri) < 0; i = i.add(BigInteger.ONE)) {
	        if (numri.mod(i).equals(BigInteger.ZERO)) {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Create the frame.
	 */
	public siguri() {
		
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 410);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("P:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel.setBounds(59, 71, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Q:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(59, 103, 46, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("n:");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_2.setBounds(59, 162, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u03C6(n):");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_3.setBounds(59, 208, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(161, 101, 173, -23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtQ = new JTextField();
		txtQ.setBounds(144, 117, 550, 20);
		contentPane.add(txtQ);
		txtQ.setColumns(10);
		
		txtN = new JTextField();
		txtN.setBounds(144, 161, 550, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		txtPhi = new JTextField();
		txtPhi.setBounds(144, 207, 550, 20);
		contentPane.add(txtPhi);
		txtPhi.setColumns(10);
		
		txtE = new JTextField();
		txtE.setBounds(144, 252, 550, 20);
		contentPane.add(txtE);
		txtE.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("e:");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_4.setBounds(59, 253, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtP = new JTextField();
		txtP.setColumns(10);
		txtP.setBounds(144, 70, 550, 20);
		contentPane.add(txtP);
		
		txtD = new JTextField();
		txtD.setColumns(10);
		txtD.setBounds(144, 303, 550, 20);
		contentPane.add(txtD);
		
		JLabel lblD = new JLabel("d:");
		lblD.setForeground(Color.DARK_GRAY);
		lblD.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblD.setBounds(59, 304, 46, 14);
		contentPane.add(lblD);

		// Gjenerimi i random numrave prime positive per p
		int x=-1;
		
		while (x<0){
			byte[] array = new byte[1];
		Random r = new Random();
		
		r.nextBytes(array);
		BigInteger p = new BigInteger(array);
		if((isPrime(p)==true))
		{
			if(p.compareTo(BigInteger.ZERO)==1)
			{
				txtP.setText(p.toString());
				x=2;
			}
			else
				x=-2;
			
		}
	
		}
		// Gjenerimi i random numrave prime positive per q
        int y=-1;
		
		while (y<0){
			byte[] array1 = new byte[1];
		Random r1 = new Random();
		
		r1.nextBytes(array1);
		BigInteger q = new BigInteger(array1);
		if((isPrime(q)==true))
		{
			if(q.compareTo(BigInteger.ZERO)==1)
			{
				txtQ.setText(q.toString());
				y=2;
			}
			else
				y=-2;
			
		
		}	
		}
		//Shumezimi i p dhe q
		BigInteger n;
		String p;
		String q;
		p=txtP.getText();
		q=txtQ.getText();
		BigInteger numri1=new BigInteger(p);
		BigInteger numri2=new BigInteger(q);
		n=numri1.multiply(numri2);
		txtN.setText(n.toString());
		
		//Gjenerimi i phi=(p-1)*(q-1)
		
		phi=(numri1.subtract(BigInteger.ONE).multiply(numri2.subtract(BigInteger.ONE)));
		txtPhi.setText(phi.toString());
		
		JLabel lblGjenerimiI = new JLabel("Gjenerimi i \u00E7elsave RSA");
		lblGjenerimiI.setForeground(Color.DARK_GRAY);
		lblGjenerimiI.setHorizontalAlignment(SwingConstants.CENTER);
		lblGjenerimiI.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 25));
		lblGjenerimiI.setBounds(131, 11, 488, 36);
		contentPane.add(lblGjenerimiI);
		//Trebuchet MS(fonti)
		//Gjenerimi i e
int c=-2;		
while(c<0){
		
		do{
			
			// byte[] array3 = new byte[phi.bitLength()];
			    e=new BigInteger(phi.bitLength(),new Random());
			    if(e.compareTo(BigInteger.ONE)==1&&e.compareTo(phi)==-1)
			    {
			    txtE.setText(e.toString());
			    c=3;
			    }
			    else
			    {
			    	c=-2;
			    }
			}
			while((e.gcd(phi).compareTo(BigInteger.valueOf(1))!=0));
			
		}
		//gjenerimi i d
       d=e.modInverse(phi);
       txtD.setText(d.toString());
      

	}
}

