package com.bradleybehnke.axismed.client.application.Hobbies;

import com.bradleybehnke.axismed.client.application.ApplicationPresenter;
import com.bradleybehnke.axismed.client.place.NameTokens;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class Hobby1Presenter extends Presenter<Hobby1Presenter.MyView, Hobby1Presenter.MyProxy> {
    public interface MyView extends View {
        public Image getFpvImage();
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOBBY1)
    public interface MyProxy extends ProxyPlace<Hobby1Presenter> {
    }

    @Inject
    Hobby1Presenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, ApplicationPresenter.SLOT_MAIN, this);
    }

    public interface Images extends ClientBundle {


        public Images INSTANCE = GWT.create(Images.class);


        @Source("images/fpvRacing.png")
        ImageResource fpvImageRes();
    }

    @Override
    protected void onReset() {
        super.onReset();
        Image fpvImage = getView().getFpvImage();
        fpvImage.setResource(Images.INSTANCE.fpvImageRes());
    }
}
