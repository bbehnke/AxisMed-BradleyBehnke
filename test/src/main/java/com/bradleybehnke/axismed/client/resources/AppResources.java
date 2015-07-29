package com.bradleybehnke.axismed.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface AppResources extends ClientBundle {
    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
        String header();
        String name();
        String hobbyOuter();
        String hobbyMiddle();
        String hobbyInner();
        String hobby1Image();
        String btnHome();
        String btnHobby1();
        String btnHobby2();
        String hobbyMiddleSmall();
        String hobbyMiddleEndSmall();
        String hobbyInnerSmall();
        String hobbyImageSmall();
        String hobbyTable();
        String hobby2Outer();
        String hobby2Middle();
        String hobby2Inner();
        String lblName();
        String txtName();
        String lblStarted();
        String datePicker();
        String btnReset();
    }

    @Source("images/headerBackground.png")
    ImageResource headerBackground();

    @Source("images/background.png")
    ImageResource background();

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source("css/style.gss")
    Style style();
}
