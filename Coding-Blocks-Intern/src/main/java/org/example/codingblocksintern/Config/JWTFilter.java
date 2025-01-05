//package org.example.codingblocksintern.Config;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.codingblocksintern.Service.JWTService;
//import org.example.codingblocksintern.Service.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JWTFilter extends OncePerRequestFilter {
//    private final JWTService jwtService;
//    private final ApplicationContext context;
//
//    public JWTFilter(JWTService jwtService, ApplicationContext context) {
//        this.jwtService = jwtService;
//        this.context = context;
//    }
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String path = request.getRequestURI();
////        System.out.println(path);
//        if (path.equals("/register") || path.equals("/login")) {
//            System.out.println("CALLED");
//            filterChain.doFilter(request, response);
//            return;
//        }
//        String authHeader = request.getHeader("Authorization");
//        String token = null;
//        String userName = null;
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            token = authHeader.substring(7);
//            userName = jwtService.extractUserName(token);
//        }
//
//        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
//            System.out.println(userDetails.getUsername());
//            if (jwtService.validateToken(token, userDetails)) {
////                System.out.println("VALID");
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
