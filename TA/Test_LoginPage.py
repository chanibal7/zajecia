__author__ = 'andrzej.piechocki'

import unittest
import time
import CommonFunctions
from selenium import webdriver

class LoginPage(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # create a new browser session
        url = CommonFunctions.Functions.url
        cls.driver = webdriver.Firefox()
        cls.driver.maximize_window()
        # navigate to the application home page
        cls.driver.get(url)

    def test_login_gui_validation(self):
        driver = self.driver
        self.assertEqual("IPO", driver.title)
        self.assertEqual("IPO Afghanistan", driver.find_element_by_link_text("IPO Afghanistan").text)
        self.assertEqual("", driver.find_element_by_id("username").text)
        self.assertEqual("", driver.find_element_by_id("password").text)
        self.assertEqual("Log in", driver.find_element_by_xpath("//button[@type='submit']").text)

    def test_logIntoApp_negative(self):
        driver = self.driver
        c = CommonFunctions.Functions(self.driver)
        user = c.user
        password = c.password

        #Empty email and password
        driver.find_element_by_xpath("//button[@type='submit']").click()
        self.assertEqual("Log in", driver.find_element_by_xpath("//button[@type='submit']").text)

        #Empty password
        driver.find_element_by_id("username").clear()
        driver.find_element_by_id("username").send_keys(user)
        driver.find_element_by_id("password").clear()
        driver.find_element_by_id("password").send_keys("")
        driver.find_element_by_xpath("//button[@type='submit']").click()
        self.assertEqual("Log in", driver.find_element_by_xpath("//button[@type='submit']").text)

        #Empty email
        driver.find_element_by_id("username").clear()
        driver.find_element_by_id("username").send_keys("")
        driver.find_element_by_id("password").clear()
        driver.find_element_by_id("password").send_keys(password)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        self.assertEqual("Log in", driver.find_element_by_xpath("//button[@type='submit']").text)

        #Wrong email
        driver.find_element_by_id("username").clear()
        driver.find_element_by_id("username").send_keys(user + "XX")
        driver.find_element_by_id("password").clear()
        driver.find_element_by_id("password").send_keys(password)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(1)
        self.assertEqual("Invalid username or password", driver.find_element_by_xpath("//form/div").text)

        #Wrong password
        driver.find_element_by_id("username").clear()
        driver.find_element_by_id("username").send_keys(user)
        driver.find_element_by_id("password").clear()
        driver.find_element_by_id("password").send_keys(password + "XX")
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(1)
        self.assertEqual("Invalid username or password", driver.find_element_by_xpath("//form/div").text)

    def test_logIntoApp(self):
        driver = self.driver
        c = CommonFunctions.Functions(self.driver)
        user = c.user
        password = c.password
        #Empty email and password
        driver.find_element_by_id("username").clear()
        driver.find_element_by_id("username").send_keys(user)
        driver.find_element_by_id("password").clear()
        driver.find_element_by_id("password").send_keys(password)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(1)
        self.assertEqual("Welcome to IPO Afghanistan", driver.find_element_by_xpath("//div[@id='content']/div/div/div/div/div/div/h1").text)
        #Logout
        driver.find_element_by_css_selector("span.hidden-sm.hidden-md").click()
        time.sleep(1)
        driver.find_element_by_link_text("Logout").click()
        time.sleep(1)
        self.assertEqual("You have been logged out", driver.find_element_by_xpath("//form/div").text)

    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()

if __name__ == "__main__":
    unittest.main(verbosity=2)