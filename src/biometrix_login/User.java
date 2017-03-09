/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometrix_login;

/**
 *
 * @author Saarrah_Isthikar
 */
public class User {

    private String username;
    private String lenLittle;
    private String lenRing;
    private String lenMiddle;
    private String lenFore;
    private String lenThumb;
    private String cirLittle;
    private String cirRing;
    private String cirMiddle;
    private String cirFore;
    private String cirThumb;
    private String password;

    public User(String username, String lenLittle, String lenRing, String lenMiddle, String lenFore, String lenThumb, String cirLittle, String cirRing, String cirMiddle, String cirFore, String cirThumb) {

        this.username = username;
        this.lenLittle = lenLittle;
        this.lenRing = lenRing;
        this.lenMiddle = lenMiddle;
        this.lenFore = lenFore;
        this.lenThumb = lenThumb;
        this.cirLittle = cirLittle;
        this.cirRing = cirRing;
        this.cirMiddle = cirMiddle;
        this.cirFore = cirFore;
        this.cirThumb = cirThumb;

    }

    public String getUsername() {
        return username;
    }

    public String getLenLittle() {
        return lenLittle;
    }

    public String getLenRing() {
        return lenRing;
    }

    public String getLenMiddle() {
        return lenMiddle;
    }

    public String getLenFore() {
        return lenFore;
    }

    public String getLenThumb() {
        return lenThumb;
    }

    public String getCirLittle() {
        return cirLittle;
    }

    public String getCirRing() {
        return cirRing;
    }

    public String getCirMiddle() {
        return cirMiddle;
    }

    public String getCirFore() {
        return cirFore;
    }

    public String getCirThumb() {
        return cirThumb;
    }

    public String getPassword() {
        String concatDetails = PasswordEncryption.encryptByte(this.lenLittle) + PasswordEncryption.encryptByte(this.lenRing)
                + PasswordEncryption.encryptByte(this.lenMiddle) + PasswordEncryption.encryptByte(this.lenFore)
                + PasswordEncryption.encryptByte(this.lenThumb) + PasswordEncryption.encryptByte(this.cirLittle)
                + PasswordEncryption.encryptByte(this.cirRing) + PasswordEncryption.encryptByte(this.cirMiddle)
                + PasswordEncryption.encryptByte(this.cirFore) + PasswordEncryption.encryptByte(this.cirMiddle);

        return PasswordEncryption.finalPassword(concatDetails);

    }

}
