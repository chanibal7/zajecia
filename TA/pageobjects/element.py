__author__ = 'andrzej.piechocki'

from selenium import webdriver

class BasePageElement(object):
    def setUp(self, url = "http://10.190.72.10:8081/ipo/" ):
        self.driver = webdriver.Firefox()
        self.driver.get(url)
        page = self.driver