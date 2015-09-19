package Memory;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class MemoryApp extends JFrame {

	private JPanel contentPane;
	private final ImageIcon image1 = new ImageIcon(getClass().getResource("Allthethings.jpg"));
	private final ImageIcon image2 = new ImageIcon(getClass().getResource("DeviousKid.jpg"));
	private final ImageIcon image3 = new ImageIcon(getClass().getResource("Stalker.jpg"));
	private final ImageIcon image4 = new ImageIcon(getClass().getResource("Whoa.jpg"));
	private final ImageIcon image5 = new ImageIcon(getClass().getResource("Why.jpg"));
	private final ImageIcon image6 = new ImageIcon(getClass().getResource("YesKid.jpg"));
	private Icon image7 = new ImageIcon(getClass().getResource("Thinker.jpg"));
	private Icon image8 = new ImageIcon(getClass().getResource("Question.png"));
	
	private ArrayList <ImageIcon> iconTracker = new ArrayList();
	
	Random rand = new Random();
	ImageIcon[] iconList = {image1, image2, image3, image4, image5, image6};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryApp frame = new MemoryApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MemoryApp() {
		this.setTitle("Memory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPane = new JPanel();
		contentPane.add(topPane, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Memory");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		topPane.add(label);
		
		JPanel botPane = new JPanel();
		contentPane.add(botPane, BorderLayout.CENTER);
		botPane.setLayout(new GridLayout(3, 4, 10, 10));
		
		contentPane.setBackground(Color.BLACK);
		topPane.setBackground(Color.BLACK);
		botPane.setBackground(Color.BLACK);
		
		JButton button1 = new JButton(image7), button2 = new JButton(image7), button3 = new JButton(image7), button4 = new JButton(image7);
		JButton button5 = new JButton(image7), button6 = new JButton(image7), button7 = new JButton(image7), button8 = new JButton(image7);
		JButton button9 = new JButton(image7), button10 = new JButton(image7), button11 = new JButton(image7), button12 = new JButton(image7);
		
		button1.setRolloverEnabled(true);
		button1.setRolloverIcon(image8);
		button2.setRolloverEnabled(true);
		button2.setRolloverIcon(image8);
		button3.setRolloverEnabled(true);
		button3.setRolloverIcon(image8);
		button4.setRolloverEnabled(true);
		button4.setRolloverIcon(image8);
		button5.setRolloverEnabled(true);
		button5.setRolloverIcon(image8);
		button6.setRolloverEnabled(true);
		button6.setRolloverIcon(image8);
		button7.setRolloverEnabled(true);
		button7.setRolloverIcon(image8);
		button8.setRolloverEnabled(true);
		button8.setRolloverIcon(image8);
		button9.setRolloverEnabled(true);
		button9.setRolloverIcon(image8);
		button10.setRolloverEnabled(true);
		button10.setRolloverIcon(image8);
		button11.setRolloverEnabled(true);
		button11.setRolloverIcon(image8);
		button12.setRolloverEnabled(true);
		button12.setRolloverIcon(image8);
		
		button1.addActionListener(new ButtonEventHandler());
		button2.addActionListener(new ButtonEventHandler());
		button3.addActionListener(new ButtonEventHandler());
		button4.addActionListener(new ButtonEventHandler());
		button5.addActionListener(new ButtonEventHandler());
		button6.addActionListener(new ButtonEventHandler());
		button7.addActionListener(new ButtonEventHandler());
		button8.addActionListener(new ButtonEventHandler());
		button9.addActionListener(new ButtonEventHandler());
		button10.addActionListener(new ButtonEventHandler());
		button11.addActionListener(new ButtonEventHandler());
		button12.addActionListener(new ButtonEventHandler());
		
		botPane.add(button1);
		botPane.add(button2);
		botPane.add(button3);
		botPane.add(button4);
		botPane.add(button5);
		botPane.add(button6);
		botPane.add(button7);
		botPane.add(button8);
		botPane.add(button9);
		botPane.add(button10);
		botPane.add(button11);
		botPane.add(button12);
		
	}
	public class ButtonEventHandler implements ActionListener
	{
		private ImageIcon randIcon = iconList[rand.nextInt(iconList.length)];
		private JButton btn;
		private int count = 0;
		private boolean successful;
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton button = (JButton) e.getSource();
			while (count < 2)
			{
				for (ImageIcon el : iconTracker)
				{
					if (el == randIcon)
						count++;
				}
				if(count > 1)
				{
					randIcon = iconList[rand.nextInt(iconList.length)];
					count = 0;
				}
				else
				{
					iconTracker.add(randIcon);
					count = 2;
				}
			}
			if (button.getIcon() == image7)
			{
				button.setIcon(randIcon);
				button.setRolloverEnabled(false);
			}	
			else
			{
				button.setIcon(image7);
				button.setRolloverEnabled(true);
			}
		}
	}
}
