# Sale It

## Integrantes

*   Juan Sebastián Frásica
*   Daniela Ruiz
*   Juan Sebastián Díaz

## Resumen
SaleIt es una aplicación web realizada como proyecto para la materia **Arquitecturas de Software (ARSW)** de la Escuela Colombiana de Ingeniería Julio Garavito.



 
 ## Calidad del código
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5430bb4ffa9947c9b7a02fa442496563)](https://www.codacy.com/gh/ARSW-Team-2020-2/EciGym?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ARSW-Team-2020-2/EciGym&amp;utm_campaign=Badge_Grade)
 
 ## Integración continua
 
 [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/ARSW-Team-2020-2/SaleIt)
 
 ## Despliegue en Heroku
 
 [![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)]()
 

 
## Descripción de la aplicación



## Valores agregados y diferenciadores de la aplicación 


# Arquitectura y diseño detallado de la aplicación

## Diagrama de casos de uso



## Historias de usuario

### 1.	

COMO Usuario QUIERO Iniciar Sesión PARA PODER autenticarme ante el sistema satisfactoriamente.

 **Criterios de aceptación:**

*   Se debe poder cerrar sesión.
*	Se debe usar una fuente de datos básica para autenticar al usuario.


### 2.	

COMO Usuario QUIERO Registrarme PARA PODER realizar las diferentes labores que me permita el sistema dependiendo del rol con el que esté registrado.

 **Criterios de aceptación:**

*   Se deben añadir los nuevos usuarios a la fuente de datos básica.
*   Es necesario que cada usuario tenga un nombre de usuario y correo únicos.
*   Al finalizar el registro, el usuario deberá elegir 3 categorías para que luego se muestren productos relacionados a éstas.



### 3.	

COMO Usuario QUIERO Publicar un artículo PARA PODER venderlo al mejor postor.

 **Criterios de aceptación:**

* El vendedor debe proporcionar como mínimo los siguientes datos: 
    * Nombre del artículo
    * Detalles del artículo (Marca, peso, modelo, material)
    * Precio mínimo
    * Estado de uso (nuevo o usado)
    * Dimensiones
    * Fotografía real del artículo
    * Ubicación del producto




### 4.	

COMO Usuario QUIERO consultar los artículos disponibles PARA PODER ofertar alguno.

 **Criterios de aceptación:**

* Se debe mostrar las categorías más populares.
* Se debe mostrar las categorías preferidas del usuario.
* Se debe mostrar todas las diferentes categorías para los productos existentes.
* El usuario podrá ver las ofertas que se cierran pronto (En las próximas 24 horas).
* El usuario podrá seleccionar una categoría que sea de su interés para consultar productos relacionados a ésta.


### 5.	

COMO Usuario QUIERO consultar un artículo en específico PARA PODER ofertar alguno.

 **Criterios de aceptación:**

* Se debe mostrar:
    * Nombre del artículo
    * Imagen del artículo
    * Tiempo restante 
    * Puja con mayor valor
    * Siguiente puja mínima
    * Ubicación del artículo
    * Una tabla con todas las pujas realizadas, indicando el id del pujador, la fecha y hora de la puja, y el valor pujado.


### 6.	

COMO Comprador QUIERO buscar PARA PODER encontrar un artículo en específico.

 **Criterios de aceptación:**

* Se podrá buscar un artículo por su nombre
* La búsqueda del artículo se hará en todas las categorías.


### 7.	

COMO Comprador QUIERO marcar un producto PARA PODER añadirlo a mis favoritos

 **Criterios de aceptación:**

* Al momento de consultar o buscar un artículo debe existir la opción para marcar como favorito.


### 8.	

COMO Comprador QUIERO Ver mi lista de favoritos PARA PODER consultar qué productos me han gustado.

 **Criterios de aceptación:**

* Se debe mostrar con claridad una lista de artículos marcados como favorito.





## Mockups

### Página de inicio



### App



## Diagrama de componentes



## Diagrama de clases



## Diagrama de despliegue 




# Requerimientos no funcionales






 
