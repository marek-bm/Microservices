package com.mj.rental.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import sun.net.www.protocol.http.AuthenticationHeader;

import javax.sql.DataSource;

@Configuration
public class AuthorizationServerConfig implements AuthorizationServerConfigurer {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    DataSource dataSource;
    @Autowired
    AuthenticationManager authenticationManager;

    //TokenStore to keep token in db.
    // Been needed in overridden endpointsConfigurer config method
    @Bean
    TokenStore jdbcTokenStore(){
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
        securityConfigurer.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer serviceConfigurer) throws Exception {
        serviceConfigurer.jdbc(dataSource).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws Exception {
        endpointsConfigurer
                .authenticationManager(authenticationManager)
                .tokenStore(jdbcTokenStore());
    }
}
