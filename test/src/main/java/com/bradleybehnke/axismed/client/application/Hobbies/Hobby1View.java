package com.bradleybehnke.axismed.client.application.Hobbies;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.inject.Inject;

public class Hobby1View extends ViewImpl implements Hobby1Presenter.MyView {

    interface Binder extends UiBinder<Widget, Hobby1View> {
    }

    @UiField
    Image fpvImage;

    public Image getFpvImage(){
        return fpvImage;
    }

    @Inject
    Hobby1View(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
