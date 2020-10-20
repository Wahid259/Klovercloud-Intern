import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Kacchi extends JFrame implements ActionListener{
	
	private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel, idLabel, nameLabel, priceLabel;
    private JTextField idTf, nameTf, priceTf;
    private JButton addButton, updateButton, deleteButton, clearButton;
    
    private String[] colums = {"id", "name", "price"};
    private String[] rows = new String[4];
    
    Kacchi()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setTitle("Kacchi Table");
        
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);
        
        
        Font font = new Font("Arial",Font.BOLD,16);
        
        
        titleLabel = new JLabel("Kacchi Registration");
        titleLabel.setFont(font);
        titleLabel.setBounds(300,10,250,50);
        c.add(titleLabel);
        
        idLabel = new JLabel("ID : ");
        idLabel.setBounds(10,80,140,30);
        idLabel.setFont(font);
        c.add(idLabel);
        
        idTf = new JTextField();
        idTf.setBounds(110,80,200,30);
        idTf.setFont(font);
        c.add(idTf);
        
        addButton = new JButton("Add");
        addButton.setBounds(400,80,100,30);
        addButton.setFont(font);
        c.add(addButton);
        
        nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(10,130,150,30);
        nameLabel.setFont(font);
        c.add(nameLabel);
        
        nameTf = new JTextField();
        nameTf.setBounds(110,130,200,30);
        nameTf.setFont(font);
        c.add(nameTf);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(400,130,100,30);
        updateButton.setFont(font);
        c.add(updateButton);
        
        priceLabel = new JLabel("Price : ");
        priceLabel.setBounds(10,180,150,30);
        priceLabel.setFont(font);
        c.add(priceLabel);
        
        priceTf = new JTextField();
        priceTf.setBounds(110,180,200,30);
        priceTf.setFont(font);
        c.add(priceTf);
        
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400,180,100,30);
        deleteButton.setFont(font);
        c.add(deleteButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(600,80,100,30);
        clearButton.setFont(font);
        c.add(clearButton);
        
        
        
        table = new JTable();
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        
        
        scroll = new JScrollPane(table);
        scroll.setBounds(10,360,740,265);
        c.add(scroll);
        
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        
        
        
        table.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent me)
                {
                    int numbetOfRow = table.getSelectedRow();
                    
                    String id = model.getValueAt(numbetOfRow, 0).toString();
                    String name = model.getValueAt(numbetOfRow, 1).toString();
                    String price = model.getValueAt(numbetOfRow, 2).toString();
                    
                    idTf.setText(id);
                    nameTf.setText(name);
                    priceTf.setText(price);
                    
                    
                }
            
        });
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addButton)
        {
            rows[0] = idTf.getText();
            rows[1] = nameTf.getText();
            rows[2] = priceTf.getText();
            
            model.addRow(rows);//row gula te ki ase ta sob amra table a dhakabo
        }
        else if(e.getSource() == clearButton)
        {
            idTf.setText("");
            nameTf.setText("");
            priceTf.setText("");
        }
        else if(e.getSource() == deleteButton)
        {
            int numOfRow  = table.getSelectedRow();//user jeta select korbe seta numberOgRors a chole asbe
            if(numOfRow >=0 )
            {
                model.removeRow(numOfRow);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No row has boon selected or no row exits");
            }
        }
        else if(e.getSource() == updateButton)
        {
            int numberOfRow = table.getSelectedRow();
            
            String id = idTf.getText();
            String name = nameTf.getText();
            String price = priceTf.getText();
            
            model.setValueAt(id, numberOfRow, 0);
            model.setValueAt(name, numberOfRow, 1);
            model.setValueAt(price, numberOfRow, 2);
            
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kacchi frame = new Kacchi();
        frame.setVisible(true);


	}

	
}
