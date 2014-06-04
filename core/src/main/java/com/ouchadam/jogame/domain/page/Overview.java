package com.ouchadam.jogame.domain.page;

import com.ouchadam.jogame.domain.ActiveConstructions;

public class Overview extends BasePage {

    public final ActiveConstructions constructions;

    public Overview(EveryPage everyPage, ActiveConstructions constructions) {
        super(everyPage);
        this.constructions = constructions;
    }

}
