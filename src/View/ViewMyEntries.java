package View;

import Controler.DeleteEntry;
import static Controler.Interest.FindEntriesImInterested;
import Model.Entry;
import java.util.ArrayList;
import java.util.List;
import Controler.SearchEntries;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ViewMyEntries extends javax.swing.JFrame {
    int userId;
    SearchEntries se = new SearchEntries();
    List<Entry> myEntries = new ArrayList<>();
    List<Entry> interestEntries = new ArrayList<>();
    private TitledBorder border;
    Border blackline;
    private String descriptionText;
    
    /**
     * Creates new form ViewMyEntries
     */
    public ViewMyEntries(int userId) {
        this.userId = userId;
        myEntries.addAll(se.GetEntriesById(userId));
        interestEntries.addAll(FindEntriesImInterested());
        initComponents();
        blackline = BorderFactory.createLineBorder(Color.gray);
        PrintEntries();
        PrintEntriesInterested();
    }
    
    private void PrintEntries(){
        myEntries.stream().forEach((Entry temp) -> {  
            Box outerBox = Box.createHorizontalBox();
            
            Box innerBoxFirst = Box.createVerticalBox();
            Box innerBoxSecond = Box.createHorizontalBox();
            innerBoxFirst.add(Box.createRigidArea(new Dimension(5, 5)));
            innerBoxSecond.add(Box.createRigidArea(new Dimension(5, 5)));
            
            outerBox.add(innerBoxFirst);
            outerBox.add(innerBoxSecond);
            
            jPanelEntries.add(outerBox);    
            JLabel JId = new JLabel(Integer.toString(temp.getId()));
            JId.setVisible(false);           
            innerBoxFirst.add(JId);
            innerBoxFirst.add(new JLabel("Street: " + temp.getAddress()));
            innerBoxFirst.add(new JLabel("City: " + temp.getCity()));
            innerBoxFirst.add(new JLabel("Country: " + temp.getCountry()));
            innerBoxFirst.add(new JLabel("Price: " + temp.getPrice() + "€"));         
            JButton button = new JButton("Delete!");
            button.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {                    
                    new DeleteEntry(temp.getId());
                }
            });
            innerBoxFirst.add(button); 
            
            JButton viewEntry = new JButton("More...");
            viewEntry.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {                 
                    ViewEntry entry = new ViewEntry(temp);
                    entry.setVisible(true);
                }
            });            
            innerBoxFirst.add(viewEntry);
            
            JButton updateEntryButton = new JButton("Update");
            updateEntryButton.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {                   
                    UpdateEntryView ue = new UpdateEntryView(temp);
                    ue.setVisible(true);
                }
            });            
            innerBoxFirst.add(updateEntryButton);
            
            descriptionText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 100, temp.getDescription());
            innerBoxSecond.add(new JLabel(descriptionText));
            innerBoxSecond.add(new JLabel(temp.getNumberOfPeopleInterested(temp.getId())+" are interested."));
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
        myEntries.clear();
    }
    private void PrintEntriesInterested(){
        interestEntries.stream().forEach((Entry temp) -> {  
            Box outerBox = Box.createHorizontalBox();
            
            Box innerBoxFirst = Box.createVerticalBox();
            Box innerBoxSecond = Box.createHorizontalBox();
            innerBoxFirst.add(Box.createRigidArea(new Dimension(5, 5)));
            innerBoxSecond.add(Box.createRigidArea(new Dimension(5, 5)));
            
            outerBox.add(innerBoxFirst);
            outerBox.add(innerBoxSecond);
            
            jInterest.add(outerBox);    
            JLabel JId = new JLabel(Integer.toString(temp.getId()));
            JId.setVisible(false);           
            innerBoxFirst.add(JId);
            innerBoxFirst.add(new JLabel("Street: " + temp.getAddress()));
            innerBoxFirst.add(new JLabel("City: " + temp.getCity()));
            innerBoxFirst.add(new JLabel("Country: " + temp.getCountry()));
            innerBoxFirst.add(new JLabel("Price: " + temp.getPrice() + "€"));          
            
            JButton viewEntry = new JButton("More...");
            viewEntry.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {                 
                    ViewEntry entry = new ViewEntry(temp);
                    entry.setVisible(true);
                }
            });            
            innerBoxFirst.add(viewEntry);
            
            descriptionText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 100, temp.getDescription());
            innerBoxSecond.add(new JLabel(descriptionText));
            innerBoxSecond.add(new JLabel(temp.getNumberOfPeopleInterested(temp.getId())+" are interested."));
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
        interestEntries.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelEntries = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jInterest = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Your Entries");
        setMinimumSize(new java.awt.Dimension(500, 290));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 290));

        jPanelEntries.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanelEntries);

        jTabbedPane1.addTab("My Entries", jScrollPane1);

        jInterest.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(jInterest);

        jTabbedPane1.addTab("Entries I'm Interested", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jInterest;
    private javax.swing.JPanel jPanelEntries;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
