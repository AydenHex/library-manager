package com.views;

import com.models.State;

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
    private ControlButtons control;


    public WindowManagers() {
        setTitle("Library Manager");
        setSize(760, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create compoennt
        table = new Table();
        form = new BookForm(this.table);
        control = new ControlButtons(this.form, this.table);

        State.setBookForm(form);

        //Init child component
        initCompoennt();
    }

    private void initCompoennt() {
        // Add books
        add(table);
        add(form);
        add(control);
        getContentPane().add(table, BorderLayout.WEST);
        getContentPane().add(form, BorderLayout.EAST);
        getContentPane().add(control, BorderLayout.SOUTH);

        // Add the menu bar
        menuBar = new MenuBar(table);
        setJMenuBar(menuBar);
        

    }

}