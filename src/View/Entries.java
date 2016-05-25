package View;

import Controler.Interest;
import static Controler.Interest.CheckUniqueInterest;
import Controler.SearchEntries;
import Model.Entry;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Entries extends javax.swing.JFrame {
    private javax.swing.JPanel jPanelEntries;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jKeywordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelSearchTools;
    private javax.swing.JLabel jPriceLabel;
    private javax.swing.JSlider jSlider1;
    private String descriptionText;
    
    private TitledBorder border;
    Border blackline;
    List<Entry> entries = new ArrayList<>();
    /**
     * Creates new form Entries
     */
    public Entries() {       
        initComponents();
        RepaintEntriesPanel();
        blackline = BorderFactory.createLineBorder(Color.black);
        GettingStarted();
    }
    /**
     * Shows some messages in order to make the user's
     * experience friendlier
     */
    private void GettingStarted(){
        Box box = Box.createVerticalBox();
        box.add(Box.createRigidArea(new Dimension(100,20)));
        box.add(new JLabel("To show all the avaliable entries"));
        box.add(new JLabel("leave the keyword and the price filters empty"));
        box.add(new JLabel("and click search!"));
        jPanelEntries.add(box);
        Box box2 = Box.createVerticalBox();
        box2.add(Box.createRigidArea(new Dimension(100,20)));
        box2.add(new JLabel("Use the keyword filter"));
        box2.add(new JLabel("to search an entry with the specific word"));
        box2.add(new JLabel("in the title or the description!"));
        jPanelEntries.add(box2);
    }
    /**
     * Shows the entries
     */
    private void PrintEntries(){
        entries.stream().forEach((Entry temp) -> {  
            Box outerBox = Box.createHorizontalBox();
            
            Box innerBoxFirst = Box.createVerticalBox();
            Box innerBoxSecond = Box.createHorizontalBox();
            innerBoxFirst.add(Box.createRigidArea(new Dimension(5, 5)));
            innerBoxSecond.add(Box.createRigidArea(new Dimension(5, 5)));
            
            outerBox.add(innerBoxFirst);
            outerBox.add(innerBoxSecond);
            
            jPanelEntries.add(outerBox);    
            //JLabel JId = new JLabel(Integer.toString(temp.getId()));
            //JId.setVisible(false);           
            //innerBoxFirst.add(JId);
            innerBoxFirst.add(new JLabel("Street: " + temp.getAddress()));
            innerBoxFirst.add(new JLabel("City: " + temp.getCity()));
            innerBoxFirst.add(new JLabel("Country: " + temp.getCountry()));
            innerBoxFirst.add(new JLabel("Price: " + temp.getPrice() + "€"));
            JButton button = new JButton("Ενδιαφέρομαι !");
            if (CheckUniqueInterest(temp.getId())) button.setEnabled(false);
            button.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new Interest(temp.getId());
                    button.setEnabled(false);
                }
            });
            innerBoxFirst.add(button);           

            
            descriptionText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 100, temp.getDescription());
            innerBoxSecond.add(new JLabel(descriptionText));
            JButton viewEntry = new JButton("Περισσότερα...");
            viewEntry.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ViewEntry entry = new ViewEntry(temp);
                    entry.setVisible(true);
                }
            });
            innerBoxFirst.add(viewEntry);
            border = BorderFactory.createTitledBorder(blackline, temp.getTitle());
            outerBox.setBorder(border);
            
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(temp.getPhoto()));

            } catch (IOException e) {
                e.printStackTrace();
            }

            Image dimg = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            innerBoxSecond.add(new JLabel(imageIcon));
            
            
        });
        jPanelEntries.add(new JLabel("You reach the end"));
        entries.clear();
    }
    
    private void RepaintEntriesPanel(){
        this.jPanelEntries.removeAll();
    }
    
    private void initComponents() {

        jPanelSearchTools = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jKeywordField = new javax.swing.JTextField();
        jPriceLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        

        jPanelSearchTools.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(1000000);
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("Keyword");

        jPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPriceLabel.setText("0");

        jLabel2.setText("€");

        javax.swing.GroupLayout jPanelSearchToolsLayout = new javax.swing.GroupLayout(jPanelSearchTools);
        jPanelSearchTools.setLayout(jPanelSearchToolsLayout);
        jPanelSearchToolsLayout.setHorizontalGroup(
            jPanelSearchToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchToolsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSearchToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jKeywordField)
                    .addGroup(jPanelSearchToolsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchToolsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanelSearchToolsLayout.setVerticalGroup(
            jPanelSearchToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchToolsLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKeywordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSearchToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPriceLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchTools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelEntries = new javax.swing.JPanel();
        jPanelEntries.setLayout(new javax.swing.BoxLayout(jPanelEntries, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(jPanelEntries);
        

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchTools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(191, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelEntries.setLayout(new GridLayout(0,1));
        pack();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SearchEntries se = new SearchEntries();
        RepaintEntriesPanel();
        List<Entry> temp = new ArrayList<>();
        List<Entry> keyword = new ArrayList<>();
        List<Entry> price = new ArrayList<>();
        String keywordString = jKeywordField.getText().trim();
        int priceInt = jSlider1.getValue();
        
        if((keywordString.equals("")) && (priceInt == 0)){
            System.out.println("getAllEntries");
            entries.addAll(se.getAllEntries());
        }else if(!keywordString.equals("") && priceInt == 0 ){
            System.out.println("getEntriesByKeyword");
            entries.addAll(se.GetEntriesByKeyword(keywordString));
        }else if(keywordString.equals("") && priceInt != 0){
            System.out.println("getEntriesByPrice");
            entries.addAll(se.GetEntriesByPrice(priceInt));
        }else if(!keyword.equals("") && priceInt != 0 ){
            System.out.println("getEntries by keyword and price");
            entries.addAll(se.GetEntriesByKeywordAndPrice(keywordString, priceInt));
        } 

        keyword.clear();
        price.clear();
        PrintEntries();

                                
    }
    
        private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        jPriceLabel.setText(String.valueOf(jSlider1.getValue()));
    }
    
}
    
