package com.bradleybehnke.axismed.client.application.Hobbies;

import com.bradleybehnke.axismed.client.application.ApplicationPresenter;
import com.bradleybehnke.axismed.client.place.NameTokens;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hobby2Presenter extends Presenter<Hobby2Presenter.MyView, Hobby2Presenter.MyProxy> {
    private static Logger rootLogger;
    public interface MyView extends View {
        public TextBox getNameBox();
        public InputElement getDateBox();
        public Button getResetButton();
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOBBY2)
    public interface MyProxy extends ProxyPlace<Hobby2Presenter> {
    }

    @Inject
    Hobby2Presenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        rootLogger = Logger.getLogger("");
        TextBox nameBox = getView().getNameBox();
        Button resetButton = getView().getResetButton();
        resetButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TextBox nameBox = getView().getNameBox();
                InputElement dateBox = getView().getDateBox();
                String name = nameBox.getValue();
                String date = dateBox.getValue();
                nameBox.setText("");
                dateBox.setValue(dateBox.getDefaultValue());
                rootLogger.log(Level.INFO, "Name: " + name + ", Start Date: " + date);
            }
        });

        nameBox.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event_) {
                boolean enterPressed = KeyCodes.KEY_ENTER == event_
                        .getNativeEvent().getKeyCode();
                if (enterPressed) {
                    getView().getDateBox().focus();
                }
            }
        });
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, ApplicationPresenter.SLOT_MAIN, this);
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
