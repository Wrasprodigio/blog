//package com.spring.blog.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    //Filtros (filters)
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(
//                        authorizedConfig -> {
//                            authorizedConfig.requestMatchers("/", "posts", "/api/posts/{id}").permitAll();
//                            authorizedConfig.requestMatchers("/posts").permitAll();
//                            authorizedConfig.requestMatchers("/api/posts/{id}").permitAll();
//                            authorizedConfig.requestMatchers("buscarPorNome").permitAll();
//                            authorizedConfig.anyRequest().authenticated();
//                        })
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("willyam")
//                .password("159")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/bootstrap/**");
//    }
//}
