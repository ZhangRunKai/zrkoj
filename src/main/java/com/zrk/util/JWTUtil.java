package com.zrk.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zrk.entity.Role;
import com.zrk.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil{
    public static ThreadLocal<HashMap<String,Integer>> userManager = new ThreadLocal<>();
    private static final String SECRET = "XX#$%()(#*!(sadsadsadqwe)!KL<><\\ED5944B6F54D2DF4967615C7D59AE70E>?N<:{LWPW";
    public static final String TOKEN_HEADER = "authentication";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final Long EXPIRES = 15*24*60*60L;
    private static final JWTVerifier build = JWT.require(ALGORITHM).build();

    public static final String USERID = "userId";
    public static final String ROLEPOWER = "rolePower";
    public static final String ROLENAME = "roleDescribe";
    public static final String USERNAME = "userName";

    /**
     *
     * @param user 用户信息
     * @return
     */
    public static String createToken(User user){
        return JWT.create()
                .withClaim(USERNAME, user.getUserName())
                .withClaim(USERID, user.getUserId())
                .withClaim(ROLEPOWER,user.getRolePower())
                .withClaim(ROLENAME,user.getRoleDescribe())
                .withExpiresAt(new Date(System.currentTimeMillis()+ EXPIRES))
                .sign(ALGORITHM);
    }


    public static HashMap<String,Integer> VerifierToken(String token){
        Map<String, Claim> claims = build.verify(token).getClaims();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("userId",claims.get(USERID).asInt());
        hashMap.put("rolePower",claims.get(ROLEPOWER).asInt());
        return hashMap;
    }


}

