package com.bradleybehnke.axismed.client.application.Hobbies;

import com.google.gwt.dom.client.InputElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.inject.Inject;

public class Hobby2View extends ViewImpl implements Hobby2Presenter.MyView {

    interface Binder extends UiBinder<Widget, Hobby2View> {
    }

    @UiField
    TextBox txtName;
    @UiField
    InputElement txtDate;
    @UiField
    Button btnReset;

    public TextBox getNameBox(){
        return txtName;
    }

    public InputElement getDateBox(){
        return txtDate;
    }

    public Button getResetButton(){
        return btnReset;
    }

    @Inject
    Hobby2View(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
