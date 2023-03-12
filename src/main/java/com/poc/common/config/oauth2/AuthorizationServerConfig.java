package com.poc.common.config.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60;
    static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.grantTypePassword}")
    private String grantTypePassword;

    @Value("${auth.authorizationCode}")
    private String authorizationCode;

    @Value("${auth.refreshToken}")
    private String refreshToken;

    @Value("${auth.implicit}")
    private String implicit;

    @Value("${auth.scopeRead}")
    private String scopeRead;

    @Value("${auth.scopeWrite}")
    private String scopeWrite;

    @Value("${auth.trust}")
    private String trust;

    private final UserDetailsService userDetailsService;
    private final TokenStore tokenStore;
    private final AuthenticationManager authenticationManager;

    public AuthorizationServerConfig(UserDetailsService userDetailsService, TokenStore tokenStore, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.tokenStore = tokenStore;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configure) throws Exception {

        configure
                .inMemory()
                .withClient(clientId)
                .secret(clientSecret)
                .authorizedGrantTypes(grantTypePassword, authorizationCode, refreshToken, implicit)
                .scopes(scopeRead, scopeWrite, trust)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
                refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore);
        endpoints.userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager);
    }

}
