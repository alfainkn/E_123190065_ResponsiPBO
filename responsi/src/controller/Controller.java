/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Model;
import view.View;

/**
 *
 * @author HP
 */
public class Controller {
    
    Model modell;
    View vieww;
    
    public Controller(View view, Model model) {
        
        this.vieww = view;
        this.modell = model;
        
        if (modell.getData()!=0) {
            String dataKontak[][] = modell.readMovie();
            vieww.tabel.setModel((new JTable(dataKontak, vieww.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        vieww.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = vieww.getJudul();
                String alur = vieww.getAlur();
                String penokohan = vieww.getPenokohan();
                String akting = vieww.getAkting();
                String nilai = vieww.getNilai();
                modell.insertData(judul, alur, penokohan, akting, nilai);
         
                String dataMovie[][] = modell.readMovie();
                vieww.tabel.setModel((new JTable(dataMovie, vieww.namaKolom)).getModel());
            }
        });
        
        vieww.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = vieww.getJudul();
                String alur = vieww.getAlur();
                String penokohan = vieww.getPenokohan();
                String akting = vieww.getAkting();
                String nilai = vieww.getNilai();
                modell.updateData(judul, alur, penokohan, akting, nilai);
                
                String dataMovie[][] = modell.readMovie();
                vieww.tabel.setModel((new JTable(dataMovie, vieww.namaKolom)).getModel());
            }
        });
        
        vieww.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = vieww.getJudul();
                
                modell.deleteData(judul);
                
                String dataMovie[][] = modell.readMovie();
                vieww.tabel.setModel((new JTable(dataMovie, vieww.namaKolom)).getModel());
            }
        });
        
        vieww.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vieww.tfJudul.setText("");
                vieww.tfAlur.setText("");
                vieww.tfPenokohan.setText("");
                vieww.tfAkting.setText("");
                
            }
        });
        
       
        vieww.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = vieww.tabel.getSelectedRow();
                
                String judul = vieww.tabel.getValueAt(baris, 0).toString();                
                String alur = vieww.tabel.getValueAt(baris, 1).toString();
                String penokohan = vieww.tabel.getValueAt(baris, 2).toString();
                String akting = vieww.tabel.getValueAt(baris, 3).toString();
                
                vieww.tfJudul.setText(judul);
                vieww.tfAlur.setText(alur);
                vieww.tfPenokohan.setText(penokohan);
                vieww.tfAkting.setText(akting);

                
            }
        }
        );
    }

    

    
    
    
}
