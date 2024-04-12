from flask_apscheduler import APScheduler
from recommedation_web_crawler.main import web_crawler_main


scheduler = APScheduler()


# 'cron', id='scheduled_task', hour=0


@scheduler.task('interval',id='do_advertise',minutes=1)
def jobs_web_crawler():
  web_crawler_main()
