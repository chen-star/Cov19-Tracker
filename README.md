# Cov19 Tracker
---
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)

[![ForTheBadge built-with-love](http://ForTheBadge.com/images/badges/built-with-love.svg)](https://GitHub.com/Naereen/)


[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://GitHub.com/Naereen/ama)
[![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)](https://github.com/Naereen/badges/)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/dwyl/esta/issues)


> GitHub [@Alex Chen](https://github.com/chen-star) &nbsp;&middot;&nbsp;

---



## Demo

#### Tracker Dashboard
![](./src/main/resources/static/img/img1.png)
![](./src/main/resources/static/img/img2.png)

#### Monitor Metric Dashboard
![](./src/main/resources/static/img/img3.png)




## Impl

* **Backend**

	- Spring Boot + MVC as base web framework
	- RestTemplate as Rest Client

* **Frontend**

	- HTML + Thymeleaf as static template
	- Bootstrap + JS as render tool

* **Monitoring**

	- spring-acuator as metric agent inside service
	- Prometheus as data collector
	- Grafana as dashboard UI display