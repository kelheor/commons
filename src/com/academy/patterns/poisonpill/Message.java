package com.academy.patterns.poisonpill;

import java.util.Map;

/**
 * Created by keos on 29.06.15.
 */
public interface Message {

    public static final Message POISON_PILL = new Message() {
        @Override
        public void addHeader(Headers header, String value) {
            throw poison();
        }

        @Override
        public String getHeader(Headers header) {
            throw poison();
        }

        @Override
        public Map<Headers, String> getHeaders() {
            throw poison();
        }

        @Override
        public void setBody(String body) {
            throw poison();
        }

        @Override
        public String getBody() {
            throw poison();
        }

        private RuntimeException poison() {
            return new UnsupportedOperationException("Poison");
        }
    };

    public enum Headers {
        DATE, SENDER
    }

    public void addHeader(Headers headers, String value);
    public String getHeader(Headers headers);
    public Map<Headers, String> getHeaders();
    public void setBody(String body);
    public String getBody();
}
