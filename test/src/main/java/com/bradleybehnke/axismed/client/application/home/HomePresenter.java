package com.bradleybehnke.axismed.client.application.home;

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

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
    public interface MyView extends View {
        public Image getFpvImage();
        public Image getMountainBikeImage();
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOME)
    public interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(
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


        @Source("images/fpvRacingSmall.png")
        ImageResource fpvImageRes();

        @Source("images/mountainBikingSmall.png")
        ImageResource mBikeImageRes();
    }

    @Override
    protected void onReset() {
        super.onReset();
        getView().getFpvImage().setResource(Images.INSTANCE.fpvImageRes());
        getView().getMountainBikeImage().setResource(Images.INSTANCE.mBikeImageRes());
    }

}
