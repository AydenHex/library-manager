package com.eventListeners;

import com.models.State;
import com.views.BookForm;
import com.views.ControlButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookListener implements ActionListener {
    BookForm bookform;

    public AddBookListener(BookForm bookform) {
        this.bookform = bookform;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!this.bookform.getStatus()) {
            this.bookform.enableForm();
            this.bookform.setAction("add");
            State.getInstance().addAction = true;
        }
        else {
            this.bookform.disableForm();
            this.bookform.setAction("");
            State.getInstance().addAction = false;

        }
    }
}
