# Sale It

![](https://github.com/ARSW-Team-2020-2/SaleIt/blob/master/img/logo.png)

## Integrantes

*   Juan Sebastián Frásica Galeano
*   Daniela Ruiz
*   Juan Sebastián Díaz




## Descripción de la aplicación
SaleIt es una aplicación web realizada como proyecto para la materia **Arquitecturas de Software (ARSW)** de la Escuela Colombiana de Ingeniería Julio Garavito.
Es una aplicación para realizar subastas. Allí el usuario podrá ofertar artículos y pujar para conseguirlos. 


## Valores agregados y diferenciadores de la aplicación 
La usabilidad y los temas relacionados con la Experiencia de Usuario (UX) son un factor diferenciador de SaleIt con respecto a la mayoría de páginas de subastas.

## Despliegue en Heroku
 
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)]()
 
 ## Calidad del código
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5430bb4ffa9947c9b7a02fa442496563)](https://www.codacy.com/gh/ARSW-Team-2020-2/SaleIt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ARSW-Team-2020-2/SaleIt&amp;utm_campaign=Badge_Grade)
 
 ## Integración continua
 
 [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/ARSW-Team-2020-2/SaleIt)
 

 

 



# Arquitectura y diseño detallado de la aplicación

## Diagrama de casos de uso



## Historias de usuario

### 1.	COMO Usuario QUIERO Iniciar Sesión PARA PODER autenticarme ante el sistema satisfactoriamente.

 **Criterios de aceptación:**

*   Se debe poder cerrar sesión.
*	Se debe usar una fuente de datos básica para autenticar al usuario.


### 2.	COMO Usuario QUIERO Registrarme PARA PODER realizar las diferentes labores que me permita el sistema dependiendo del rol con el que esté registrado.

 **Criterios de aceptación:**

*   Se deben añadir los nuevos usuarios a la fuente de datos básica.
*   Es necesario que cada usuario tenga un nombre de usuario y correo únicos.
*   Al finalizar el registro, el usuario deberá elegir 3 categorías para que luego se muestren productos relacionados a éstas.



### 3.	COMO Usuario QUIERO Registrar un artículo PARA PODER venderlo al mejor postor.
Un artículo es todo aquel elemento que es ofrecido por un usuario a los demás usuarios de SaleIt.

 **Criterios de aceptación:**

* La información básica de un artículo es: 
    * Identificador interno
    * Nombre del artículo
    * Detalles del artículo (Marca, peso, modelo, material)
    * Precio mínimo
    * Estado de uso (nuevo o usado)
    * Dimensiones
    * Fotografía real del artículo
    * Ubicación del producto
    * Fecha de vencimiento de la subasta
*   El usuario vendedor debe proporcionar como mínimo el **nombre**, **fecha de vencimiento**, **precio mínimo** y **ubicación** para poder registrarlo.
*   Una vez el artículo es registrado debe aparecer disponible para ser pujado por los demás usuarios de SaleIt.
*   No pueden existir dos identificadores internos iguales para los artículos.

### 4.	COMO Usuario QUIERO Cambiar el estado de un artículo PARA PODER evitar que los usuarios puedan pujar de manera temporal o definitiva.

Cuando algún artículo ofrecido presenta algún problema o un daño irreparable este debe poder ser dado de baja para que los usuarios no puedan hacer uso de este y no se pueda pujar.

Si el problema de este recurso es reparable, se puede cambiar su estado nuevamente para que este disponible nuevamente.

  **Criterios de aceptación:**  
  * Al darse de baja un artículo, este no debe estar disponible para ser pujado.
  * Si un artículo es habilitado nuevamente, debe ser posible realizar pujas a este nuevamente.
 



### 5. COMO Usuario QUIERO Consultar los artículos disponibles PARA PODER ofertar alguno.
Los usuarios del sistema necesitan poder visualizar de una forma sencilla y agradable los artículos disponibles para realizar una subasta.

 **Criterios de aceptación:**
* Al momento de realizar la consulta, de deben mostrar todos lo artículos que se encuentran activos.
* Deben existir filtros que me permitan realizar una búsqueda mejor direccionada. Por categoría, precio y ubicación.
* El usuario podrá ver las ofertas que se cierran pronto (En las próximas 24 horas).


### 6. COMO Usuario QUIERO Consultar las categorías PARA PODER conocer cuales existen.
* Se debe mostrar todas las diferentes categorías para los productos existentes.
* Se debe mostrar las categorías más populares.
* Se debe mostrar las categorías "Para ti" (las preferidas del usuario).

### 7. COMO Usuario QUIERO Consultar una categoría PARA PODER ver los artículos correspondientes a ésta
* Se debe mostrar una lista de artículos disponibles correspondiente a la categoría seleccionada.

### 8. COMO Usuario QUIERO Ver un artículo en específico PARA PODER ofertar alguno
Al seleccionar un artículo se debe poder ver más información de este.

 **Criterios de aceptación:**

* Se debe mostrar:
    * Nombre del artículo
    * Imagen del artículo
    * Tiempo restante 
    * Puja con mayor valor
    * Siguiente puja mínima
    * Ubicación del artículo
    * Una tabla con todas las pujas realizadas, indicando el id del pujador, la fecha de la puja, y el valor pujado.


### 9. COMO Usuario QUIERO Realizar una puja PARA PODER ofertar por un artículo
Una vez un usuario decide el artículo que desea obtener, puede proceder a hacer su puja respectiva.
 **Criterios de aceptación:**
 * El valor a pujar debe ser mayor que la puja mínima
 * Si el usuario puja por un valor menor al mayor valor pujado, se le mostrará la sugerencia de que debería pujar más.
 
 ### 10. COMO Usuario QUIERO Consultar una puja PARA PODER obtener mayor información de la puja realizada.
Los usuarios del sistema necesitan poder visualizar de una forma sencilla y agradable la información de una puja realizada.
  **Criterios de aceptación:**
  * Al momento de seleccionar una puja, se debe visualizar mayor información sobre la misma.
    * Artículo pujado
    * Estado del artículo (vendido o en oferta)
    * Fecha de la oferta

### 11. COMO Usuario QUIERO Buscar un artículo PARA PODER encontrar un artículo deseado.

 **Criterios de aceptación:**

* Se podrá buscar un artículo por su nombre en una barra de búsqueda.
* La búsqueda del artículo se hará en todas las categorías.


### 12. COMO Usuario QUIERO Marcar como favorito PARA PODER añadir un artículo a mis favoritos

 **Criterios de aceptación:**

* Al momento de consultar o buscar un artículo debe existir la opción para marcar como favorito.


### 13. COMO Comprador QUIERO Ver mi lista de favoritos PARA PODER consultar qué artículos me han gustado.

 **Criterios de aceptación:**

* Se debe mostrar con claridad una lista de artículos marcados como favoritos.


## Mockups

* Página de inicio (principal)

![Principal](img/MockUp_1.png)

* Página visualizando algún objeto

![Principal](img/MockUp_2.png)

* Página de resultados de una búsqueda

![Principal](img/MockUp_3.png)








## Diagrama de clases

## Diagrama E-R


## Diagrama de componentes











 
