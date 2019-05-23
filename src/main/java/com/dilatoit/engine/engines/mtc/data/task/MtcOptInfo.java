package com.dilatoit.engine.engines.mtc.data.task;

public class MtcOptInfo {
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    public MtcOptInfo(){
        login = new Login();
    }
    public class Login{
        public Login(){

        }
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}