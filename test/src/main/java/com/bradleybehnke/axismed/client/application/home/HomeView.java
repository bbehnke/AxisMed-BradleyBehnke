package com.bradleybehnke.axismed.client.application.home;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomeView extends ViewImpl implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    Image fpvImageSmall;

    @UiField
    Image mBikeImageSmall;

    public Image getFpvImage(){
        return fpvImageSmall;
    }

    public Image getMountainBikeImage(){
        return mBikeImageSmall;
    }

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
