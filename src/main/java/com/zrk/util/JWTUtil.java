package com.zrk.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

public class JWTUtil{

    private static final String SECRET = "XX#$%()(#*!(sadsadsadqwe)!KL<><\\ED5944B6F54D2DF4967615C7D59AE70E>?N<:{LWPW";
    public static final String TOKEN_HEADER = "authentication";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final Long EXPIRES = 15*24*60*60L;
    private static final JWTVerifier build = JWT.require(ALGORITHM).build();
    private static final Date EXPIRESAT = new Date(122,1,28);

    public static String createToken(String identity, String username,Integer userId,Integer power,String ip){
        return JWT.create()
                .withClaim("identity",identity)
                .withClaim("username", username)
                .withClaim("userId", userId)
                .withClaim("power", power)
                .withClaim("ip",ip)
                .withExpiresAt(EXPIRESAT)
////                .withExpiresAt(new Date(System.currentTimeMillis()))
                .sign(ALGORITHM);
    }

    public static String VerifierToken(String token){
        return build.verify(token).getClaims().get("userId").asString();
    }

    public String createToken1(String username,String userId){
        return JWT.create()
                .withClaim("username", username)
                .withClaim("userId", userId)
                .withExpiresAt(EXPIRESAT)
//                .withExpiresAt(new Date(System.currentTimeMillis()))
                .sign(ALGORITHM);
    }

    public  String VerifierToken1(String token){
        return build.verify(token).getClaims().get("userId").asString();
    }

}

