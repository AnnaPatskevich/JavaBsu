/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package лось.лаба.pkg11.задание.pkg10;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame {

    public static boolean done=false;
    public  static String filename = "";
     public  static String filename_ind = "";
     public  static String Key = "";
     public  static String Value = "";   
     public static String result_message;
    public  MainWindow() {
        initComponents();
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        data_file = new java.awt.TextField();
        index_file = new java.awt.TextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        Statusbar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        data_file.setEditable(false);
        data_file.setEnabled(false);
        data_file.setText("Файл не выбран");
        data_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_fileActionPerformed(evt);
            }
        });

        index_file.setEditable(false);
        index_file.setEnabled(false);
        index_file.setText("Файл не выбран");

        label1.setText("Расположение файла с данными");

        label2.setText("Расположение файла с контейнерами");

        jMenu1.setText("Файл");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu1MouseExited(evt);
            }
        });

        jMenuItem2.setText("Открыть");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseExited(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Создать и открыть");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseExited(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Закрыть");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseExited(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Выполнить действие");
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu4MouseExited(evt);
            }
        });

        jMenuItem1.setText("Добавить запись");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseExited(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem5.setText("Добавить записи из файла");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseExited(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Распечатка файла");
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem6MouseExited(evt);
            }
        });
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Распечатка файла по возрастанию ключа");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseExited(evt);
            }
        });
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Распечатка файла по убыванию ключа");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem8MouseExited(evt);
            }
        });
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Поиск объекта по ключу");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem9MouseExited(evt);
            }
        });
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Поиск объектов, больших ключа");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem10MouseExited(evt);
            }
        });
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem12.setText("Поиск объектов, меньших ключа");
        jMenuItem12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem12MouseExited(evt);
            }
        });
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem13.setText("Удаление объектов по ключу");
        jMenuItem13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem13MouseExited(evt);
            }
        });
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem11.setText("Очистить файлы");
        jMenuItem11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem11MouseExited(evt);
            }
        });
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem14.setText("Удалить файлы");
        jMenuItem14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem14MouseExited(evt);
            }
        });
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem15.setText("Переименовать файлы");
        jMenuItem15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem15MouseExited(evt);
            }
        });
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem16.setText("Редактировать запись");
        jMenuItem16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem16MouseExited(evt);
            }
        });
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("О программе");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu3MouseExited(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Statusbar, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                    .addComponent(data_file, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(index_file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(index_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(Statusbar, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        label1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
         try {
              JOptionPane.showMessageDialog(this, (FileBuffer.ReadStringMas(filename)).compareTo("")>0 ? FileBuffer.ReadStringMas(filename) : "Файл пуст");
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        new AddRecordFromFile(this, true, filename, filename_ind);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jLabel1.setText("");
        JOptionPane.showMessageDialog(this, "Выберите папку для файла с данными");
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showOpenDialog(this);
        if (file.getSelectedFile() == null)
            return;
        File f = file.getSelectedFile();
        String filename_prev=filename;
        filename=f.getAbsolutePath();
        JOptionPane.showMessageDialog(this, "Выберите папку для файла с контейнерами");
        file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showOpenDialog(this);
        if (file.getSelectedFile() == null)
        {
            filename=filename_prev;
            return;
        }
        f = file.getSelectedFile();
        String filename_ind_prev=filename_ind;
        filename_ind=f.getAbsolutePath();
        NameFiles nameFiles = new NameFiles(this, true);
        if (done)
        {
            data_file.setText(filename);
            index_file.setText(filename_ind);
            File t = new File(filename);
            try {
              t.createNewFile();
              t = new File(filename_ind);
             t.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        else
        {   
            filename=filename_prev;
            filename_ind=filename_ind_prev;   
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jLabel1.setText("");
        JOptionPane.showMessageDialog(this, "Выберите файл с данными");
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.showOpenDialog(this);
        if (file.getSelectedFile() == null)
            return;
        boolean empty=false;
        try (RandomAccessFile file_check = new RandomAccessFile(file.getSelectedFile(), "r"))
        {
            if(file_check.length()==0)
            empty=true;
            else
            {
                String str=FileBuffer.ReadStringMas(file.getSelectedFile().getAbsolutePath());
                if (str.compareTo("")==0)
                throw new Exception("Выбранный файл некорректен");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Выбранный файл некорректен");
            return;
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Выбранный файл некорректен");
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        File f = file.getSelectedFile();
        String filename_prev=filename;
        filename=f.getAbsolutePath();
        file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        JOptionPane.showMessageDialog(this, "Выберите файл с контейнерами");
        file.showOpenDialog(this);
        if (file.getSelectedFile() == null)
        {
            filename=filename_prev;
            return;   
        }
        f = file.getSelectedFile();
        try (RandomAccessFile file_check = new RandomAccessFile(f, "r"))
        {
            if (empty)
            {
                if (file_check.length()!=0)
                throw new Exception("Выбранный файл с контейнерами некорректен");
            }
            else
            {
                if (file_check.length()==0)
                    throw new Exception("Выбранный файл с контейнерами некорректен");
                FileBuffer.Index.test_files(filename, f.getAbsolutePath());   
            }
        } catch (FileNotFoundException ex) {
            filename=filename_prev;
            JOptionPane.showMessageDialog(this, "Выбранный файл с контейнерами некорректен");
            return;
        } catch (IOException ex) {
            filename=filename_prev;
            JOptionPane.showMessageDialog(this, "Выбранный файл с контейнерами некорректен");
            return;
        } catch (Exception ex) {
            filename=filename_prev;
            JOptionPane.showMessageDialog(this, "Выбранный файл с контейнерами некорректен");
            return;
        }
        filename_ind=f.getAbsolutePath();
        data_file.setText(filename);
        index_file.setText(filename_ind);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
       try 
       {
         new SelectKeyName(this, true, "Распечатка файла по возрастанию ключа");
                   if (done)
                   {
                        JOptionPane.showMessageDialog(this,result_message+FileBuffer.Index.str_by_encreasing_index(filename, Key, filename_ind));
                        done=false;
                   }
        } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, e);
               }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        try {
                   new SelectKeyName(this, true, "Распечатка файла по убыванию ключа");
                   if (done)
                   {
                       JOptionPane.showMessageDialog(this,result_message+FileBuffer.Index.str_by_decreasing_index(filename, Key, filename_ind));
                       done=false;
                   }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, e);
               }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
         try {
                   new SelectKey(this, true, "Поиск объекта по ключу");
                   if (done)
                   {
                        JOptionPane.showMessageDialog(this,result_message+FileBuffer.Index.str_by_index(filename, Key, Value,filename_ind));   
                        done=false;
                   }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, e);
               }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        try {
                   new SelectKey(this, true, "Поиск объектов, больших ключа");
                   if (done)
                   {
                        JOptionPane.showMessageDialog(this,result_message+FileBuffer.Index.str_larger_index(filename, Key, Value,filename_ind));   
                        done=false;
                   }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, e);
               }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
            try {
                   new SelectKey(this, true, "Поиск объектов, меньших ключа");
                   if (done)
                   {
                        JOptionPane.showMessageDialog(this,result_message+FileBuffer.Index.str_lower_index(filename, Key, Value,filename_ind));   
                        done=false;
                   }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, e);
               }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        try {
                   new SelectKey(this, true, "Удаление объектов по ключу");
                   if (done)
                   {
                       JOptionPane.showMessageDialog(this,result_message+FileBuffer.Index.delete_by_index(filename, Key, Value,filename_ind));
                       done=false;
                   }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, e);
               }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        System.gc();
        File f = new File(filename);
                    System.gc();
                    f.delete();
                    System.gc();
                    f = new File(filename_ind);
                    System.gc();
                    f.delete();
                    System.gc();
                    data_file.setText("Файл не выбран");
                    index_file.setText("Файл не выбран");
                    filename = "";
                    filename_ind = "";
                    JOptionPane.showMessageDialog(this, "Файлы удалёны");
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        new Rename(this, true, filename, filename_ind);
                      if (done)
                      {
                        data_file.setText(filename);
                        index_file.setText(filename_ind);
                        JOptionPane.showMessageDialog(this, "Файлы переименованы");   
                      }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
       new ChooseRecord(this, true, filename, filename_ind);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
            return;
        }
        new AddRecord(this, true, filename, filename_ind);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void data_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_fileActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        jLabel1.setText("Выбран пункт меню Файл");
    }//GEN-LAST:event_jMenu1MenuSelected

    private void jMenuItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseEntered
        jLabel1.setText("Открыть файл с данными и файл с контейнерами");
    }//GEN-LAST:event_jMenuItem2MouseEntered

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        jLabel1.setText("Файл");
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenu1MouseExited

    private void jMenuItem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem2MouseExited

    private void jMenuItem3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseEntered
        jLabel1.setText("Создать и открыть файл с данными и файл с контейнерами");
    }//GEN-LAST:event_jMenuItem3MouseEntered

    private void jMenuItem3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem3MouseExited

    private void jMenuItem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseEntered
        jLabel1.setText("Закрыть приложение");
    }//GEN-LAST:event_jMenuItem4MouseEntered

    private void jMenuItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem4MouseExited

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        jLabel1.setText("Выбран пункт меню Выполнить действие");
    }//GEN-LAST:event_jMenu4MenuSelected

    private void jMenu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseEntered
        jLabel1.setText("Выбрать действие с файлом с данными");
    }//GEN-LAST:event_jMenu4MouseEntered

    private void jMenu4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenu4MouseExited

    private void jMenuItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseEntered
        jLabel1.setText("Добавить запись в файл c данными");
    }//GEN-LAST:event_jMenuItem1MouseEntered

    private void jMenuItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem1MouseExited

    private void jMenuItem5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseEntered
        jLabel1.setText("Добавить записи из выбираемого файла в файл с данными");
    }//GEN-LAST:event_jMenuItem5MouseEntered

    private void jMenuItem5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseExited
       jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem5MouseExited

    private void jMenuItem6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MouseEntered
        jLabel1.setText("Вывести все записи из файла");
    }//GEN-LAST:event_jMenuItem6MouseEntered

    private void jMenuItem6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem6MouseExited

    private void jMenuItem7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseEntered
        jLabel1.setText("Вывести все записи по возрастанию выбираемого ключа");
    }//GEN-LAST:event_jMenuItem7MouseEntered

    private void jMenuItem7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem7MouseExited

    private void jMenuItem8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MouseEntered
        jLabel1.setText("Вывести все записи по убыванию выбираемого ключа");
    }//GEN-LAST:event_jMenuItem8MouseEntered

    private void jMenuItem8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem8MouseExited

    private void jMenuItem9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseEntered
        jLabel1.setText("Вывести все записи по выбираемому ключу");
    }//GEN-LAST:event_jMenuItem9MouseEntered

    private void jMenuItem9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem9MouseExited

    private void jMenuItem10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem10MouseEntered
        jLabel1.setText("Вывести все записи со значениями ключей больших выбираемомого ключа");
    }//GEN-LAST:event_jMenuItem10MouseEntered

    private void jMenuItem10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem10MouseExited
         jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem10MouseExited

    private void jMenuItem12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem12MouseEntered
         jLabel1.setText("Вывести все записи со значениями ключей меньших выбираемомого ключа");
    }//GEN-LAST:event_jMenuItem12MouseEntered

    private void jMenuItem12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem12MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem12MouseExited

    private void jMenuItem13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem13MouseEntered
        jLabel1.setText("Удалить все записи со значением выбираемомого ключа");
    }//GEN-LAST:event_jMenuItem13MouseEntered

    private void jMenuItem13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem13MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem13MouseExited

    private void jMenuItem14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem14MouseEntered
        jLabel1.setText("Удалить файл с данными и файл с контейнерами");
    }//GEN-LAST:event_jMenuItem14MouseEntered

    private void jMenuItem14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem14MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem14MouseExited

    private void jMenuItem15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem15MouseEntered
        jLabel1.setText("Переименовать файл с данными или файл с контейнерами");
    }//GEN-LAST:event_jMenuItem15MouseEntered

    private void jMenuItem15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem15MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem15MouseExited

    private void jMenuItem16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem16MouseEntered
        jLabel1.setText("Редактировать запись в файле с данными. Поиск нужной записи ведятся по номеру рейса");
    }//GEN-LAST:event_jMenuItem16MouseEntered

    private void jMenuItem16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem16MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem16MouseExited

    private void jMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseEntered
        jLabel1.setText("Вывести информацию о приложении");
    }//GEN-LAST:event_jMenu3MouseEntered

    private void jMenu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseExited
       jLabel1.setText("");
    }//GEN-LAST:event_jMenu3MouseExited

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        jLabel1.setText("");
        JOptionPane.showMessageDialog(this, "Лабораторная работа №11 задание №10.\nВыполнил Лось Павел");
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        jLabel1.setText("");
        if (filename.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Не выбран исходный файл");
            return;
        }
        if (filename_ind.compareTo("")==0)
        {
             JOptionPane.showMessageDialog(this, "Не выбран файл с контейнерами");
             return;
        }
        File f = new File(filename);
                    System.gc();
        f.delete();
         System.gc();
        try {
            f.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            return;
        }
        System.gc();
                    f = new File(filename_ind);
                    System.gc();
                    f.delete();
       System.gc();
        try {
            f.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            return;
        }
        JOptionPane.showMessageDialog(this, "Файлы очищены"); 
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem11MouseEntered
        jLabel1.setText("Удалить все записи из файла с данными и очистить файл с контейнерами");
    }//GEN-LAST:event_jMenuItem11MouseEntered

    private void jMenuItem11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem11MouseExited
        jLabel1.setText("");
    }//GEN-LAST:event_jMenuItem11MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Statusbar;
    private java.awt.TextField data_file;
    private java.awt.TextField index_file;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}