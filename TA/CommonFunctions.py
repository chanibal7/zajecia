__author__ = 'andrzej.piechocki'

import unittest
from selenium import webdriver

class Functions(object):
    url = "http://10.190.72.10:8084/ipo/"
    #browser = webdriver.Chrome()
    #browser = webdriver.Firefox()
    #browser = webdriver.Ie()
    user="pm1@smt.com"
    password="qwe"

    def __init__(self, driver):
        self.driver = driver

    def login(self):
        driver = self.driver
        user = self.user
        password = self.password
        user_field = driver.find_element_by_id("username")
        user_field.clear()
        user_field.send_keys(user)
        password_field = driver.find_element_by_id("password")
        password_field.clear()
        password_field.send_keys(password)
        driver.find_element_by_xpath("//button[@type='submit']").click()

if __name__ == "__main__":
    unittest.main()