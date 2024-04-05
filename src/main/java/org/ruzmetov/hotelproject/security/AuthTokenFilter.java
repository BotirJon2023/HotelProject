package org.ruzmetov.hotelproject.security;

//import io.jsonwebtoken.Header;
//import io.micrometer.common.lang.NonNull;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//
public class AuthTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
//
//    private final JwtUtils jwtUtils;
//    private final UserDetailsServiceImpl userDetailsService;
//    private static final String BEARER = "Authorization=Bearer";
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) {
//        String jwt = parseJwt(request);
//        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
//            String username = jwtUtils.getBody(jwt).getSubject(); //get username
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//            UsernamePasswordAuthenticationToken authenticationToken
//                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//            try {
//                filterChain.doFilter(request, response);
//            } catch (IOException | ServletException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private String parseJwt(HttpServletRequest request) {
//        String header = request.getHeader("cookie");
//        System.out.println(header);
//        if (header.startsWith(BEARER)) {
//            int index = header.contains(";") ? header.indexOf(";") : header.length();
//            return header.substring(BEARER.length(), index);
//        }
//        return null;
//    }
}