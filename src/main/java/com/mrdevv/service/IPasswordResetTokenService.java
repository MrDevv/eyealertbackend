package com.mrdevv.service;

import com.mrdevv.model.PasswordResetToken;

public interface IPasswordResetTokenService {

    public void guardarToken(PasswordResetToken passwordResetToken);

}
