__author__ = 'andrzej.piechocki'

import unittest
import time
import CommonFunctions
from selenium import webdriver

class WelcomePage(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # create a new browser session
        url = CommonFunctions.Functions.url
        cls.driver = webdriver.Firefox()
        cls.driver.maximize_window()
        # navigate to the application home page
        cls.driver.get(url)

    def test_welcomePage(self):
        driver = self.driver
        c = CommonFunctions.Functions(self.driver)
        c.login()
        self.assertEqual("IPO", driver.title)
        time.sleep(2)
        self.assertEqual("IPO", driver.find_element_by_css_selector("span.hidden-folded.m-l-xs").text)
        self.assertEqual("Login", driver.find_element_by_link_text("Login").text)
        self.assertEqual("Privacy, Terms and conditions",
                         driver.find_element_by_link_text("Privacy, Terms and conditions").text)
        self.assertEqual("Contact", driver.find_element_by_link_text("Contact").text)
        self.assertEqual("pm1@smt.com", driver.find_element_by_link_text("pm1@smt.com").text)
        driver.find_element_by_css_selector("span.hidden-sm.hidden-md").click()
        self.assertEqual("Login", driver.find_element_by_xpath("//aside[@id='aside']/div/div/nav/ul/li[2]/a/span").text)
        self.assertEqual("Logout", driver.find_element_by_link_text("Logout").text)
        driver.find_element_by_link_text("Privacy, Terms and conditions").click()
        self.assertIn("The Risk Management Office (RMO) team welcomes you", driver.find_element_by_xpath("//div").text)
        driver.find_element_by_link_text("Contact").click()
        self.assertIn("Deutsche Gesellschaft für Internationale Zusammenarbeit (GIZ) GmbH",
                      driver.find_element_by_xpath("//div").text)

    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()


if __name__ == "__main__":
    unittest.main(verbosity=2)