/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import tztbackoffice.APIConnector;
import tztbackoffice.Models.KlantModel;

/**
 *
 * @author Andy
 */
public class KlantDetailsScreen extends JDialog implements ActionListener {

    private JLabel firstNameLabel = new JLabel("Voornaam");
    private JLabel lastNameLabel = new JLabel("Achternaam");
    private JLabel nameAdditionLabel = new JLabel("Tussenvoegsel");
    private JLabel zipCodeLabel = new JLabel("Postcode");
    private JLabel houseNumberLabel = new JLabel("Huisnummer");

    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    private JTextField nameAdditionField = new JTextField();
    private JTextField zipCodeField1 = new JTextField();
    private JTextField zipCodeField2 = new JTextField();
    private JTextField houseNumberField = new JTextField();

    private JTextField addressField = new JTextField();
    private JTextField cityField = new JTextField();
    private JTextField countryField = new JTextField();

    private JButton editButton = new JButton("Wijzigen");
    private JButton savebutton = new JButton("Opslaan");
    private JButton cancelbutton = new JButton("Annuleren");

    private int screenWidth = 600;
    private int screenHeight = 500;

    private KlantModel selectedKlant;
    private APIConnector apiConnector = new APIConnector();

    public KlantDetailsScreen() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel topContainerPanel = new JPanel();
        setResizable(false);

        topContainerPanel.setLayout(new GridLayout(5, 2, 20, 20));
        topContainerPanel.add(firstNameLabel);
        topContainerPanel.add(firstNameField);
        topContainerPanel.add(lastNameLabel);
        topContainerPanel.add(lastNameField);
        topContainerPanel.add(nameAdditionLabel);
        topContainerPanel.add(nameAdditionField);
        topContainerPanel.setPreferredSize(new Dimension(screenWidth - 10, (screenHeight / 3) * 2 - 90));
        JPanel multipleFieldContainer = new JPanel();
        multipleFieldContainer.setLayout(new GridLayout(2, 4, 0, 0));

        JPanel zipCodeContainerPanel = new JPanel();
        zipCodeContainerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        zipCodeField1.setPreferredSize(new Dimension(90, 30));
        zipCodeField2.setPreferredSize(new Dimension(40, 30));
        zipCodeContainerPanel.add(zipCodeField1);
        zipCodeContainerPanel.add(zipCodeField2);

        cancelbutton.addActionListener(this);
        //Create and add container for the buttons
        JPanel buttonBarContainer = new JPanel();
        buttonBarContainer.setPreferredSize(new Dimension(screenWidth,50));
        buttonBarContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonBarContainer.add(cancelbutton);
        buttonBarContainer.add(editButton);
        buttonBarContainer.add(savebutton);
        
        //Create and add container for address fields
        multipleFieldContainer.add(zipCodeLabel);
        multipleFieldContainer.add(zipCodeContainerPanel);
        multipleFieldContainer.add(houseNumberLabel);
        multipleFieldContainer.add(houseNumberField);
        multipleFieldContainer.add(new JLabel(" "));
        multipleFieldContainer.add(addressField);
        multipleFieldContainer.add(cityField);
//        multipleFieldContainer.add(countryField);
        multipleFieldContainer.setPreferredSize(new Dimension(screenWidth - 10, screenHeight / 3 - 100));
        add(topContainerPanel);
        add(multipleFieldContainer);
        add(buttonBarContainer);

        setSize(new Dimension(screenWidth, screenHeight-100));
        setLocationRelativeTo(null);

    }

    private String getFirstZipcodePart(String zipCode) {
        //Wil only work for dutch zip codes (with 4 numbers at the beginning).
        return zipCode.substring(0, 4);
    }

    private String getSecondZipCodePart(String zipCode) {
        //get letters from zip code
        int beginIndex = 4;
        if (zipCode.contains(" ")) {
            beginIndex = 5;
        }
        return zipCode.substring(beginIndex, beginIndex + 2);
    }

    public void showAndUpdateKlant(KlantModel newKlant) {
        
        selectedKlant = newKlant;

        firstNameField.setText(selectedKlant.getFirstname());
        lastNameField.setText(selectedKlant.getLastname());
        nameAdditionField.setText(selectedKlant.getMiddlename());
        zipCodeField1.setText(getFirstZipcodePart(selectedKlant.getZipcode()));
        zipCodeField2.setText(getSecondZipCodePart(selectedKlant.getZipcode()));
        zipCodeField1.getDocument().addDocumentListener(zipListener);
        zipCodeField2.getDocument().addDocumentListener(zipListener);
        houseNumberField.setText(selectedKlant.getHousenumber());

        setVisible(true);
    }

    DocumentListener zipListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            validateAddress();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validateAddress();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            validateAddress();
        }
    };

    private void validateAddress() {
        try {
            String simpleStreetAndCity = apiConnector.validateAddress(zipCodeField1.getText() + "" + zipCodeField2.getText());
            if (!simpleStreetAndCity.equals("")) {
                String[] streetAndCity = simpleStreetAndCity.split("STRINGDIVIDER");
                if (streetAndCity.length == 2) {
                    addressField.setText(streetAndCity[0]);
                    cityField.setText(streetAndCity[1]);
                }
            } else {
                addressField.setText("");
                cityField.setText("");
            }

        } catch (IOException ex) {
            Logger.getLogger(KlantDetailsScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelbutton){
            setVisible(false);
        }
    }

}
