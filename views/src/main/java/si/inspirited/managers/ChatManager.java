package si.inspirited.managers;


import si.inspirited.ejb.ExampleEJB;
import si.inspirited.ejb.UserEntity;
import si.inspirited.engine.Engine;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


/**  * Created by Lord Merciful God
 */


@Named
@SessionScoped
public class ChatManager implements Serializable {

    @EJB
    private Engine engine;

    //private String login;
    //private String password;

    private String data;
    private String user;
    private boolean messageSent;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isMessageSent() {
        return messageSent;
    }

    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }



    public String generateNewUser() {
        return engine.generateNewUser();}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull(message="this message overridden that is declared in jsf ")
    private String login;

    @NotNull(message="please, fill this field properly")
    private String password;

    // private ArrayList<Item> bucket;

    private String ustaRanking;

    @NotNull(message = "Please select Sex Type, (M) for Male or (F) for Female")
    private String sex;

    private boolean loginSuccess;
    private boolean createSuccess;

    private boolean goodAdded;

    private String name;
    private String price;



    @EJB
    private ExampleEJB exampleEJB;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean isCreateSuccess() {
        return createSuccess;
    }

    public void setCreateSuccess(boolean createSuccess) {
        this.createSuccess = createSuccess;
    }

    public boolean isGoodAdded() {
        return goodAdded;
    }

    public void setGoodAdded(boolean goodAdded) {
        this.goodAdded = goodAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void checkPassword(){
        loginSuccess = exampleEJB.checkPassword(login, password);
    }

    public void createUser(){
        createSuccess = exampleEJB.createUser(login, password);
    }

    // public void createGood() {goodAdded = exampleEJB.addGood(name, price);}


    public List<UserEntity> getAllUsers(){
        return exampleEJB.getAllUsers();
    }

    // public List<Item> getGoods(){
    //    return exampleEJB.getGoods();
    //}

    /*public List<Item> getItemsToSell(){
        return exampleEJB.getItemsToSell();
    }*/

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUstaRanking() {
        return ustaRanking;
    }

    public void setUstaRanking(String ustaRanking) {
        this.ustaRanking = ustaRanking;
    }

    /*public ArrayList<Item> getBucket() {
        return bucket;
    }

    public void setBucket(ArrayList<Item> bucket) {
        this.bucket = bucket;
    }*/
/*
    public ItemsList getItemsList() {
        return itemsList;
    }
    public void setItemsList(ItemsList itemsList) {
        this.itemsList = itemsList;
    }
    public List<Item> getGoods() {
        return itemsList.getItemsToSell();
    }
    public void setGoods(List itemsList) {
        this.itemsList.setItemsToSell(itemsList);
    }
*/

}