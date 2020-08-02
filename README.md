# buscaminas
Minesweeper created for the lesson of graphical user interfaces





Práctica Final. Juego tipo Buscaminas
1. Definición y Objetivos de la práctica
El objetivo de la práctica consiste en diseñar e implementar una aplicación gráfica
que permita jugar a un juego del tipo buscaminas, adaptado para niños de entre 10 y
12 años. Esto puede implicar que se busque otra metáfora en vez de la mina a la hora
de implementar el juego y que la información que aporte al usuario esté en
consonancia con sus características. Para el diseño de esta práctica se tendrán en
consideración todos los contenidos expuestos en la parte de teoría de la asignatura. En
cuanto a su implementación, se utilizará el API de Java que se necesite siguiendo el
patrón Modelo-Vista-Controlador. Las decisiones de como diseñar el interfaz en
general dependerán de cada equipo de trabajo. A continuación, se describe el modelo
de negocio de la empresa, así como los requerimientos a cumplir. Esta descripción
representa unos mínimos que deberán ser respetados en la construcción de la
herramienta. Cada equipo de trabajo podrá hacer las ampliaciones que considere
oportunas sobre los supuestos aquí descritos. En cuanto a los criterios de diseño del
interfaz, cada equipo de trabajo es libre de asumir los que considere necesarios
siempre y cuando supongan una mejora en la usabilidad de la herramienta.
2. Descripción del Juego Buscaminas.
Las reglas del juego son las siguientes:
· Hay un campo que contiene un número conocido de minas (o la metáfora
corrspondinte), aunque no se sabe con precisión en que posiciones están.
· Un jugador puede realizar tres acciones sobre las diferentes posiciones del campo
minado, a saber:
1. Puede destapar una posición y revelar su contenido. Si en la posición había una
mina, ésta se descubre y se le informa al jugador que ha perdido el juego. En
ese caso, el tablero debe mostrar todas las minas y las marcas equivocadas. Si
en la posición no había mina, se informa del número de minas que hay en las
casillas adyacentes a la casilla destapada. Cuando no hay ninguna mina
alrededor, la posición no muestra ningún número y además se destapan todas
aquellas posiciones que están seguidas a ella y que tampoco tienen ninguna
mina alrededor.
2. El jugador puede también marcar una posición que no haya sido destapada.
Aunque esto no tiene ningún efecto sobre el juego, sirve para que el jugador
recuerde que casillas contienen minas y no deben ser destapadas.3. Finalmente, el jugador puede también desmarcar una casilla que haya
marcado previamente.
· El juego termina cuando el jugador destapa una casilla que contiene una mina (como
ya se ha mencionado) o cuando ya ha destapado todas las casillas que no tienen minas.
En este último caso, el juego debe informar del tiempo total que fue necesario para
terminar el juego.
Además, el juego debe poder permitir al usuario definir el grado de dificultad (definido
por el número de casillas y de bombas) y poder comenzar un nuevo juego en cualquier
momento.
3. Implementación de la Práctica
Primera parte
La primera parte de la práctica consiste en las fases de análisis y diseño del
interfaz. Durante la fase de análisis se identificará y describirá al usuario final, los
objetos que manipula y las tareas actuales y futuras asociadas a la aplicación en papel
y al que desarrollará con la aplicación respectivamente. Además, se recogerán todos
los requisitos que deba cumplir la interfaz (especificaciones de usabilidad).
Durante la fase de diseño se definirá su modelo conceptual, a partir del análisis
previo, y su especificación más detallada a través de un prototipo de papel (diseño de
alto nivel). En este sentido se tendrán en cuenta los objetivos de usabilidad,
accesibilidad e internacionalización, así como los requisitos funcionales y no
funcionales propios de la aplicación definidos en la fase de análisis. De este prototipo
se deberá extraer una representación detallada de las ventanas principales. Por último,
se pide un diagrama de clases que sustente el patrón Modelo-Vista-Controlador para el
problema que se plantea en esta práctica.
Segunda parte
Se elaborará un cuestionario para la posterior evaluación del interfaz mediante
un conjunto de heurísticos. Este cuestionario deberá ser lo más exhaustivo posible a la
hora de considerar todos los aspectos relativos a su usabilidad.
Tercera parte
A partir del diseño previo de la primera parte se realizará la implementación
software de la aplicación empleando para ello el API de Java.
4. Documentación a presentar:
Toda la documentación que se genere se deberá recoger en una memoria que
tendrá la siguiente estructura:•
•
•
•
Introducción donde se habla de la aplicación a desarrollar y de los aspectos a
considerar desde la perspectiva del diseño de su interfaz gráfica: Otras
herramientas similares que se encuentre en el mercado, tipo de usuario a quien
va destinado, etc .
Análisis de los requisitos: identificación del usuario final, de las tareas que
desarrolla y desarrollará en la aplicación final. En este apartado también se
incluirá un análisis de las tareas a desarrollar por los usuarios cuando
interaccionan con el interfaz mediante el método GOMS y se recopilarán todos
aquellos requisitos que hagan referencia al interfaz desde la perspectiva
funcional (Casos de uso). Por último, se deberá especificar todas las
consideraciones de accesibilidad e internacionalización que se hayan adoptado.
Diseño del interfaz donde se especificará el modelo conceptual del diseño
(tabla Objetos-Atributos-Acciones, tabla Objetos-Metáforas-Representaciones,
etc.) y su prototipo en papel, de tal forma que permita extraer una
representación más detallada de las ventanas principales del interfaz gráfico
(tabla de acciones y bosquejo de las ventanas principales).
Evaluación del interfaz. En este apartado se detallan todas las tareas llevadas
a cabo para una adecuada evaluación heurística del interfaz. Se definirán los
pasos dados y se incluirá el cuestionario elaborado.
