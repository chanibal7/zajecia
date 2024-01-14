__author__ = 'andrzej.piechocki'

import unittest
from xmlrunner import xmlrunner
from Test_LoginPage import LoginPage
from Test_WelcomePageValidation import WelcomePage

# get all tests
login_tests = unittest.TestLoader().loadTestsFromTestCase(LoginPage)
welcome_tests = unittest.TestLoader().loadTestsFromTestCase(WelcomePage)

# create a test suite
smoke_tests = unittest.TestSuite([login_tests, welcome_tests])

# run the suite
xmlrunner.XMLTestRunner(verbosity=2, output='test-reports').run(smoke_tests)
