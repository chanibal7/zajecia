__author__ = 'andrzej.piechocki'

from page_objects import PageObject, PageElement

class LoginPage(PageObject):
        username = PageElement(name='username')
        password = PageElement(name='password')
        submit = PageElement(xpath="//button[@type='submit']")
