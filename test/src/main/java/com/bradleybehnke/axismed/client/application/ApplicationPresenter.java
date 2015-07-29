package com.bradleybehnke.axismed.client.application;

import com.bradleybehnke.axismed.client.place.NameTokens;
import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {

    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.MAIN)
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_MAIN = new GwtEvent.Type<>();

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
}
