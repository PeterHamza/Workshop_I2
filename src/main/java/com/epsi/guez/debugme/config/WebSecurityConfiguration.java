package com.epsi.guez.debugme.config;

import com.epsi.guez.debugme.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Cette classe permet de définir les règles de sécurité par Spring Security
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UtilisateurService utilisateurService;

    @Autowired
    public WebSecurityConfiguration(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    /**
     * Cette méthode permet de définir le type de gestion de l'authentification,
     * ici on a défini un service de gestion des utilisateurs en base de données plutôt que de définir les utilisateurs en mémoire
     *
     * @param builder : le système de management de l'authentification de Spring Security
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(utilisateurService);
    }

    /**
     * Cette méthode définit la gestion de la sécurité, elle permet de gérer quelles pages sont accessible et par qui,
     * ainsi que la page de connexion, la page par défaut une fois authentifié, la méthode de déconnexion, <i>etc.</i>
     *
     * @param http : la configuration de la sécurité HTTP de toutes les requêtes
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/css/*").permitAll()
                .antMatchers("/images/*").permitAll()
                .antMatchers("/files/*").permitAll()
                .antMatchers("/js/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(ApplicationUrl.CONNEXION)
                .defaultSuccessUrl(ApplicationUrl.MENU, true)
                .failureUrl(ApplicationUrl.CONNEXION + "?error=true")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl(ApplicationUrl.DECONNEXION)
                .logoutSuccessUrl(ApplicationUrl.CONNEXION);
    }

    /**
     * Fournit le type de chiffrement des mots de passe en base de données
     *
     * @return un {@link Bean} qui se chargera de la gestion du chiffrement des mots de passe pour l'authentification
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
