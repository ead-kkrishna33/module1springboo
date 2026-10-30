package com.coding.module1introduction.filters;

import com.coding.module1introduction.entities.UserEntity;
import com.coding.module1introduction.services.JWTService;
import com.coding.module1introduction.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@RequiredArgsConstructor
@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    JWTService jwtService;
    UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            final String requestTokenHeader= request.getHeader("Authorization");
            if(requestTokenHeader==null || !requestTokenHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;

            }
            // step 1 fetch the token from header
        final  String token = requestTokenHeader.split("Bearer ")[1];
            //step 2 get the userId from  token by calling getUserIdFromToken() from Jwtserice
        Long userId = jwtService.getUserIdFromToken(token);
        // step 3 validate the user with database user is the user present or  not in db

        if(userId==null && SecurityContextHolder.getContext().getAuthentication()==null) {
           UserEntity user= userService.findById(userId);
           // step 4 put this user to spring sceurity context holder
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null,null);
            // it provide extra details about user like ip adress
            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        //step 4 pass on to filterChain.dofilter call for next method in filter chain
        filterChain.doFilter(request,response);
    }
}
