/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Layer;

import javax.swing.JOptionPane;

/**
 *
 * @author thusha
 */
public class pw_Reset {
    
    
    private String Username;
    private String NewPassword;
    private String conpass;
    
    
    public void userRest(pw_Reset update){
        
       String qu="UPDATE login SET ChangePassword='"+(update.getNewPassword())+"',confirmpassword='"+(update.getConpass())+"' where UserName='"+(update.getUsername())+"'";
       DB_Login db=DB_Login.getInstance();
       db.updateRecord(qu);
       JOptionPane.showMessageDialog(null, "Successfully Saved in Database..");

    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the NewPassword
     */
    public String getNewPassword() {
        return NewPassword;
    }

    /**
     * @param NewPassword the NewPassword to set
     */
    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    /**
     * @return the conpass
     */
    public String getConpass() {
        return conpass;
    }

    /**
     * @param conpass the conpass to set
     */
    public void setConpass(String conpass) {
        this.conpass = conpass;
    }
    
}
