# Mandelbrot Set Visualiser

This application plots the Mandelbrot set using an escape-time algorithm. Points in the complex plane belonging to the Mandelbrot set are coloured in black while points that do not belong to the Mandelbrot set are coloured using a scheme based on how quickly the point diverges to infinity under repeated iteration of the quadratic map.

## Installation

This project was built using Java 17 and managed using Maven 3.9.5. To build from source, clone the repository to a local working directory and run

```sh
mvn clean package
```

Then run the newly built `.jar` file using
```sh
java -jar target/mandelbrot-1.0.jar
```

## Contact

For any queries regarding the application, please contact Thomas Kong (txdk2009@gmail.com).