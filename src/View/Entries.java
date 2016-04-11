package View;
import Controler.SearchEntries;
import Model.Entry;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.Box;
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
        
    }
    
    private void GetAllEntries(){        
        
    }
    
    private void PrintEntries(){
        entries.stream().forEach((temp) -> {           
            Box box = Box.createVerticalBox();
            box.add(Box.createRigidArea(new Dimension(5, 5)));
            jPanelEntries.add(box);            
            box.add(new JLabel("Street: " + temp.getAddress()));
            box.add(new JLabel("City: " + temp.getCity()));
            box.add(new JLabel("Country: " + temp.getCountry()));
            box.add(new JLabel("Price: " + temp.getPrice() + "€"));
//            box.add(new JButton(Integer.toString(temp.getId())));
            box.add(new JButton("Endiaferomai"));
            border = BorderFactory.createTitledBorder(blackline, temp.getTitle());
            box.setBorder(border);
        });
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

        jSlider1.setMaximum(50000);
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
        jPanelEntries.setLayout(new GridLayout(0,1));//test

        pack();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SearchEntries se = new SearchEntries();
        RepaintEntriesPanel();
        List<Entry> temp = new ArrayList<>();
        List<Entry> keyword = new ArrayList<>();
        List<Entry> price = new ArrayList<>();
        
        keyword.addAll(se.GetEntriesByKeyword(jKeywordField.getText(),jSlider1.getValue()));
 
        //price.addAll(se.GetEntriesByPrice(jSlider1.getValue()));
        entries.removeAll(keyword);
        entries.addAll(keyword);
        
        
        PrintEntries();

                                
    }
    

    
//    private <T> Set<T> findDuplicates(Collection<T> list) {
//        Set<T> duplicates = new LinkedHashSet<>();
//        Set<T> uniques = new HashSet<>();
//        for(T t : list) {
//            if(!uniques.add(t)) {
//                duplicates.add(t);
//            }
//        }
//        return duplicates;
//    }
    
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        jPriceLabel.setText(String.valueOf(jSlider1.getValue()));
    }
    
}
    
