package com.ouchadam.jogame.api;

import com.github.kevinsawicki.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class JogameRequestBuilder {

    public static Get get() {
        return new Get();
    }

    public static Post post() {
        return new Post();
    }

    public static class Get extends builder<Get> {

        @Override
        public JogameRequest build() {
            return new JogameRequest(get());
        }

        @Override
        protected Get getThis() {
            return this;
        }

    }

    public static class Post extends builder<Post> {

        public JogameRequest form(Map<String, String> formData) {
            return new JogameRequest(build().asRequest().form(formData));
        }

        @Override
        public JogameRequest build() {
            return new JogameRequest(post());
        }

        @Override
        protected Post getThis() {
            return this;
        }

    }

    public abstract static class builder<T> {

        private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36";

        private final Map<String, String> queryParams;
        private String url;
        private Session session;
        private String referer;

        protected builder() {
            this.queryParams = new HashMap<String, String>();
            this.url = null;
            this.session = null;
            this.referer = null;
        }

        public T url(String baseUrl) {
            this.url = baseUrl;
            return getThis();
        }

        public T session(Session session) {
            this.session = session;
            return getThis();
        }

        public T referer(String referer) {
            this.referer = referer;
            return getThis();
        }

        public T page(String page) {
            queryParams.put("page", page);
            return getThis();
        }

        public T planet(String planet) {
            queryParams.put("cp", planet);
            return getThis();
        }

        public T param(String name, String value) {
            queryParams.put(name, value);
            return getThis();
        }

        protected HttpRequest get() {
            return apply(HttpRequest.get(url, queryParams, false));
        }

        protected HttpRequest post() {
            return apply(HttpRequest.post(url, queryParams, false));
        }

        private HttpRequest apply(HttpRequest httpRequest) {
            httpRequest.userAgent(USER_AGENT);
            httpRequest.followRedirects(false);
            httpRequest.header("Accept-Language", "en-GB,en-US;q=0.8,en;q=0.6");
            httpRequest.header("Accept-Encoding", "gzip,deflate,sdch");
            httpRequest.header("Connection", "keep-alive");
            httpRequest.uncompress(true);
            httpRequest.header("Host", "s125-en.ogame.gameforge.com");
            httpRequest.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            if (session != null) {
                httpRequest.header("Cookie", session.value());
            }
            if (referer != null) {
                httpRequest.referer(referer);
            }
            return httpRequest;
        }

        public abstract JogameRequest build();

        protected abstract T getThis();
    }

}
