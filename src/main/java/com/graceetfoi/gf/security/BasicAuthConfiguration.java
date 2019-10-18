//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {
    public BasicAuthConfiguration() {
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        ((InMemoryUserDetailsManagerConfigurer)auth.inMemoryAuthentication().withUser("user").password("password").roles(new String[]{"USER"}).and()).withUser("admin").password("admin_redacteur_2019").roles(new String[]{"USER", "ADMIN"});
    }

    protected void configure(HttpSecurity http) throws Exception {
       // http.requiresChannel().anyRequest().requiresSecure();
        ((HttpSecurity)((FormLoginConfigurer)((FormLoginConfigurer)((HttpSecurity)((AuthorizedUrl)((AuthorizedUrl)((AuthorizedUrl)((AuthorizedUrl)http.authorizeRequests().antMatchers(new String[]{"/resources/**"})).permitAll().antMatchers(new String[]{"/"})).permitAll().antMatchers(new String[]{"/redacteur"})).hasRole("ADMIN").anyRequest()).permitAll().and()).formLogin().loginPage("/connexion").defaultSuccessUrl("/redacteur", true)).permitAll()).and()).logout().permitAll();
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities(new String[]{"ROLE_ADMIN"});
    }
}
