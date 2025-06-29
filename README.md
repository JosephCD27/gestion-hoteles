# 🏨 API de Gestión de Hoteles

Este proyecto expone un conjunto de endpoints REST para manejar usuarios, hoteles, habitaciones y sus respectivos estados y tipos. Usa autenticación basada en JWT.

---

## 🔐 Auth

### 🔸 Login

**POST** `/auth/login`

```json
{
  "username": "prueba",
  "password": "123456"
}
```

### 🔸 Registro

**POST** `/auth/register`

```json
{
  "username": "prueba1",
  "password": "123456"
}
```

> ⚠️ **Nota**: Las rutas siguientes requieren el token JWT que se obtiene tras hacer login.

---

## 📁 CRUDs

### 🏨 Hoteles

- **Listar todos**
  ```
  GET /api/hoteles/all
  ```

- **Buscar por ID**
  ```
  GET /api/hoteles/{id}
  ```

- **Crear**
  ```
  POST /api/hoteles
  ```
  ```json
  {
    "hotel_nombre": "nombre_hotel",
    "hotel_direccion": "hotel_direccion",
    "hotel_ciudad": "hotel_ciudad"
  }
  ```

- **Actualizar**
  ```
  PUT /api/hoteles/{id}
  ```
  ```json
  {
    "hotel_id": 1,
    "hotel_nombre": "hotel_nombre",
    "hotel_direccion": "hotel_direccion",
    "hotel_ciudad": "ciudad"
  }
  ```

- **Eliminar**
  ```
  DELETE /api/hoteles/{id}
  ```

---

### 🛏️ Habitaciones

- **Listar todos**
  ```
  GET /api/habitaciones/all
  ```

- **Buscar por ID**
  ```
  GET /api/habitaciones/{id}
  ```

- **Crear**
  ```
  POST /api/habitaciones
  ```
  ```json
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
  ```

- **Actualizar**
  ```
  PUT /api/habitaciones/{id}
  ```
  ```json
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
  ```

- **Eliminar**
  ```
  DELETE /api/habitaciones/{id}
  ```

---

### ✅ Estados de Habitación

- **Listar todos**
  ```
  GET /api/estado-habitacion/all
  ```

- **Buscar por ID**
  ```
  GET /api/estado-habitacion/{id}
  ```

---

### 🏷️ Tipos de Habitación

- **Listar todos**
  ```
  GET /api/tipo-habitacion/all
  ```

- **Buscar por ID**
  ```
  GET /api/tipo-habitacion/{id}
  ```

---

> 📌 Asegúrate de incluir el token JWT en el header de autorización:
```
Authorization: Bearer {tu_token}
```
