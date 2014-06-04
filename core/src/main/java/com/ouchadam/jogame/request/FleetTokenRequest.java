package com.ouchadam.jogame.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.MissionType;
import com.ouchadam.jogame.parser.Parser;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;

class FleetTokenRequest extends JogameApiRequest<String> {

    private final Parser<String> tokenParser;

    FleetTokenRequest(SessionValidator sessionValidator, String planet, Parser<String> tokenParser) {
        super(sessionValidator, planet);
        this.tokenParser = tokenParser;
    }

    @Override
    protected JogameRequest buildRequest(Session session, String planet) {
        JogameRequestBuilder.Get builder = JogameRequestBuilder.get()
                .url(BASE_LOGGED_IN_URL)
                .session(session)
                .page("eventList")
                .param("ajax", "1");
        attachPlanet(planet, builder);
        return builder.build();
    }

    private Map<String, String> createQuery() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("page", "messages");
        map.put("cp", "33630826");
        return map;
    }

    private String createReferer(Session session) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("page", "overview");
        map.put("PHPSESSID", session.getPhpSession());
        return HttpRequest.append(BASE_LOGGED_IN_URL, map);
    }

    private Map<String, String> createData() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("type", "1");
        map.put("mission", MissionType.MISSION_EXPEDITION.value());
        map.put("union", "0");
        map.put("am202", "1");
        map.put("galaxy", "1");
        map.put("system", "43");
        map.put("position", "7");
        map.put("acsValues", "-");
        map.put("speed", "10");

        /*

        fleet1 =

        galaxy:1
system:42
position:10
type:1
mission:0
speed:10
am204:
am206:
am202:1
am210:1



            type:1
            mission:0
            union:0
            am202:1
            galaxy:7
            system:42
            position:10
            acsValues:-
            speed:10


         */
        return map;
    }

    @Override
    protected String onResult(Document doc, JogameRequest request) {
        return tokenParser.parse(doc);
    }

}