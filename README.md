RUTAS DE API
==============================================================================
AUTH:
  -----------  LOGIN -------------------------------
    POST - http://localhost:8080/auth/login
    {
      "username": "prueba",
      "password": "123456"
    }

--------------- REGISTRO --------------------------
    POST - http://localhost:8080/auth/register
    {
      "username": "prueba1",
      "password": "123456"
    }
    
===============================================================================
**NOTA:** las siguentes rutas requiere el token suministrado por JWT
          usa la ruta de login para obtener un token

CRUDs:
  ------------------  HOTELES  -------------------
  **LISTAR**
      GET - http://localhost:8080/api/hoteles/all
      
  **BUSCAR POR ID**
      GET - http://localhost:8080/api/hoteles/{id}
      
  **CREAR**
      POST - http://localhost:8080/api/hoteles
      {
        "hotel_nombre": "nombre_hotel",
        "hotel_direccion": "hotel_direccion",
        "hotel_ciudad": "hotel_ciudad"
      }
      
  **ACTUALIZAR**
      PUT - http://localhost:8080/api/hoteles/{id}
        {
          "hotel_id": {id},
          "hotel_nombre": "hotel_nombre",
          "hotel_direccion": "hotel_direccion",
          "hotel_ciudad": "ciudad"
        }
        
  **ELIMINAR**
      DELETE - http://localhost:8080/api/hoteles/{id}

  
  ------------------  HABITACIONES  -------------------
  **LISTAR**
      GET - http://localhost:8080/api/habitaciones/all
      
  **BUSCAR POR ID**
      GET - http://localhost:8080/api/habitaciones/{id}
      
  **CREAR**
      POST - http://localhost:8080/api/habitaciones
      {
          "habitacion_capacidad": 2,
          "habitacion_piso": 1,
          "hotel": {
              "hotel_id": 2
          },
          "tipoHabitacion": {
              "tipo_hab_id": 1
          },
          "estadoHabitacion": {
              "estado_hab_id": 1
          }
      }
      
  **ACTUALIZAR**
      PUT - http://localhost:8080/api/habitaciones/{id}
      {
          "habitacion_id": 4,
          "habitacion_consecutivo": "A101",
          "habitacion_capacidad": 4,
          "habitacion_piso": 1,
          "hotel": {
            "hotel_id": 2
          },
          "tipoHabitacion": {
            "tipo_hab_id": 3
          },
        "estadoHabitacion": {
          "estado_hab_id": 2
        }
    }
      
  **ELIMINAR**
      DELETE - http://localhost:8080/api/habitaciones/{id}
      
  ------------------ ESTADOS DE HABITACION  -------------------
  **LISTAR**
      GET - http://localhost:8080/api/estado-habitacion/all

  **BUSCAR POR ID**
      GET - http://localhost:8080/api/estado-habitacion/{id}

  ------------------ TIPOS DE HABITACION  -------------------
  **LISTAR**
      GET - http://localhost:8080/api/tipo-habitacion/all

  **BUSCAR POR ID**
      GET - http://localhost:8080/api/tipo-habitacion/{id}

    
