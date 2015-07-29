package com.bradleybehnke.axismed.client.application.Hobbies;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class Hobby2Module extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(Hobby2Presenter.class, Hobby2Presenter.MyView.class, Hobby2View.class,
                Hobby2Presenter.MyProxy.class);
    }
}
