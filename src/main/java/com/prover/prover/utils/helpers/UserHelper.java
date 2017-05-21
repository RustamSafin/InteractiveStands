package com.prover.prover.utils.helpers;

import com.prover.prover.models.User;
import com.prover.prover.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Admin on 21.05.2017.
 */
public class UserHelper {

    public static User currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails= (CustomUserDetails) auth.getPrincipal();
        return customUserDetails.getUser();
    }
}
