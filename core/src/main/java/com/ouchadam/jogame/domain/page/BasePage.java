package com.ouchadam.jogame.domain.page;

public abstract class BasePage {

    private final EveryPage everyPage;

    public BasePage(EveryPage everyPage) {
        this.everyPage = everyPage;
    }

    public EveryPage everyPage() {
        return everyPage;
    }
}
