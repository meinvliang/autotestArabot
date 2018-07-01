#-*-coding:utf8-*-
import time
from selenium import webdriver

#运行chrome，打开浏览器
driver=webdriver.Chrome(r'C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe')
#设置浏览器窗口
driver.set_window_size(1380,1200)

#设置全局操作时间
driver.implicitly_wait(20)

#打开网址
driver.get('https://www.hiyd.com/')
#睡五秒点击登录按钮
time.sleep(5)
driver.find_element_by_xpath("//*[@id='btn_ouj_login']").click()
#填写用户名密码进行登录
driver.find_element_by_xpath("//*[@id='ologin-mobile']").send_keys("18811021064")
time.sleep(2)
driver.find_element_by_xpath("//*[@id='ologin-pwd']").send_keys("123456")
time.sleep(5)
driver.find_element_by_xpath("//*[@id='btn_login_submit']").click()

print("continue")
time.sleep(15)


