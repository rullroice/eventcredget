package com.tilincorps.controller;

import com.tilincorps.model.Credential;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainController {
    private static MainController instance;
    private final List<Credential> credentials;

    private MainController() {
        credentials = new ArrayList<>();
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void refreshTable(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    credentials.forEach(cred -> model.addRow(new Object[]{
        cred.getName(),
        cred.getRut(),
        cred.getRole(),
        cred.getCreationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }));
    }

    public void handleSaveCredential(String nombre, String cargo, String rut, String fechaNacimiento) {
    try {
        Credential cred = new Credential(
            nombre,
            cargo,
            rut,
            LocalDate.now(),
            LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        credentials.add(cred);
        JOptionPane.showMessageDialog(null, "Credencial guardada!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}
