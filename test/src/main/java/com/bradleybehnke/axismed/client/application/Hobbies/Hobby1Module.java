package com.bradleybehnke.axismed.client.application.Hobbies;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class Hobby1Module extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(Hobby1Presenter.class, Hobby1Presenter.MyView.class, Hobby1View.class,
                Hobby1Presenter.MyProxy.class);
    }
}
