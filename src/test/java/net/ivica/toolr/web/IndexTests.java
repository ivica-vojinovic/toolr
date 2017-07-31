package net.ivica.toolr.web;

import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Assert;
import org.junit.Test;

public class IndexTests extends AbstractHtmlTests {

    @Test
    public void loginTest() throws Exception {
        HtmlPage indexPage = getWebClient().getPage("http://localhost:8080/index.html");

        HtmlAnchor loginModalLink = indexPage.getAnchorByName("login-modal-link");
        indexPage = loginModalLink.click();

        HtmlForm loginForm = indexPage.getHtmlElementById("login-form");
        waitForDisplayed(loginForm);

        HtmlInput usernameInput = loginForm.getInputByName("username");
        Assert.assertTrue(usernameInput.isDisplayed());
        usernameInput.setValueAttribute("ivica@gmail.com");

        HtmlInput passwordInput = loginForm.getInputByName("password");
        Assert.assertTrue(passwordInput.isDisplayed());
        passwordInput.setValueAttribute("password");

        HtmlButton loginButton = loginForm.getButtonByName("login-button");
        Assert.assertTrue(loginButton.isDisplayed());
        HtmlPage resultPage = loginButton.click();

        waitForBackgroundJavaScript();

        HtmlElement authUserNameElement = resultPage.getHtmlElementById("auth-username");
        Assert.assertEquals("Hi, Ivica", authUserNameElement.getTextContent());
    }

    @Test
    public void failedLoginTest() throws Exception {
        HtmlPage indexPage = getWebClient().getPage("http://localhost:8080/index.html");

        HtmlAnchor loginModalLink = indexPage.getAnchorByName("login-modal-link");
        indexPage = loginModalLink.click();

        HtmlForm loginForm = indexPage.getHtmlElementById("login-form");
        waitForDisplayed(loginForm);

        HtmlInput usernameInput = loginForm.getInputByName("username");
        Assert.assertTrue(usernameInput.isDisplayed());
        usernameInput.setTextContent("ivica@gmail.com");

        HtmlInput passwordInput = loginForm.getInputByName("password");
        Assert.assertTrue(passwordInput.isDisplayed());
        passwordInput.setTextContent("password");

        HtmlButton loginButton = loginForm.getButtonByName("login-button");
        Assert.assertTrue(loginButton.isDisplayed());
        HtmlPage resultPage = loginButton.click();

        waitForBackgroundJavaScript();

        HtmlElement divErrorElement = resultPage.getHtmlElementById("login-error");
        Assert.assertEquals("Bad credentials", divErrorElement.getTextContent());
    }

}
