package day8.bookshop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ShopUI {
	private Shop bookshop;
	private Stock stock;
    private JFrame f;
    private JTextField tf;
    private JTextField tf1;
    private List <JRadioButton> arrayRButton;
    private JPanel mainPanel;
    private ButtonGroup group;
    Customer customer;
    private JPanel radioPanel ;
    private JPanel attributePanel;
    private JPanel quantPanel ;
    private JPanel basePanel;
    private JLabel labelColumn1 ;
    private JLabel labelColumn2 ;
    private JLabel labelColumn3 ;
    private JPanel panel;
    
	public ShopUI(Shop bookshop, Stock stock){

		this.bookshop = bookshop;
        this.stock = stock;
		f = new JFrame("Bookshop");
		mainPanel = createPanel();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setMinimumSize(new Dimension(800, 600));
      	f.add(mainPanel);        
		f.pack();
		f.setVisible(true);
	}
 
	private JPanel createPanel(){
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		
		JLabel label = new JLabel("Input Your name:");
		panel.add(label, new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.LINE_START,
				GridBagConstraints.NONE,new Insets(0,0,10,0),0,0));
		
		tf = new JTextField();
		tf.setColumns(10);
		panel.add(tf,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL,new Insets(0,0,10,0),0,0));
		
		
		group = new ButtonGroup();
		radioPanel = new JPanel(new GridLayout(stock.getNumberTypesOnStock()+1,1,1,3));
		attributePanel = new JPanel(new GridLayout(stock.getNumberTypesOnStock()+1,1,1,9));
		quantPanel = new JPanel(new GridLayout(stock.getNumberTypesOnStock()+1,1,1,9));
		labelColumn1 = new JLabel("Title");
		labelColumn1.setFont(new Font("Arial",Font.BOLD,14));
		radioPanel.add(labelColumn1);
		labelColumn2 = new JLabel("Author/Issue");
		labelColumn2.setFont(new Font("Arial",Font.BOLD,14));
		attributePanel.add(labelColumn2);
		labelColumn3 = new JLabel("Shop has:");
		labelColumn3.setFont(new Font("Arial",Font.BOLD,14));
		quantPanel.add(labelColumn3);
		
		arrayRButton = new ArrayList<>();
		for(int i=0; i<stock.getNumberTypesOnStock();i++){
			arrayRButton.add(i, new JRadioButton(stock.getName(i), false));
			group.add(arrayRButton.get(i));
			radioPanel.add(arrayRButton.get(i));
			attributePanel.add(new JLabel(stock.getAttribute(i)));
			quantPanel.add(new JLabel(Integer.toString(stock.getQuantity(i))));
		}
	
		
		basePanel = new JPanel(new GridBagLayout());
		basePanel.add(radioPanel,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,0,0),25,0));
		basePanel.add(attributePanel,new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,0,0),25,0));
		basePanel.add(quantPanel,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,0,0),25,0));
		panel.add(basePanel,new GridBagConstraints(0,1,3,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,0,0),25,0));
		basePanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
	
		
		JLabel label1 = new JLabel("Please, choose one of the books and it's required quantity");
		label1.setFont(new Font("Arial",Font.PLAIN,11));
	
		panel.add(label1,new GridBagConstraints(0,2,3,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,10,0),0,0));
		
		JLabel label2 = new JLabel("Input quantity:");
		panel.add(label2,new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,10,0),0,0));
			
		tf1 = new JTextField(3);
		panel.add(tf1,new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,10,0),0,0));
				
		JButton button1 = new JButton("Buy");
		panel.add(button1,new GridBagConstraints(1,4,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,0,0),25,0));
		
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!tf.getText().isEmpty()){
					 customer = new Customer(tf.getText());
				}else{
					System.out.println("The name is empty. Input, please!");
					return;
				}
				if(!tf1.getText().isEmpty()){
					// Customer c = new Customer(tf.getText());
				}else{
					System.out.println("The quantity is empty. Input, please!");
					return;
				}
				//check radioButtons
				int indexOfRButton=0;
				while(indexOfRButton < arrayRButton.size()){
				  if(arrayRButton.get(indexOfRButton).isSelected()){
					  break;
				  }else{
					  indexOfRButton++;
				  }
				}
				if(indexOfRButton >= arrayRButton.size()){
					System.out.println("Please, choose the product!");
					return;
				}
				
				bookshop.buy(customer, indexOfRButton, Integer.parseInt(tf1.getText()));
				
				radioPanel.removeAll();
				attributePanel.removeAll();
				quantPanel.removeAll();
				basePanel.removeAll();
				basePanel.setBorder(BorderFactory.createEmptyBorder());
				
				group = new ButtonGroup();
				radioPanel = new JPanel(new GridLayout(stock.getNumberTypesOnStock()+1,1,1,3));
				attributePanel = new JPanel(new GridLayout(stock.getNumberTypesOnStock()+1,1,1,9));
				quantPanel = new JPanel(new GridLayout(stock.getNumberTypesOnStock()+1,1,1,9));
				labelColumn1 = new JLabel("Title");
				labelColumn1.setFont(new Font("Arial",Font.BOLD,14));
				radioPanel.add(labelColumn1);
				labelColumn2 = new JLabel("Author/Issue");
				labelColumn2.setFont(new Font("Arial",Font.BOLD,14));
				attributePanel.add(labelColumn2);
				labelColumn3 = new JLabel("Shop has:");
				labelColumn3.setFont(new Font("Arial",Font.BOLD,14));
				quantPanel.add(labelColumn3);
				
				for(int i=0; i<stock.getNumberTypesOnStock();i++){
					arrayRButton.add(i, new JRadioButton(stock.getName(i), false));
					group.add(arrayRButton.get(i));
					radioPanel.add(arrayRButton.get(i));
					attributePanel.add(new JLabel(stock.getAttribute(i)));
					quantPanel.add(new JLabel(Integer.toString(stock.getQuantity(i))));
				}
				//group.clearSelection();
				basePanel = new JPanel(new GridBagLayout());
				basePanel.add(radioPanel,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.LINE_START,
						0,new Insets(0,0,0,0),25,0));
				basePanel.add(attributePanel,new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.LINE_START,
						0,new Insets(0,0,0,0),25,0));
				basePanel.add(quantPanel,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.LINE_START,
						0,new Insets(0,0,0,0),25,0));
				panel.add(basePanel,new GridBagConstraints(0,1,3,1,0,0,GridBagConstraints.LINE_START,
						0,new Insets(0,0,0,0),25,0));
				basePanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				panel.revalidate();
			}
			
		});
		
		
		JButton button2 = new JButton("Exit");
		panel.add(button2,new GridBagConstraints(2,4,1,1,0,0,GridBagConstraints.LINE_START,
				0,new Insets(0,0,0,0),25,0));
		
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();				
			}
			
		});
		
		return panel; 
	}
}
