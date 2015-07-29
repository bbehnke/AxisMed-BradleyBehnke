package com.bradleybehnke.axismed.client.application;

import com.bradleybehnke.axismed.client.application.Hobbies.Hobby1Module;
import com.bradleybehnke.axismed.client.application.Hobbies.Hobby2Module;
import com.bradleybehnke.axismed.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new Hobby1Module());
        install(new Hobby2Module());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
