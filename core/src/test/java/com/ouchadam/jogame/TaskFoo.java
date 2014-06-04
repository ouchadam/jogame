package com.ouchadam.jogame;

import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.page.Overview;
import com.ouchadam.jogame.request.RequestFactory;

import org.junit.Test;

public class TaskFoo {

    private final RequestFactory requestFactory;
    private final Session session;

    public TaskFoo() {
        requestFactory = RequestFactory.newInstance();
        session = requestFactory.login(Constants.USERNAME, Constants.PASSWORD).execute();
    }

    @Test
    public void testName() {
        Overview overview = requestFactory.overview("").execute(session);
        System.out.println(overview);
//        String token = requestFactory.fleetToken("").execute(session);
    }
}
