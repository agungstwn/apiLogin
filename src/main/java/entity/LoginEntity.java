package entity;

public class LoginEntity extends BaseEntity {
    private String unique_id;
    private String nama;
    private String email;
    private String encrypted_password;
    private String salt;

    public LoginEntity(){

    }

    public LoginEntity(String unique_id, String nama, String email, String encrypted_password, String salt) {
        this.unique_id = unique_id;
        this.nama = nama;
        this.email = email;
        this.encrypted_password = encrypted_password;
        this.salt = salt;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
