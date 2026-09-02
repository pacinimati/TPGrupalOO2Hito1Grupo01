# TPGrupalOO2Hito1Grupo01
Número de grupo: 
01

## 💻 Integrantes del grupo (nombre, apellido y usuario GitHub):
-Matias Pacini - pacinimati
-Alejo Almirón - alejoalmiron
-Rodrigo Mercado - RodriMercado
-Rodrigo Fernandez - Roi-123

## CASOS DE USO
CASO DE USO 1: RECAUDACIÓN DE UNIDAD DE VENTA - Matias Pacini
CASO DE USO 2: TRAER EMPLEADOS POR UNIDAD VENTA - Matias Pacini
CASO DE USO 3: TRAER PLATOS MENORES A $ - Rodrigo Mercado
CASO DE USO 4: PEDIDOS QUE CONTIENEN - Rodrigo Mercado
CASO DE USO 5: TRAER EL ULTIMO PEDIDO REALIZADO - Rodrigo Mercado
CASO DE USO 6: FESTIVAL CON UNIDADES - Alejo Almiron
CASO DE USO 7: PLATOS OFRECIDOS POR UNIDAD DE VENTA - Alejo Almiron
CASO DE USO 8: PLATO MÁS VENDIDO POR TIPO DE UNIDAD - Rodrigo Fernandez
CASO DE USO 9: COSTO DE SUELDOS DE UN FESTIVAL - Rodrigo Fernandez


## Guia para importar el proyecto en Eclipse
Paso 1: Clonar el repositorio y abrir Eclipse

1. Clona el repositorio en tu PC mediante GitHub Desktop o terminal.
2. Abre Eclipse.

Paso 2: Importar la carpeta

1. En el menu superior, ve a File -> Import...
2. Despliega la carpeta General y elige "Projects from Folder or Archive" (no uses Existing Projects into Workspace).
3. Toca el boton Directory..., selecciona la carpeta del proyecto que clonaste y dale a Finish.

Paso 3: Configurar Java y los JARs (Build Path)

1. En el Package Explorer, haz click derecho sobre el proyecto y elige Properties.
2. En el menu de la izquierda, selecciona Java Build Path y ve a la pestana Libraries.
3. Selecciona la carpeta Classpath marcandola en gris:
* Agregar Java: Toca Add Library... -> JRE System Library -> Next -> Elige Workspace default JRE (o Java 11/17) -> Finish.
* Agregar librerias externas: Toca Add External JARs... -> Selecciona todos los archivos .jar de Hibernate/MySQL guardados en tu PC -> Open.


4. Haz click en Apply and Close.

Paso 4: Limpiar el proyecto

1. En el menu superior de Eclipse, ve a Project -> Clean...
2. Marca el proyecto y dale a Clean.

Nota importante para el equipo:
Los archivos de entorno local (.project, .classpath y .settings/) estan ignorados en el .gitignore. Cada uno los genera localmente en su PC, por lo que nunca los vas a ver en la pestana de cambios de GitHub Desktop ni se van a desconfigurar al hacer pull o push.

## BASE DE DATOS MySql
1. Primero ejecutar el test de conexion a la bd asi crea las tablas correspondientes.
2. Rellar las bases de datos con los datos incluidos en el archivo sql.
