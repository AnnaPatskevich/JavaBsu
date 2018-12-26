/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package лось.лаба.pkg11.задание.pkg10;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

public class ChangeRecord extends javax.swing.JDialog {

    private String filename;
    private String filename_ind;
    int choosed_number;
    public ChangeRecord(JDialog parent, boolean modal, String filename, String filename_ind, int choosed_number) {
        super(parent, modal);
        initComponents();
        this.filename=filename;
        this.filename_ind=filename_ind;
        this.choosed_number=choosed_number;
        fill_fields(choosed_number);
        setVisible(true);
    }
    
    void fill_fields(int choosed_number)
    {
        try {
            Luggage lug = FileBuffer.Index.get_object_by_number_of_flight(filename, filename_ind, choosed_number);
            number_of_flight.setText(Integer.toString(lug.getNumber_of_flight()));
            date_of_flight.setText(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(lug.getDate_of_flight()));
            destination.setText(lug.getDestination());
            weight.setText(Double.toString(lug.getWeight()));            
            passenger_surname.setText(lug.getPassenger_surname());
            passenger_name.setText(lug.getPassenger_name());
            passenger_patronomic.setText(lug.getPassenger_patronomic());
            count_of_places.setText(Integer.toString(lug.getCount_of_places()));
        } catch (IOException ex) {
            Logger.getLogger(ChangeRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangeRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ChangeRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date_of_flight = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        destination = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        passenger_surname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passenger_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passenger_patronomic = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        count_of_places = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        number_of_flight = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        AddButton.setText("Изменить запись");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Отмена");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Имя");

        jLabel1.setText("Заполните поля:");

        jLabel7.setText("Отчество");

        jLabel2.setText("Номер полёта");

        jLabel3.setText("Дата вылета Формат: дд.мм.гггг чч:мм");

        jLabel8.setText("Количество мест для багажа");

        jLabel4.setText("Пункт назначения");

        jLabel5.setText("Фамилия");

        jLabel9.setText("Суммарная масса");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(number_of_flight)
                                    .addComponent(passenger_surname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date_of_flight)
                                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passenger_name)
                            .addComponent(passenger_patronomic)
                            .addComponent(count_of_places)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(37, 37, 37)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(number_of_flight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(passenger_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(date_of_flight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(passenger_patronomic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(count_of_places, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passenger_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(jButton1))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try
        {
            if (number_of_flight.getText().compareTo("")==0)
                throw new Exception("Поле number_of_flight пустое");
            try {
                  Integer.parseInt(number_of_flight.getText());   
            } catch (Exception e) {
                throw new Exception("Неверные данные в поле Номер полёта");
            }
            if (date_of_flight.getText().compareTo("")==0)
                throw new Exception("Поле Номер полёта пустое");
            try {
                   SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
                    sp.parse(date_of_flight.getText()); 
            } catch (Exception e) {
                throw new Exception("Неверные данные в поле Дата вылета");
            }
            if (destination.getText().compareTo("")==0)
                throw new Exception("Поле Пункт назначения пустое");
            if (passenger_surname.getText().compareTo("")==0)
                throw new Exception("Поле Фамилия пустое");
            if (passenger_name.getText().compareTo("")==0)
                throw new Exception("Поле Имя пустое");
            if (passenger_patronomic.getText().compareTo("")==0)
                throw new Exception("Поле Отчество пустое");
            if (count_of_places.getText().compareTo("")==0)
                throw new Exception("Поле Количество мест для багажа пустое");
            try {
                  Integer.parseInt(count_of_places.getText());   
            } catch (Exception e) {
                throw new Exception("Неверные данные в поле Количество мест для багажа");
            }
              if (weight.getText().compareTo("")==0)
                throw new Exception("Поле Суммарная масса пустое");
            try {
                  Double.parseDouble(weight.getText());   
            } catch (Exception e) {
                throw new Exception("Неверные данные в поле Суммарная масса");
            }
            String [] mas = new String[8];
            mas[0]= number_of_flight.getText();
            mas[1]= date_of_flight.getText();
            mas[2]= destination.getText();
            mas[3]= passenger_surname.getText();
            mas[4]= passenger_name.getText();
            mas[5]= passenger_patronomic.getText();
            mas[6]= count_of_places.getText();
            mas[7]= weight.getText();
            Luggage lug = new Luggage(mas);
            try
            {
                FileBuffer.Index.change_record(filename, filename_ind, choosed_number, lug);
                ChooseRecord.done=true;
            }
            catch(Exception e)
            {
                javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
                return;
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Запись изменена");
            dispose();
        }
        catch (Exception e)
        {
           javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField count_of_places;
    private javax.swing.JTextField date_of_flight;
    private javax.swing.JTextField destination;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField number_of_flight;
    private javax.swing.JTextField passenger_name;
    private javax.swing.JTextField passenger_patronomic;
    private javax.swing.JTextField passenger_surname;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
