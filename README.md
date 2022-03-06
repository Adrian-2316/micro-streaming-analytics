<div id="top"></div>
<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)

<br />
<div align="center">

<h3 align="center">Micro streaming analytics</h3>

  <p align="center">
    Services IOT simulation & data async recollection 
    <br /><br>
    <a href="https://heroku-analytics.herokuapp.com/swagger-ui/index.html#/"><strong>Explore analytics API: »</strong></a>
    <br>
<a href="https://heroku-device.herokuapp.com/swagger-ui/index.html#/"><strong>Explore device API: »</strong></a>
    <br />
    <br />
    <!--<a href="">Active analytics frontend</a>
    ·-->
    <a href="https://github.com/Adrian-2316/micro-streaming-analytics/labels/bug">Report Bug</a>
    ·
    <a href="https://github.com/Adrian-2316/micro-streaming-analytics/labels/enhancement">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

Micro streaming analytics aims to simulate IoT interaction with a message broker which send data to another service,
then its stored in a mongo database.

It is mainly based on Java with Spring Boot.
<br><br>Services:

- **Analytics**: Received data from RabbitMQ is transformed into analytics data which is stored into MongoDB.
- **Device**: It provides the message broker with simulated data using scheduled processes.

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

- [Java](https://www.java.com/es/)
- [Spring boot](https://spring.io/projects/spring-boot)
- [Docker](https://www.django-rest-framework.org/)
- [Swagger](https://swagger.io/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [MongoDB](https://www.mongodb.com/)
- [Heroku](http://www.heroku.com/)

<p align="right">(<a href="#top">back to top</a>)</p>
<!-- GETTING STARTED -->

## Getting Started

### Prerequisites

* Java 11
* Spring Boot
* Maven
* Docker

### Installation

To get a local copy up and running (inside docker folder):

  ```sh
  docker-compose up --build
  ```

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ROADMAP -->

## Roadmap

- [x] Define backend project structure
- [x] Define services & entities
- [x] Services & entities creation
- [x] Spring configuration
- [x] RabbitMQ configuration
- [x] MongoDB configuration
- [x] JPA design patterns
- [x] Analytics generation from collected data
- [x] Auditable fields added
- [x] Swagger implemented
- [x] RabbitMQ message exchange
- [x] Scheduled tasks to send simulated data
- [x] Docker-compose.yml file created
- [x] Logging structure generated
- [x] Environment file added
- [x] Services deployed on Heroku

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also
simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

## Contact

LinkedIn:

- [Adrián Moral](https://es.linkedin.com/in/adri%C3%A1n-moral-bail%C3%B3n-b51107210)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/Adrian-2316/Snippet-Management.svg?style=for-the-badge

[contributors-url]: https://github.com/Adrian-2316/Snippet-Management/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/Adrian-2316/Snippet-Management.svg?style=for-the-badge

[forks-url]: https://github.com/Adrian-2316/Snippet-Management/network/members

[stars-shield]: https://img.shields.io/github/stars/Adrian-2316/Snippet-Management.svg?style=for-the-badge

[stars-url]: https://github.com/Adrian-2316/Snippet-Management/stargazers

[issues-shield]: https://img.shields.io/github/issues/Adrian-2316/Snippet-Management.svg?style=for-the-badge

[issues-url]: https://github.com/Adrian-2316/Snippet-Management/issues

[license-shield]: https://img.shields.io/github/license/Adrian-2316/Snippet-Management.svg?style=for-the-badge

[license-url]: https://github.com/Adrian-2316/Snippet-Management/blob/master/LICENSE.txt

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
