package com.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class WindowManagers extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static boolean modification;

    //Components
    private MenuBar menuBar;
    private Table table;
    private BookForm form;


    public WindowManagers() {
        setTitle("Library Manager");
        setSize(760, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create compoennt
        table = new Table();
        form = new BookForm();

        //Init child component
        initCompoennt();
    }

    private void initCompoennt() {
        // Add the menu bar
        menuBar = new MenuBar();
        setJMenuBar(menuBar);



        // Create form



        // Add books
        add(table);
        add(form);
        getContentPane().add(table, BorderLayout.WEST);
        getContentPane().add(form, BorderLayout.EAST);
        

    }

}