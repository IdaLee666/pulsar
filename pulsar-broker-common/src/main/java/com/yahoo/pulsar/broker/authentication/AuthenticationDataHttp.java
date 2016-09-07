/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.pulsar.broker.authentication;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationDataHttp implements AuthenticationDataSource {

    protected final HttpServletRequest request;
    protected final SocketAddress remoteAddress;

    public AuthenticationDataHttp(HttpServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException();
        }
        this.request = request;
        this.remoteAddress = new InetSocketAddress(request.getRemoteAddr(), request.getRemotePort());
    }

    /*
     * HTTP
     */

    @Override
    public boolean hasDataFromHttp() {
        return true;
    }

    @Override
    public String getHttpAuthType() {
        return request.getAuthType();
    }

    @Override
    public String getHttpHeader(String name) {
        return request.getHeader(name);
    }

    /*
     * Peer
     */

    @Override
    public boolean hasDataFromPeer() {
        return true;
    }

    @Override
    public SocketAddress getPeerAddress() {
        return remoteAddress;
    }

}
